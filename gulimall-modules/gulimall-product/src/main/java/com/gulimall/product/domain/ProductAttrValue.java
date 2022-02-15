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
import java.util.HashMap;
import java.util.Map;

/**
 * spu属性值对象 pms_product_attr_value
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("pms_product_attr_value")
public class ProductAttrValue implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 商品id
     */
    @Excel(name = "商品id")
    private Long spuId;

    /**
     * 属性id
     */
    @Excel(name = "属性id")
    private Long attrId;

    /**
     * 属性名
     */
    @Excel(name = "属性名")
    private String attrName;

    /**
     * 属性值
     */
    @Excel(name = "属性值")
    private String attrValue;

    /**
     * 顺序
     */
    @Excel(name = "顺序")
    private Long attrSort;

    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】
     */
    @Excel(name = "快速展示【是否展示在介绍上；0-否 1-是】")
    private Integer quickShow;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
