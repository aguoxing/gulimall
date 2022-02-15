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
 * 订单对象 oms_order
 *
 * @author admin
 * @date 2022-02-15
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("oms_order")
public class Order implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** member_id */
    @Excel(name = "member_id")
    private Long memberId;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderSn;

    /** 使用的优惠券 */
    @Excel(name = "使用的优惠券")
    private Long couponId;

    /** create_time */
    private Date createTime;

    /** 用户名 */
    @Excel(name = "用户名")
    private String memberUsername;

    /** 订单总额 */
    @Excel(name = "订单总额")
    private BigDecimal totalAmount;

    /** 应付总额 */
    @Excel(name = "应付总额")
    private BigDecimal payAmount;

    /** 运费金额 */
    @Excel(name = "运费金额")
    private BigDecimal freightAmount;

    /** 促销优化金额（促销价、满减、阶梯价） */
    @Excel(name = "促销优化金额" , readConverterExp = "促=销价、满减、阶梯价")
    private BigDecimal promotionAmount;

    /** 积分抵扣金额 */
    @Excel(name = "积分抵扣金额")
    private BigDecimal integrationAmount;

    /** 优惠券抵扣金额 */
    @Excel(name = "优惠券抵扣金额")
    private BigDecimal couponAmount;

    /** 后台调整订单使用的折扣金额 */
    @Excel(name = "后台调整订单使用的折扣金额")
    private BigDecimal discountAmount;

    /** 支付方式【1-&gt;支付宝；2-&gt;微信；3-&gt;银联； 4-&gt;货到付款；】 */
    @Excel(name = "支付方式【1-&gt;支付宝；2-&gt;微信；3-&gt;银联； 4-&gt;货到付款；】")
    private Integer payType;

    /** 订单来源[0-&gt;PC订单；1-&gt;app订单] */
    @Excel(name = "订单来源[0-&gt;PC订单；1-&gt;app订单]")
    private Integer sourceType;

    /** 订单状态【0-&gt;待付款；1-&gt;待发货；2-&gt;已发货；3-&gt;已完成；4-&gt;已关闭；5-&gt;无效订单】 */
    @Excel(name = "订单状态【0-&gt;待付款；1-&gt;待发货；2-&gt;已发货；3-&gt;已完成；4-&gt;已关闭；5-&gt;无效订单】")
    private Integer status;

    /** 物流公司(配送方式) */
    @Excel(name = "物流公司(配送方式)")
    private String deliveryCompany;

    /** 物流单号 */
    @Excel(name = "物流单号")
    private String deliverySn;

    /** 自动确认时间（天） */
    @Excel(name = "自动确认时间" , readConverterExp = "天=")
    private Long autoConfirmDay;

    /** 可以获得的积分 */
    @Excel(name = "可以获得的积分")
    private Long integration;

    /** 可以获得的成长值 */
    @Excel(name = "可以获得的成长值")
    private Long growth;

    /** 发票类型[0-&gt;不开发票；1-&gt;电子发票；2-&gt;纸质发票] */
    @Excel(name = "发票类型[0-&gt;不开发票；1-&gt;电子发票；2-&gt;纸质发票]")
    private Integer billType;

    /** 发票抬头 */
    @Excel(name = "发票抬头")
    private String billHeader;

    /** 发票内容 */
    @Excel(name = "发票内容")
    private String billContent;

    /** 收票人电话 */
    @Excel(name = "收票人电话")
    private String billReceiverPhone;

    /** 收票人邮箱 */
    @Excel(name = "收票人邮箱")
    private String billReceiverEmail;

    /** 收货人姓名 */
    @Excel(name = "收货人姓名")
    private String receiverName;

    /** 收货人电话 */
    @Excel(name = "收货人电话")
    private String receiverPhone;

    /** 收货人邮编 */
    @Excel(name = "收货人邮编")
    private String receiverPostCode;

    /** 省份/直辖市 */
    @Excel(name = "省份/直辖市")
    private String receiverProvince;

    /** 城市 */
    @Excel(name = "城市")
    private String receiverCity;

    /** 区 */
    @Excel(name = "区")
    private String receiverRegion;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String receiverDetailAddress;

    /** 订单备注 */
    @Excel(name = "订单备注")
    private String note;

    /** 确认收货状态[0-&gt;未确认；1-&gt;已确认] */
    @Excel(name = "确认收货状态[0-&gt;未确认；1-&gt;已确认]")
    private Integer confirmStatus;

    /** 删除状态【0-&gt;未删除；1-&gt;已删除】 */
    @Excel(name = "删除状态【0-&gt;未删除；1-&gt;已删除】")
    private Integer deleteStatus;

    /** 下单时使用的积分 */
    @Excel(name = "下单时使用的积分")
    private Long useIntegration;

    /** 支付时间 */
    @Excel(name = "支付时间" , width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date paymentTime;

    /** 发货时间 */
    @Excel(name = "发货时间" , width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deliveryTime;

    /** 确认收货时间 */
    @Excel(name = "确认收货时间" , width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date receiveTime;

    /** 评价时间 */
    @Excel(name = "评价时间" , width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date commentTime;

    /** 修改时间 */
    @Excel(name = "修改时间" , width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
