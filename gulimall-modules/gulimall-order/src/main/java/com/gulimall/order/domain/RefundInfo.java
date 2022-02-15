package com.gulimall.order.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import com.gulimall.common.core.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

/**
 * 退款信息对象 oms_refund_info
 *
 * @author admin
 * @date 2022-02-15
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("oms_refund_info")
public class RefundInfo implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** 退款的订单 */
    @Excel(name = "退款的订单")
    private Long orderReturnId;

    /** 退款金额 */
    @Excel(name = "退款金额")
    private BigDecimal refund;

    /** 退款交易流水号 */
    @Excel(name = "退款交易流水号")
    private String refundSn;

    /** 退款状态 */
    @Excel(name = "退款状态")
    private Integer refundStatus;

    /** 退款渠道[1-支付宝，2-微信，3-银联，4-汇款] */
    @Excel(name = "退款渠道[1-支付宝，2-微信，3-银联，4-汇款]")
    private Integer refundChannel;

    /** $column.columnComment */
    @Excel(name = "${comment}" , readConverterExp = "$column.readConverterExp()")
    private String refundContent;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
