package com.gulimall.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.gulimall.common.security.annotation.EnableCustomConfig;
import com.gulimall.common.security.annotation.EnableRyFeignClients;
import com.gulimall.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 定时任务
 * 
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2   
@EnableRyFeignClients
@SpringBootApplication
public class RunJobApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(RunJobApplication.class, args);
        System.out.println("定时任务模块启动成功");
    }
}
