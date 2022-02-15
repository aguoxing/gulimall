package com.gulimall.ware;

import com.gulimall.common.security.annotation.EnableCustomConfig;
import com.gulimall.common.security.annotation.EnableRyFeignClients;
import com.gulimall.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 仓储服务
 *
 * @author admin
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class RunWareApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunWareApplication.class, args);
        System.out.println("仓储服务启动成功");
    }
}
