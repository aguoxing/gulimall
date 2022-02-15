package com.gulimall.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 检索服务
 *
 * @author admin
 */
@SpringBootApplication
public class RunSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunSearchApplication.class, args);
        System.out.println("检索服务启动成功");
    }
}
