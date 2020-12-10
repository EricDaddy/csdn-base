package com.xkk.csdn.user.service.impl;

import com.xkk.csdn.user.entity.Role;
import com.xkk.csdn.user.mapper.RoleMapper;
import com.xkk.csdn.user.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台管理员角色表 服务实现类
 * </p>
 *
 * @author xkk
 * @since 2020-12-03
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
