package com.xkk.csdn.core.web.exception;

import com.xkk.csdn.core.web.result.enums.SystemCodeEnum;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2020/12/2 11:01
 */
public class ApiException extends RuntimeException {

    private int code;

    private String msg;

    ApiException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }


    public ApiException(String msg) {
        this(SystemCodeEnum.SYSTEM_ERROR.getCode(),msg);
    }

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
