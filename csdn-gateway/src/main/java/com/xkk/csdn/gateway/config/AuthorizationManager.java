package com.xkk.csdn.gateway.config;



import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.xkk.csdn.core.web.constants.AuthConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * 功能描述：网关鉴权管理器
 *
 * @Author: XKK
 * @Date: 2020/12/9 15:47
 */
@Component
@Slf4j
public class AuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {

     @Autowired
     private RedisTemplate redisTemplate;


    /**
     * 请求检验
     * @param mono
     * @param authorizationContext
     * @return
     */
    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        ServerHttpRequest request = authorizationContext.getExchange().getRequest();
        String path = request.getURI().getPath();
        //路径匹配检验
        PathMatcher pathMatcher = new AntPathMatcher();

        //跨域的预检请求放行
        if(request.getMethod() == HttpMethod.OPTIONS) {
            return mono.just(new AuthorizationDecision(true));
        }

        //对于非管控平台请求放行
        if(pathMatcher.match(AuthConstants.SYSTEM_URL,path)) {
            return mono.just(new AuthorizationDecision(true));
        }

        //token为空拒绝访问
        String token = request.getHeaders().getFirst(AuthConstants.JWT_TOKEN_HEADER);
        if(StrUtil.isBlank(token)) {
            return mono.just(new AuthorizationDecision(false));
        }

        //获取资源权限角色关联表（管控平台启动时缓存到redis中）
        Map<Object,Object> resourceRoleMap = redisTemplate.opsForHash().entries(AuthConstants.RESOURCE_ROLE);

        //获取当前请求资源所需的权限集合
        Iterator<Object> iterator = resourceRoleMap.keySet().iterator();
        List<String> authorities = new ArrayList<>();
        while (iterator.hasNext()) {
            String pattern = (String) iterator.next();
            if(pathMatcher.match(pattern,path)) {
                authorities.addAll(Convert.toList(String.class, resourceRoleMap.get(pattern)));
            }
        }

        Mono<AuthorizationDecision> authorizationDecisionMono = mono
                .filter(Authentication::isAuthenticated)
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority)
                .any(roleId -> {
                     //roleId是请求用户的角色(格式:ROLE_{roleId})，authorities是请求资源所需要角色的集合
                    log.info("访问路径：{}", path);
                    log.info("用户角色信息：{}", roleId);
                    log.info("资源需要权限authorities：{}", authorities);
                    return authorities.contains(roleId);
                })
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(new AuthorizationDecision(false));
        return authorizationDecisionMono;





    }
}
