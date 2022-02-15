package com.gulimall.order;

import com.gulimall.common.security.annotation.EnableCustomConfig;
import com.gulimall.common.security.annotation.EnableRyFeignClients;
import com.gulimall.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 订单服务
 *
 * @author admin
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class RunOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunOrderApplication.class, args);
        System.out.println("订单服务启动成功");
    }
}
