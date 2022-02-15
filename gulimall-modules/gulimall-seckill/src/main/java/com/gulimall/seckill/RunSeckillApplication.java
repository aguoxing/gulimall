package com.gulimall.seckill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 秒杀服务
 *
 * @author admin
 */
@SpringBootApplication
public class RunSeckillApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunSeckillApplication.class, args);
        System.out.println("秒杀服务启动成功");
    }
}
