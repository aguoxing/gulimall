package com.gulimall.order.domain.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author gwoksing
 * @date 2022/6/2 13:58
 */
@Data
@ToString
public class PayDTO implements Serializable {
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
     * 产品编号，支付方式不同 参数不同
     * pc网页支付：FAST_INSTANT_TRADE_PAY
     * 扫码支付：FACE_TO_FACE_PAYMENT
     */
    private String product_code = "FAST_INSTANT_TRADE_PAY";

    /**
     * 订单号 前端
     */
    private String orderSn;
}
