package com.xkk.csdn.user.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xkk.csdn.core.web.exception.ApiException;
import com.xkk.csdn.user.entity.Menu;
import com.xkk.csdn.user.mapper.MenuMapper;
import com.xkk.csdn.user.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xkk
 * @since 2020-12-04
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public boolean submit(Menu menu) {
        //判断当前菜单编码和权限标识是否唯一
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("menu_code",menu.getMenuCode()).or().eq("permission_value",menu.getPermissionValue());
        Integer cnt = menuMapper.selectCount(ObjectUtil.isEmpty(menu.getId())? queryWrapper : queryWrapper.notIn("id",menu.getId()));
        if(cnt > 0) {
            throw new ApiException("当前菜单编码或权限标识已存在");
        }
        if(ObjectUtil.isEmpty(menu.getParentId())) {
            menu.setParentId(0L);
            menu.setParentIds("0");
        } else {
            Menu parentMenu = menuMapper.selectById(menu.getParentId());
            menu.setParentIds(parentMenu.getParentIds().concat(","+menu.getParentId()));
        }
        return saveOrUpdate(menu);


    }
}
