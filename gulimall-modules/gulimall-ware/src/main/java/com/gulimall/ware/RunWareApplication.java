package com.gulimall.ware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 仓储服务
 *
 * @author admin
 */
@SpringBootApplication
public class RunWareApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunWareApplication.class, args);
        System.out.println("仓储服务启动成功");
    }
}
