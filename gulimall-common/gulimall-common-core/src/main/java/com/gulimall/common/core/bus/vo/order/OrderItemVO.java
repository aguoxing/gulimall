package com.gulimall.common.core.bus.vo.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author admin
 * 购物车所有购物项
 */
@Data
public class OrderItemVO {
    /**
     * skuId
     */
    private Long skuId;
    /**
     * 是否选中
     */
    private Boolean check;
    /**
     * 标题
     */
    private String title;
    /**
     * 图片
     */
    private String image;
    /**
     * 商品销售属性  ["颜色:星河银","版本:8GB+256GB"]
     */
    private List<String> skuAttrValues;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 当前商品数量
     */
    private Integer count;
    /**
     * 总价
     */
    private BigDecimal totalPrice;
    /**
     * 商品重量
     */
    private BigDecimal weight = new BigDecimal("0.085");
}
