package com.gulimall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 优惠券服务
 *
 * @author admin
 */
@SpringBootApplication
public class RunCouponApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunCouponApplication.class, args);
        System.out.println("优惠券服务启动成功");
    }
}
