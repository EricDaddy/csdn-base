package com.xkk.csdn.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2020/12/1 13:44
 */
@SpringBootApplication(scanBasePackages = "com.xkk.csdn.*")
@EnableDiscoveryClient
@EnableSwagger2
public class SystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class,args);
    }


}
