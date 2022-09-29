package com.gulimall.common.core.bus.vo.product;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: admin
 */
@Data
public class SpuSaveVO {

    private String spuName;
    private String spuDescription;
    private Long catalogId;
    private Long brandId;
    private BigDecimal weight;
    private Integer publishStatus;
    /**
     * 保存spu描述图片
     */
    private List<String> decript;
    /**
     * 保存spu图片集
     */
    private List<String> images;
    private Bounds bounds;
    /**
     * 保存spu基本参数
     */
    private List<BaseAttrs> baseAttrs;
    private List<Skus> skus;//

}
