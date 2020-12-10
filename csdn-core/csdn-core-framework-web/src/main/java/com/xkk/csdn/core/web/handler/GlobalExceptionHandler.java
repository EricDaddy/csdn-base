package com.xkk.csdn.core.web.handler;

import com.xkk.csdn.core.web.exception.ApiException;
import com.xkk.csdn.core.web.result.BaseResponse;
import com.xkk.csdn.core.web.result.enums.SystemCodeEnum;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2020/12/2 11:03
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public BaseResponse<String> apiException(ApiException e) {
        return new BaseResponse<>(SystemCodeEnum.SYSTEM_ERROR.getCode(),SystemCodeEnum.SYSTEM_ERROR.getMsg(),e.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return  new BaseResponse<>(SystemCodeEnum.PARAM_VALID_ERROR.getCode(),SystemCodeEnum.PARAM_VALID_ERROR.getMsg(),objectError.getDefaultMessage());
    }
}
