package com.gulimall.cart;

import com.gulimall.common.security.annotation.EnableCustomConfig;
import com.gulimall.common.security.annotation.EnableRyFeignClients;
import com.gulimall.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 购物车服务
 *
 * @author admin
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class RunCartApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunCartApplication.class, args);
        System.out.println("购物车服务启动成功");
    }
}
