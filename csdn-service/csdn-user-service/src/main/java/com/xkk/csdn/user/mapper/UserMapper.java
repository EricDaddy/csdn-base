package com.xkk.csdn.user.mapper;

import com.xkk.csdn.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 后台管理员用户表 Mapper 接口
 * </p>
 *
 * @author xkk
 * @since 2020-12-03
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
