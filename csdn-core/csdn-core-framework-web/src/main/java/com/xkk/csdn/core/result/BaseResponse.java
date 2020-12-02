package com.xkk.csdn.core.result;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.xkk.csdn.core.result.enums.SystemCodeEnum;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2020/12/2 10:56
 */
public class BaseResponse<T> {

    /**
     * 状态码
     */
    private int code;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应体
     */
    private T data;

    public BaseResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResponse(T data) {
        this(SystemCodeEnum.SYSTEM_SUCCESS.getCode(),SystemCodeEnum.SYSTEM_SUCCESS.getMsg(),data);
    }

    public static BaseResponse status(boolean flag) {
        return flag ? new BaseResponse<>(SystemCodeEnum.SYSTEM_SUCCESS.getCode(),SystemCodeEnum.SYSTEM_SUCCESS.getMsg()) : new BaseResponse<>(SystemCodeEnum.SYSTEM_ERROR.getCode(),SystemCodeEnum.SYSTEM_ERROR.getMsg());
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
