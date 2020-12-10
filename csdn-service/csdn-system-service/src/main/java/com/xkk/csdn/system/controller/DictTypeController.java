package com.xkk.csdn.system.controller;


import com.xkk.csdn.core.web.result.BaseResponse;
import com.xkk.csdn.system.controller.cmd.DictTypeRequestParams;
import com.xkk.csdn.system.entity.DictType;
import com.xkk.csdn.system.service.IDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 字典类型表 前端控制器
 * </p>
 *
 * @author xkk
 * @since 2020-12-01
 */
@RestController
@RequestMapping("/system/dict-type")
public class DictTypeController {

    @Autowired
    IDictTypeService dictTypeService;

    /**
     *
     * 后台添加字典
     * @param
     * @return
     */
    @PostMapping("addDictType")
    public BaseResponse<Boolean> addDictType(@Validated @RequestBody DictTypeRequestParams dictTypeRequestParams) {
        return BaseResponse.status(dictTypeService.submit(DictType.builder().dictType(dictTypeRequestParams.getDictType()).dictName(dictTypeRequestParams.getDictName()).build()));
    }

}

