package com.xkk.csdn.user.service;

import com.xkk.csdn.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 后台管理员用户表 服务类
 * </p>
 *
 * @author xkk
 * @since 2020-12-03
 */
public interface IUserService extends IService<User> {

    User loadByUsername(String username);
}
