package com.gulimall.file.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gwoksing
 * @date 2022/5/26 16:04
 */

@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioPropertiesConfig {

    /**
     * 端点
     */
    private String endpoint;
    /**
     * 用户名
     */
    private String accessKey;
    /**
     * 密码
     */
    private String secretKey;

    /**
     * 桶名称
     */
    private String bucketName;
}
