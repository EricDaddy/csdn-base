package com.xkk.csdn.user.feign;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xkk.csdn.core.web.dataobject.FeignResult;
import com.xkk.csdn.core.web.enums.FeignResultCode;
import com.xkk.csdn.user.dto.UserDTO;
import com.xkk.csdn.user.entity.User;
import com.xkk.csdn.user.entity.UserRole;
import com.xkk.csdn.user.service.IUserRoleService;
import com.xkk.csdn.user.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2020/12/9 10:56
 */
@RestController
@RequestMapping("/user/feign")
public class UserFeignRest {

    @Autowired
    IUserService userService;

    @Autowired
    IUserRoleService userRoleService;

    @GetMapping("/loadByUsername")
    public FeignResult<UserDTO> loadUserByUsername(
            @RequestParam(value = "username",required = true) String username) {
        User user = userService.loadByUsername(username);
        if(ObjectUtil.isEmpty(user)) {
            return FeignResult.failed(FeignResultCode.USER_NOT_EXIST);
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        List<String> roles = userRoleService.list(new LambdaQueryWrapper<UserRole>().eq(UserRole::getUsername,username))
                .stream().map(UserRole::getRoleCode).collect(Collectors.toList());
        userDTO.setRoles(roles);
        return FeignResult.success(userDTO);
    }


}
