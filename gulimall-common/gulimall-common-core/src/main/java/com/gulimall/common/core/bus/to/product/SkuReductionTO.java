package com.gulimall.common.core.bus.to.product;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author admin
 * 满件数打折、满金额优惠、会员价格
 */
@Data
public class SkuReductionTO {
    private Long skuId;
    /**
     * 满件数
     */
    private int fullCount;
    /**
     * 折扣
     */
    private BigDecimal discount;
    private int countStatus;
    /**
     * 满金额
     */
    private BigDecimal fullPrice;
    /**
     * 优惠金额
     */
    private BigDecimal reducePrice;
    private int priceStatus;
    /**
     * 会员价格
     */
    private List<MemberPrice> memberPrice;
}
