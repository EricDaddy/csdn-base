package com.xkk.csdn.user.service.impl;

import com.xkk.csdn.user.entity.UserRole;
import com.xkk.csdn.user.mapper.UserRoleMapper;
import com.xkk.csdn.user.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台管理员用户角色表 服务实现类
 * </p>
 *
 * @author xkk
 * @since 2020-12-03
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
