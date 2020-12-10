package com.xkk.csdn.core.web.constants;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2020/12/9 16:10
 */
public class AuthConstants {

    /**
     * JWT存储权限前缀
     */
    public static String AUTHORITY_PREFIX = "ROLE_";

    /**
     * JWT存储权限属性
     */
    public static String AUTHORITY_CLAIM_NAME = "authorities";

    public static String SYSTEM_URL = "/csdn-system-service/*";

    /**
     * 认证信息Http请求头
     */
    public static String JWT_TOKEN_HEADER = "Authorization";

    /**
     * redis中缓存的资源对应角色键值Key
     */
    public static String RESOURCE_ROLE = "resource_role";
}
