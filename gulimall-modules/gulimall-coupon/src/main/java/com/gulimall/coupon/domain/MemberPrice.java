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
 * 商品会员价格对象 sms_member_price
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sms_member_price")
public class MemberPrice implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** sku_id */
    @Excel(name = "sku_id")
    private Long skuId;

    /** 会员等级id */
    @Excel(name = "会员等级id")
    private Long memberLevelId;

    /** 会员等级名 */
    @Excel(name = "会员等级名")
    private String memberLevelName;

    /** 会员对应价格 */
    @Excel(name = "会员对应价格")
    private BigDecimal memberPrice;

    /** 可否叠加其他优惠[0-不可叠加优惠，1-可叠加] */
    @Excel(name = "可否叠加其他优惠[0-不可叠加优惠，1-可叠加]")
    private Integer addOther;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
