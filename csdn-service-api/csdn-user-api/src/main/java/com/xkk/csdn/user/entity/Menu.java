package com.xkk.csdn.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import com.xkk.csdn.core.web.dataobject.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author xkk
 * @since 2020-12-04
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@TableName("csdn_sys_menu")
public class Menu extends BaseEntity<Menu>{

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单编码
     */
    private String menuCode;

    /**
     * 父级菜单编码
     */
    private String parentId;

    /**
     * 所有父级菜单编码
     */
    private String parentIds;

    /**
     * 类型 0菜单 1权限
     */
    private String type;

    /**
     * 菜单跳转链接
     */
    private String href;

    /**
     * 菜单权限标识
     */
    private String permissionValue;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否展示。0-隐藏；1-显示
     */
    private String isShow;


}
