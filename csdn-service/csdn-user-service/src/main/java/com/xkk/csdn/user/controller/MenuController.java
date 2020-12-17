package com.xkk.csdn.user.controller;


import com.xkk.csdn.core.web.result.BaseResponse;
import com.xkk.csdn.user.controller.cmd.MenuRequestParams;
import com.xkk.csdn.user.entity.Menu;
import com.xkk.csdn.user.service.IMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xkk
 * @since 2020-12-04
 */
@RestController
@RequestMapping("/user/menu")
public class MenuController {

    @Autowired
    IMenuService menuService;

    @PostMapping("addMenu")
    public BaseResponse<Boolean> addMenu(@RequestBody MenuRequestParams menuParams) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuParams,menu);
        return BaseResponse.status(menuService.submit(menu));
    }




}

