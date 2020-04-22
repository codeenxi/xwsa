package cn.com.xinxin.sass.auth.shiro.filter;

import cn.com.xinxin.sass.auth.model.JWTToken;
import cn.com.xinxin.sass.auth.protocol.SessionBizResultCodeEnum;
import cn.com.xinxin.sass.auth.repository.UserAclTokenRepository;
import cn.com.xinxin.sass.auth.utils.HttpRequestUtil;
import com.xinxinfinance.commons.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: zhouyang
 * @created: 13/04/2020.
 * @updater:
 * @description:
 */
public class JWTTokenFilter extends AuthenticatingFilter {

    private static String UTF8 = "UTF-8";
    private static String CONTENT_TYPE = "application/json";

    private static final Logger log = LoggerFactory.getLogger(JWTTokenFilter.class);


    private UserAclTokenRepository userAclTokenRepository;

    public UserAclTokenRepository getUserAclTokenRepository() {
        return userAclTokenRepository;
    }

    public void setUserAclTokenRepository(UserAclTokenRepository userAclTokenRepository) {
        this.userAclTokenRepository = userAclTokenRepository;
    }

    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest,
                                              ServletResponse servletResponse) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String loginToken = HttpRequestUtil.getLoginToken(httpServletRequest);
        if(StringUtils.isBlank(loginToken)){
            return null;
        }
        return new JWTToken(loginToken);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        try {
            executeLogin(request, response);
            return true;
        } catch (Exception e) {
            unauthorized(response);
            return false;
        }
    }


    @Override
    protected boolean  onAccessDenied(ServletRequest request, ServletResponse response) throws Exception{
        HttpServletResponse httpResponse = WebUtils.toHttp(response);
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json;charset=utf-8");
        httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        return false;
    }


    /**
     * 认证
     */
    @Override
    protected boolean executeLogin(ServletRequest request,
                                   ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String authorization = HttpRequestUtil.getLoginToken(httpServletRequest);
        JWTToken token = new JWTToken(authorization);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        getSubject(request, response).login(token);
        return true;
    }


    /**
     * 认证失败 跳转到 /unauthorized
     */
    private void unauthorized(ServletResponse resp) {
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
            httpServletResponse.sendRedirect("/unauthorized");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }


    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken authenticationToken,
                                     Subject subject,
                                     ServletRequest request,
                                     ServletResponse response) throws Exception {
        // 如果登陆成功，则需要刷新对应的token缓存信息，同时要判断token是否失效
        String url = WebUtils.toHttp(request).getRequestURI();
        log.info("鉴权成功,token:{},url:{}", authenticationToken, url);
        JWTToken jwtToken = (JWTToken)authenticationToken;
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        userAclTokenRepository.refreshToken(jwtToken.getToken(),httpServletResponse);
        return true;
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token,
                                     AuthenticationException e,
                                     ServletRequest request,
                                     ServletResponse response) {

        log.error("登录失败，token:" + token + ",error:" + e.getMessage(), e);
        throw new BusinessException(SessionBizResultCodeEnum.NO_PERMISSION);
    }

}