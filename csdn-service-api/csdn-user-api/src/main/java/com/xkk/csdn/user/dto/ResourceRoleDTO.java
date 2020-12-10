package com.xkk.csdn.user.dto;

import com.xkk.csdn.user.entity.RoleMenu;
import lombok.Data;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2020/12/10 16:27
 */
@Data
public class ResourceRoleDTO {

    private Long Id;

    private String permissionValue;

    private List<String> roleCodes;
}
