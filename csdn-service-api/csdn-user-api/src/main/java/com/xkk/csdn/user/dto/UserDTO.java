package com.xkk.csdn.user.dto;

import lombok.Data;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2020/12/9 11:19
 */
@Data
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private String status;
    private String clientId;
    private List<String> roles;
}
