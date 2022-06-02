package com.gulimall.order.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gulimall.common.core.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 支付信息对象 oms_payment_info
 *
 * @author admin
 * @date 2022-02-15
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("oms_payment_info")
public class PaymentInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 订单号（对外业务号）
     */
    @Excel(name = "订单号", readConverterExp = "对=外业务号")
    private String orderSn;

    /**
     * 订单id
     */
    @Excel(name = "订单id")
    private Long orderId;

    /**
     * 支付宝交易流水号
     */
    @Excel(name = "支付宝交易流水号")
    private String alipayTradeNo;

    /**
     * 支付总金额
     */
    @Excel(name = "支付总金额")
    private BigDecimal totalAmount;

    /**
     * 交易内容
     */
    @Excel(name = "交易内容")
    private String subject;

    /**
     * 支付状态
     */
    @Excel(name = "支付状态")
    private String paymentStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 确认时间
     */
    @Excel(name = "确认时间", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date confirmTime;

    /**
     * 回调内容
     */
    @Excel(name = "回调内容")
    private String callbackContent;

    /**
     * 回调时间
     */
    @Excel(name = "回调时间", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date callbackTime;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
