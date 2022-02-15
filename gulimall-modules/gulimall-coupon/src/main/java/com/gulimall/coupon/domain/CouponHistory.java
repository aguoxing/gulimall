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
 * 优惠券领取历史记录对象 sms_coupon_history
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sms_coupon_history")
public class CouponHistory implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** 优惠券id */
    @Excel(name = "优惠券id")
    private Long couponId;

    /** 会员id */
    @Excel(name = "会员id")
    private Long memberId;

    /** 会员名字 */
    @Excel(name = "会员名字")
    private String memberNickName;

    /** 获取方式[0-&gt;后台赠送；1-&gt;主动领取] */
    @Excel(name = "获取方式[0-&gt;后台赠送；1-&gt;主动领取]")
    private Integer getType;

    /** 创建时间 */
    private Date createTime;

    /** 使用状态[0-&gt;未使用；1-&gt;已使用；2-&gt;已过期] */
    @Excel(name = "使用状态[0-&gt;未使用；1-&gt;已使用；2-&gt;已过期]")
    private Integer useType;

    /** 使用时间 */
    @Excel(name = "使用时间" , width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date useTime;

    /** 订单id */
    @Excel(name = "订单id")
    private Long orderId;

    /** 订单号 */
    @Excel(name = "订单号")
    private Long orderSn;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
