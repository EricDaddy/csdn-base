package com.xkk.csdn.user.mapper;

import com.xkk.csdn.user.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 后台管理员角色表 Mapper 接口
 * </p>
 *
 * @author xkk
 * @since 2020-12-03
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> selectRoleByUser(String username);
}
