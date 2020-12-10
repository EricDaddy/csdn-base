package com.xkk.csdn.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xkk.csdn.user.entity.User;
import com.xkk.csdn.user.mapper.UserMapper;
import com.xkk.csdn.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台管理员用户表 服务实现类
 * </p>
 *
 * @author xkk
 * @since 2020-12-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User loadByUsername(String username) {
        return getOne(new LambdaQueryWrapper<User>().eq(User::getUsername,username));
    }
}
