package com.xkk.csdn.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import com.xkk.csdn.core.web.dataobject.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 后台管理员角色表
 * </p>
 *
 * @author xkk
 * @since 2020-12-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("csdn_sys_role")
public class Role extends BaseEntity<Role> {

    /**
     * 用户名
     */
    private String roleCode;

    /**
     * 密码
     */
    private String roleName;

    /**
     * 性别
     */
    private String roleDesc;

    /**
     * 备注
     */
    private String remark;
}
