package com.gulimall.common.core.bus.vo.product;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author: admin
 */
@Data
@ToString
public class SkuItemSaleAttrVO {
    /**
     * 1.销售属性对应1个attrName
     * 2.销售属性对应n个attrValue
     * 3.n个sku包含当前销售属性（所以前端根据skuId交集区分销售属性的组合【笛卡尔积】）
     */
    private Long attrId;
    private String attrName;
    private List<AttrValueWithSkuIdVO> attrValues;
}
