package com.gulimall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 商品服务
 *
 * @author admin
 */
@SpringBootApplication
public class RunProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunProductApplication.class, args);
        System.out.println("商品服务启动成功");
    }
}
