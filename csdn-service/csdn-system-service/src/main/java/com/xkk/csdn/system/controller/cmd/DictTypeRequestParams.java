package com.xkk.csdn.system.controller.cmd;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2020/12/2 10:41
 */
@Data
public class DictTypeRequestParams {

    @NotBlank(message = "字典名字不能为空")
    private String dictName;

    @NotBlank(message = "字典类型不能为空")
    private String dictType;


}
