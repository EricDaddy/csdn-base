package com.xkk.csdn.core.mybatis.handler;


import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2020/12/2 10:23
 */
@Component
public class MybatisFillHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createBy","superAdmin",metaObject);
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateBy","superAdmin",metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateBy","superAdmin",metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
