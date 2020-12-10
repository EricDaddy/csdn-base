package com.xkk.csdn.user.service;

import com.xkk.csdn.user.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xkk
 * @since 2020-12-04
 */
public interface IMenuService extends IService<Menu> {

    boolean submit(Menu menu);
}
