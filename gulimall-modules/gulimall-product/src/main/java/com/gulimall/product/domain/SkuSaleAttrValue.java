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
 * sku销售属性&值对象 pms_sku_sale_attr_value
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("pms_sku_sale_attr_value")
public class SkuSaleAttrValue implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * sku_id
     */
    @Excel(name = "sku_id")
    private Long skuId;

    /**
     * attr_id
     */
    @Excel(name = "attr_id")
    private Long attrId;

    /**
     * 销售属性名
     */
    @Excel(name = "销售属性名")
    private String attrName;

    /**
     * 销售属性值
     */
    @Excel(name = "销售属性值")
    private String attrValue;

    /**
     * 顺序
     */
    @Excel(name = "顺序")
    private Long attrSort;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
