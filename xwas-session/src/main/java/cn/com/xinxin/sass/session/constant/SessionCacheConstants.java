package cn.com.xinxin.sass.session.constant;

/**
 * @author: zhouyang
 * @created: 16/07/2018.
 * @updater:
 * @description:
 */
public class SessionCacheConstants {

    /**
     * session cache key
     */
    public static final String XPORTAL_SHIRO_USER_SESSION_CACHE_KEY = "shiro_redis_session_manager:";

    /**
     * CHIRO_USER_CACHE_KEY
     */
    public static final String SHIRO_USER_CACHE_KEY = "shiro_cache:";

    /**
     * session默认超时时间, 分钟为单位
     */
    public static final Integer DEFAULT_SESSION_TIME_OUT = 2160;

    /**
     * 用户信息缓存
     */
    public static final String  PORTAL_USER_INFO_CACHE_KEY = "PORTAL_USER_INFO:";


}