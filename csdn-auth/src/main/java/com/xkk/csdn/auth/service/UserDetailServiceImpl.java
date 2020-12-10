package com.xkk.csdn.auth.service;

import com.xkk.csdn.auth.entity.JwtUser;
import com.xkk.csdn.core.web.dataobject.FeignResult;
import com.xkk.csdn.user.dto.UserDTO;
import com.xkk.csdn.user.feign.UserFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 功能描述：
 * 自定义用户信息查询接口
 * @Author: XKK
 * @Date: 2020/12/9 10:41
 */
@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {


    private UserFeignClient userFeignClient;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JwtUser user = null;
        FeignResult<UserDTO> result =  userFeignClient.loadUserByUserName(username);
        if(result.getCode().equals("00000")) {
            user = new JwtUser(result.getData());
        }
        return user;
    }
}
