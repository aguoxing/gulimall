package com.gulimall.coupon.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gulimall.common.core.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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
    private String skuId;

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
