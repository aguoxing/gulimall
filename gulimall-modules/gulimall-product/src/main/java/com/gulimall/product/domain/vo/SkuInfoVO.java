package com.gulimall.product.domain.vo;

import com.gulimall.product.domain.SkuSaleAttrValue;
import com.gulimall.product.domain.dto.AttrDTO;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * sku信息对象 pms_sku_info
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
public class SkuInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * skuId
     */
    private String skuId;

    /**
     * spuId
     */
    private String spuId;

    /**
     * sku名称
     */
    private String skuName;

    /**
     * sku介绍描述
     */
    private String skuDesc;

    /**
     * 所属分类id
     */
    private Long catalogId;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 默认图片
     */
    private String skuDefaultImg;

    /**
     * 标题
     */
    private String skuTitle;

    /**
     * 副标题
     */
    private String skuSubtitle;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 销量
     */
    private Long saleCount;

    private List<SkuSaleAttrValue> skuSaleAttrValueList;

    private List<AttrDTO> baseAttrInfoList;
}
