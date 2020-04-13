package cn.com.xinxin.portal.api;

import cn.com.xinxin.portal.api.model.UserDTO;
import cn.com.xinxin.portal.api.enums.XPortalResultCodeEnum;
import com.xinxinfinance.commons.api.result.generic.SingleResult;

/**
 * Created by dengyunhui on 2018/5/21
 **/
public interface XPortalUserFacade {

    /**
     * 根据sessionId获取当前登录的用户信息
     * @param sessionId
     * @return
     */
    SingleResult<XPortalResultCodeEnum,UserDTO> getLoginUser(String sessionId);

    /**
     * 当前登陆用户对某个路径是否有权限
     * @param sessionId
     * @param url
     * @return
     */
    SingleResult<XPortalResultCodeEnum,Boolean> hasPermission(String sessionId, String url);
}