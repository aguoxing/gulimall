package com.gulimall.file.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author gwoksing
 * @date 2022/5/26 16:05
 */
@Data
@ToString
public class MinioDTO {
    private String path;
    private String objName;
}
