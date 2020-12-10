package com.xkk.csdn.user.mapper;

import com.xkk.csdn.user.dto.ResourceRoleDTO;
import com.xkk.csdn.user.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xkk
 * @since 2020-12-04
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    @Select(" select id,permission_value AS permissionValue from csdn_sys_menu ")
    @Results({
            @Result(id=true, column="id", property="id"),
            @Result(property = "roleCodes",column="id",many = @Many(select="com.xkk.csdn.user.mapper.RoleMenuMapper.selectRolesByMenu"))
    })
    List<ResourceRoleDTO> listForResourceRole();
}
