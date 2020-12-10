package com.xkk.csdn.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import com.xkk.csdn.core.web.dataobject.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 后台管理员用户角色表
 * </p>
 *
 * @author xkk
 * @since 2020-12-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("csdn_sys_user_role")
public class UserRole extends BaseEntity<UserRole> {
    /**
     * 用户名
     */
    private String username;

    /**
     * 角色编码
     */
    private String roleCode;

}
