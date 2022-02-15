package com.gulimall.product.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gulimall.common.core.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * sku信息对象 pms_sku_info
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("pms_sku_info")
public class SkuInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * skuId
     */
    @TableId(value = "sku_id")
    private Long skuId;

    /**
     * spuId
     */
    @Excel(name = "spuId")
    private Long spuId;

    /**
     * sku名称
     */
    @Excel(name = "sku名称")
    private String skuName;

    /**
     * sku介绍描述
     */
    @Excel(name = "sku介绍描述")
    private String skuDesc;

    /**
     * 所属分类id
     */
    @Excel(name = "所属分类id")
    private Long catalogId;

    /**
     * 品牌id
     */
    @Excel(name = "品牌id")
    private Long brandId;

    /**
     * 默认图片
     */
    @Excel(name = "默认图片")
    private String skuDefaultImg;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String skuTitle;

    /**
     * 副标题
     */
    @Excel(name = "副标题")
    private String skuSubtitle;

    /**
     * 价格
     */
    @Excel(name = "价格")
    private BigDecimal price;

    /**
     * 销量
     */
    @Excel(name = "销量")
    private Long saleCount;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
