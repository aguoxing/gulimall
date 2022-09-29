package com.gulimall.common.core.bus.to.mq;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author admin
 * 秒杀订单
 */
@Data
public class SeckillOrderTO {

    /**
     * 订单号
     */
    private String orderSn;

    /**
     * 活动场次id
     */
    private Long promotionSessionId;
    /**
     * 商品id
     */
    private Long skuId;
    /**
     * 秒杀价格
     */
    private BigDecimal seckillPrice;

    /**
     * 购买数量
     */
    private Integer num;

    /**
     * 会员ID
     */
    private Long memberId;


}
