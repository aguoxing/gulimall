package com.gulimall.modules.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 监控中心
 *
 * @author ruoyi
 */
@EnableAdminServer
@SpringBootApplication
public class RunMonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunMonitorApplication.class, args);
        System.out.println("监控中心启动成功");
    }
}
