package com.gulimall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 会员服务
 *
 * @author admin
 */
@SpringBootApplication
public class RunMemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunMemberApplication.class, args);
        System.out.println("会员服务启动成功");
    }
}
