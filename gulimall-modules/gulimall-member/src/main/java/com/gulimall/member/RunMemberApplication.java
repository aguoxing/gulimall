package com.gulimall.member;

import com.gulimall.common.security.annotation.EnableCustomConfig;
import com.gulimall.common.security.annotation.EnableRyFeignClients;
import com.gulimall.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 会员服务
 *
 * @author admin
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class RunMemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunMemberApplication.class, args);
        System.out.println("会员服务启动成功");
    }
}
