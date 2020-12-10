package com.xkk.csdn.user.config;

import cn.hutool.core.collection.CollectionUtil;
import com.xkk.csdn.core.web.constants.AuthConstants;
import com.xkk.csdn.user.dto.ResourceRoleDTO;
import com.xkk.csdn.user.mapper.MenuMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2020/12/10 16:18
 */
@Component
@Slf4j
public class InitResourceRolesMapCacheRunner implements CommandLineRunner {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    MenuMapper menuMapper;


    @Override
    public void run(String... args){
        log.info("InitResourceRolesMapCacheRunner run");
        //删除redis中缓存的权限
        redisTemplate.delete(AuthConstants.RESOURCE_ROLE);

        List<ResourceRoleDTO> resourceRoleDTOS = menuMapper.listForResourceRole();
        Map<String,List<String>> resourceRolesMap = new TreeMap<>();

        Optional.ofNullable(resourceRoleDTOS).orElse(new ArrayList<>()).forEach(resourceRoleDTO -> {

            List<String> roleCodes = Optional.ofNullable(resourceRoleDTO.getRoleCodes()).orElse(new ArrayList<>())
                    .stream().map(roleCode -> AuthConstants.AUTHORITY_PREFIX + roleCode).collect(Collectors.toList());

            if(CollectionUtil.isNotEmpty(roleCodes)) {
                resourceRolesMap.put(resourceRoleDTO.getPermissionValue(),roleCodes);
            }

            redisTemplate.opsForHash().putAll(AuthConstants.RESOURCE_ROLE,resourceRolesMap);
        });





    }
}
