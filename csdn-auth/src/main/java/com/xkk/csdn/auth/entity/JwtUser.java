package com.xkk.csdn.auth.entity;

import cn.hutool.core.util.ObjectUtil;
import com.xkk.csdn.user.dto.UserDTO;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2020/12/9 13:48
 */
@Data
public class JwtUser implements UserDetails {

    private Long id;

    private String username;

    private String password;

    private Boolean enabled;

//    private String clientId;

    private Collection<SimpleGrantedAuthority> authorities;

    //UserDTO构造函数
    public JwtUser(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.username = userDTO.getUsername();
        this.password = userDTO.getPassword();
        this.enabled = userDTO.getStatus().equals("0");
        if(userDTO.getRoles() != null) {
            authorities = new ArrayList<>();
            userDTO.getRoles().forEach(roleCode -> authorities.add(new SimpleGrantedAuthority(roleCode)));
        }
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }



}
