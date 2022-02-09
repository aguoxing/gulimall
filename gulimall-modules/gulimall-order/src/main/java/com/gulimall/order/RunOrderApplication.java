package com.gulimall.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 订单服务
 *
 * @author admin
 */
@SpringBootApplication
public class RunOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunOrderApplication.class, args);
        System.out.println("订单服务启动成功");
    }
}
