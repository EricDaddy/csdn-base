package com.xkk.csdn.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2020/12/8 10:15
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/oauth/**")
                .authorizeRequests()
                .antMatchers("/oauth/**").permitAll()
                .antMatchers("/auth/public_key").permitAll()
                .and()
                .csrf()
                .disable();
    }
}
