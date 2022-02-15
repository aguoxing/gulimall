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
 * 秒杀活动商品关联对象 sms_seckill_sku_relation
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sms_seckill_sku_relation")
public class SeckillSkuRelation implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** 活动id */
    @Excel(name = "活动id")
    private Long promotionId;

    /** 活动场次id */
    @Excel(name = "活动场次id")
    private Long promotionSessionId;

    /** 商品id */
    @Excel(name = "商品id")
    private Long skuId;

    /** 秒杀价格 */
    @Excel(name = "秒杀价格")
    private Long seckillPrice;

    /** 秒杀总量 */
    @Excel(name = "秒杀总量")
    private Long seckillCount;

    /** 每人限购数量 */
    @Excel(name = "每人限购数量")
    private Long seckillLimit;

    /** 排序 */
    @Excel(name = "排序")
    private Long seckillSort;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
