package com.gulimall.file.config;

import io.minio.MinioClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author gx
 * @date 2022/3/29 15:44
 */
@Configuration
@EnableConfigurationProperties(MinioPropertiesConfig.class)
public class MinioConfig {
    @Resource
    private MinioPropertiesConfig minioPropertiesConfig;

    /**
     * 初始化 MinIO 客户端
     */
    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(minioPropertiesConfig.getEndpoint())
                .credentials(minioPropertiesConfig.getAccessKey(), minioPropertiesConfig.getSecretKey())
                .build();
    }
}
