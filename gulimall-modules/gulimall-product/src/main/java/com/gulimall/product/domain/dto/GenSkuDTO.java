package com.gulimall.product.domain.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author gwoksing
 * @date 2022/5/31 11:22
 */
@Data
@ToString
public class GenSkuDTO implements Serializable {
    /**
     * spuId
     */
    private String spuId;

    /**
     * sku名称
     */
    private String skuName;

    /**
     * 描述
     */
    private String skuDescription;

    /**
     * 分类id
     */
    private Long catalogId;

    /**
     * 品牌id
     */
    private Long brandId;

    List<AttrDTO> saleAttrInfoList;
}
