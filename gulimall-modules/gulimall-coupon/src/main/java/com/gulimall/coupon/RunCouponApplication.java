package com.gulimall.coupon;

import com.gulimall.common.security.annotation.EnableCustomConfig;
import com.gulimall.common.security.annotation.EnableRyFeignClients;
import com.gulimall.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 优惠券服务
 *
 * @author admin
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class RunCouponApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunCouponApplication.class, args);
        System.out.println("优惠券服务启动成功");
    }
}
