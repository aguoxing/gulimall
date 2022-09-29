package com.gulimall.common.core.bus.vo.order;

import lombok.Data;

/**
 * @author: admin
 */
@Data
public class PayVO {

    /**
     * 商户订单号 必填
     */
    private String out_trade_no;
    /**
     * 订单名称 必填
     */
    private String subject;
    /**
     * 付款金额 必填
     */
    private String total_amount;
    /**
     * 商品描述 可空
     */
    private String body;
    /**
     * 同步回调地址
     */
    private String return_url;
    /**
     * 异步回调地址
     */
    private String notify_url;

    /**
     * 前端传参 订单号
     */
    private String orderSn;
}
