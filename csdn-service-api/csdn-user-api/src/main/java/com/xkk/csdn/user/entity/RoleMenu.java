package com.xkk.csdn.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import com.xkk.csdn.core.web.dataobject.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 后台角色菜单权限表
 * </p>
 *
 * @author xkk
 * @since 2020-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("csdn_sys_role_menu")
public class RoleMenu extends BaseEntity<RoleMenu> {

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 菜单id
     */
    private Long menuId;

}
