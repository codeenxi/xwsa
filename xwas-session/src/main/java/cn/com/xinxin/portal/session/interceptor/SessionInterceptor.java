package cn.com.xinxin.portal.session.interceptor;

import cn.com.xinxin.portal.session.BizResultCodeEnum;
import cn.com.xinxin.portal.session.repository.UserAclSessionRepository;
import com.xinxinfinance.commons.exception.BusinessException;
import com.xinxinfinance.commons.util.ApplicationContextHolder;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/**
 * @author dengyunhui
 * @created 2018/12/26 11:51
 * @updated
 * @description
 **/
public class SessionInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Method method = methodInvocation.getMethod();
        if (Modifier.isPublic(method.getModifiers()) && methodInvocation.getArguments() != null && methodInvocation.getArguments().length > 0){
            for (Object argument : methodInvocation.getArguments()) {
                if (argument instanceof HttpServletRequest){
                    HttpServletRequest request = (HttpServletRequest) argument;
                    if (request.getRequestedSessionId() != null){
                        UserAclSessionRepository userAclSessionRepository = (UserAclSessionRepository) ApplicationContextHolder.getBean("userAclSessionRepository");
                        boolean exist = userAclSessionRepository.exist(request.getRequestedSessionId());
                        if (exist){
                            //session 存在，更新session超时时间
                            userAclSessionRepository.updatePortalUserSession(request.getRequestedSessionId());
                            return methodInvocation.proceed();
                        }else {
                            //session 超时
                            /*Type returnType = method.getGenericReturnType();
                            if (returnType.getTypeName().equals("java.lang.String")){
                                return "login";
                            }else if (returnType.getTypeName().equals("org.springframework.web.servlet.ModelAndView")) {
                                ModelAndView mav = new ModelAndView("login");
                                return mav;
                            }*/
                            throw new BusinessException(BizResultCodeEnum.NO_EXIST_SESSION);
                        }
                    }
                }
            }
        }

        return methodInvocation.proceed();
    }
}
