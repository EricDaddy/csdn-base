package com.xkk.csdn.user.controller;


import com.xkk.csdn.core.web.result.BaseResponse;
import com.xkk.csdn.user.entity.Role;
import com.xkk.csdn.user.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 后台管理员角色表 前端控制器
 * </p>
 *
 * @author xkk
 * @since 2020-12-03
 */
@RestController
@RequestMapping("/system/role")
public class RoleController {

    @Autowired
    IRoleService roleService;

    @GetMapping("listRole")
    public BaseResponse<List<Role>> listRole() {
        return new BaseResponse<>(roleService.list());
    }

}

