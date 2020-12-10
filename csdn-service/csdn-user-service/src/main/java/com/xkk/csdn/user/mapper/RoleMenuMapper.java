package com.xkk.csdn.user.mapper;

import com.xkk.csdn.user.entity.RoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 后台角色菜单权限表 Mapper 接口
 * </p>
 *
 * @author xkk
 * @since 2020-12-04
 */
@Mapper
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    /**
     * 根据菜单id获取权限集合
     * @param
     * @return
     */
    List<String> selectRolesByMenu(Long menuId);
}
