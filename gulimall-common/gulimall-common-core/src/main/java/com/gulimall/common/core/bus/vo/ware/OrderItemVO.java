package com.gulimall.common.core.bus.vo.ware;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: admin
 **/

@Data
public class OrderItemVO {

    private Long skuId;

    private Boolean check;

    private String title;

    private String image;

    /**
     * 商品套餐属性
     */
    private List<String> skuAttrValues;

    private BigDecimal price;

    private Integer count;

    private BigDecimal totalPrice;

    /**
     * 商品重量
     **/
    private BigDecimal weight = new BigDecimal("0.085");
}
