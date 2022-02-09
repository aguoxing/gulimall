package com.gulimall.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 第三方服务
 *
 * @author admin
 */
@SpringBootApplication
public class RunThirdPartyApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunThirdPartyApplication.class, args);
        System.out.println("第三方服务启动成功");
    }
}
