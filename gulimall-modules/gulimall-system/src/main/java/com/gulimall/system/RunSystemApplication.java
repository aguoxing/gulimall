package com.gulimall.system;

import com.gulimall.common.security.annotation.EnableCustomConfig;
import com.gulimall.common.security.annotation.EnableRyFeignClients;
import com.gulimall.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 系统模块
 *
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class RunSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunSystemApplication.class, args);
        System.out.println("系统模块启动成功");
    }
}
