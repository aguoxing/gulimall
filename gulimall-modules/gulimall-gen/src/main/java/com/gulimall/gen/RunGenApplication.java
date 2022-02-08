package com.gulimall.gen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.gulimall.common.security.annotation.EnableCustomConfig;
import com.gulimall.common.security.annotation.EnableRyFeignClients;
import com.gulimall.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 代码生成
 * 
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2   
@EnableRyFeignClients
@SpringBootApplication
public class RunGenApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(RunGenApplication.class, args);
        System.out.println("代码生成模块启动成功");
    }
}
