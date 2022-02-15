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
 * 商品阶梯价格对象 sms_sku_ladder
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sms_sku_ladder")
public class SkuLadder implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** spu_id */
    @Excel(name = "spu_id")
    private Long skuId;

    /** 满几件 */
    @Excel(name = "满几件")
    private Long fullCount;

    /** 打几折 */
    @Excel(name = "打几折")
    private BigDecimal discount;

    /** 折后价 */
    @Excel(name = "折后价")
    private BigDecimal price;

    /** 是否叠加其他优惠[0-不可叠加，1-可叠加] */
    @Excel(name = "是否叠加其他优惠[0-不可叠加，1-可叠加]")
    private Integer addOther;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
