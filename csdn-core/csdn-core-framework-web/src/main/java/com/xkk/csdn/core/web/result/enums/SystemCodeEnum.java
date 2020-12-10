package com.xkk.csdn.core.web.result.enums;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2020/12/2 10:58
 */
public enum SystemCodeEnum {

    SYSTEM_SUCCESS(200,"success"),
    SYSTEM_ERROR(500,"服务器错误"),
    PARAM_VALID_ERROR(1001,"参数校验失败");


    SystemCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
