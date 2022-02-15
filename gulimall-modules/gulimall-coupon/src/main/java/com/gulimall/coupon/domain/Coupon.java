package com.gulimall.coupon.domain;

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
 * 优惠券信息对象 sms_coupon
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sms_coupon")
public class Coupon implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** 优惠卷类型[0-&gt;全场赠券；1-&gt;会员赠券；2-&gt;购物赠券；3-&gt;注册赠券] */
    @Excel(name = "优惠卷类型[0-&gt;全场赠券；1-&gt;会员赠券；2-&gt;购物赠券；3-&gt;注册赠券]")
    private Integer couponType;

    /** 优惠券图片 */
    @Excel(name = "优惠券图片")
    private String couponImg;

    /** 优惠卷名字 */
    @Excel(name = "优惠卷名字")
    private String couponName;

    /** 数量 */
    @Excel(name = "数量")
    private Long num;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal amount;

    /** 每人限领张数 */
    @Excel(name = "每人限领张数")
    private Long perLimit;

    /** 使用门槛 */
    @Excel(name = "使用门槛")
    private BigDecimal minPoint;

    /** 开始时间 */
    @Excel(name = "开始时间" , width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /** 结束时间 */
    @Excel(name = "结束时间" , width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /** 使用类型[0-&gt;全场通用；1-&gt;指定分类；2-&gt;指定商品] */
    @Excel(name = "使用类型[0-&gt;全场通用；1-&gt;指定分类；2-&gt;指定商品]")
    private Integer useType;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 发行数量 */
    @Excel(name = "发行数量")
    private Long publishCount;

    /** 已使用数量 */
    @Excel(name = "已使用数量")
    private Long useCount;

    /** 领取数量 */
    @Excel(name = "领取数量")
    private Long receiveCount;

    /** 可以领取的开始日期 */
    @Excel(name = "可以领取的开始日期" , width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date enableStartTime;

    /** 可以领取的结束日期 */
    @Excel(name = "可以领取的结束日期" , width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date enableEndTime;

    /** 优惠码 */
    @Excel(name = "优惠码")
    private String code;

    /** 可以领取的会员等级[0-&gt;不限等级，其他-对应等级] */
    @Excel(name = "可以领取的会员等级[0-&gt;不限等级，其他-对应等级]")
    private Integer memberLevel;

    /** 发布状态[0-未发布，1-已发布] */
    @Excel(name = "发布状态[0-未发布，1-已发布]")
    private Integer publish;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
