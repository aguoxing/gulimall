package com.gulimall.auth;

import com.gulimall.common.security.annotation.EnableRyFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 认证授权中心
 *
 * @author ruoyi
 */
@EnableRyFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RunAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunAuthApplication.class, args);
        System.out.println("认证授权中心启动成功");
    }
}
