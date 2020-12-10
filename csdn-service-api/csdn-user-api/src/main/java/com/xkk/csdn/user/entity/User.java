package com.xkk.csdn.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xkk.csdn.core.web.dataobject.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 后台管理员用户表
 * </p>
 *
 * @author xkk
 * @since 2020-12-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("csdn_sys_user")
public class User extends BaseEntity<User> {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private String gender;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 自我简介
     */
    private String summary;

    /**
     * 登录次数
     */
    private Integer loginCount;

    /**
     * 最后登录时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;

    /**
     * 最后登录ip地址
     */
    private String lastLoginIp;

    /**
     * 备注
     */
    private String remark;


}
