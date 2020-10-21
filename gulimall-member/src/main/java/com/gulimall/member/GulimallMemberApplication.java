package com.gulimall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 1、想要远程调用别的服务
 * 引入open-feign
 * 编写一个接口，告诉SpringCloud这个接口需要调用远程服务
 * 声明接口的每一个方法都是调用哪个远程服务的那个请求
 * 开启远程调用功能
 *
 * @author guoxing
 * @date 2020/10/21 14:34
 */
@EnableFeignClients(basePackages = "com.gulimall.member.feign")
@MapperScan("com.gulimall.member.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallMemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(GulimallMemberApplication.class, args);
    }
}