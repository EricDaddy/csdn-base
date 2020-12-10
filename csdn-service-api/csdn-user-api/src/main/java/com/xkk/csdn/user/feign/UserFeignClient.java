package com.xkk.csdn.user.feign;

import com.xkk.csdn.core.web.dataobject.FeignResult;
import com.xkk.csdn.user.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2020/12/9 10:52
 */
@FeignClient("csdn-user-service")
public interface UserFeignClient {


    @GetMapping("/user/feign/loadByUsername")
    FeignResult<UserDTO> loadUserByUserName(@RequestParam String username);
}
