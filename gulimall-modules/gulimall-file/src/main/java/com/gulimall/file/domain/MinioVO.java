package com.gulimall.file.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author gwoksing
 * @date 2022/5/26 16:05
 */
@Data
@ToString
public class MinioVO {
    private String bucketName;
    private String filename;
    private String path;
    private String url;
    private String baseUrl;
}
