package com.xkk.csdn.core.web.enums;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2020/12/9 11:02
 */
public enum FeignResultCode {

    SUCCESS("00000","服务调用正常"),
    SYSTEM_EXECUTION_ERROR("00001","系统执行出错"),

    USER_NOT_EXIST("10000","用户不存在"),

    USER_ACCESS_UNAUTHORIZED("20000","网关鉴权失败"),
    TOKEN_INVALID_OR_EXPIRED("20001","token已失效或过期");


    private String code;

    private String msg;

    FeignResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
