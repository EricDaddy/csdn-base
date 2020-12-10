package com.xkk.csdn.core.web.dataobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.xkk.csdn.core.web.enums.FeignResultCode;

import java.io.Serializable;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2020/12/9 10:59
 */

public class FeignResult<T> implements Serializable {

    private String code;

    private T data;

    private String msg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long total;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public static <T> FeignResult<T> success() {
        return success(null);
    }

    public static <T> FeignResult<T> success(T data) {
        FeignResultCode rce = FeignResultCode.SUCCESS;
        if (data instanceof Boolean && Boolean.FALSE.equals(data)) {
            rce = FeignResultCode.SYSTEM_EXECUTION_ERROR;
        }
        return result(rce, data);
    }


    public static <T> FeignResult<T> failed() {
        return result(FeignResultCode.SYSTEM_EXECUTION_ERROR.getCode(), FeignResultCode.SYSTEM_EXECUTION_ERROR.getMsg(), null);
    }

    public static <T> FeignResult<T> failed(String msg) {
        return result(FeignResultCode.SYSTEM_EXECUTION_ERROR.getCode(), msg, null);
    }

    public static <T> FeignResult<T> status(boolean status) {
        if (status) {
            return success();
        } else {
            return failed();
        }
    }

    public static <T> FeignResult<T> failed(FeignResultCode resultCode) {
        return result(resultCode.getCode(), resultCode.getMsg(), null);
    }

    private static <T> FeignResult<T> result(FeignResultCode resultCode, T data) {
        return result(resultCode.getCode(), resultCode.getMsg(), data);
    }

    private static <T> FeignResult<T> result(String code, String msg, T data) {
        FeignResult<T> result = new FeignResult<T>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    public static <T> FeignResult<T> success(T data, Long total) {
        FeignResult<T> result = new FeignResult();
        result.setCode(FeignResultCode.SUCCESS.getCode());
        result.setMsg(FeignResultCode.SUCCESS.getMsg());
        result.setData(data);
        result.setTotal(total);
        return result;
    }
}
