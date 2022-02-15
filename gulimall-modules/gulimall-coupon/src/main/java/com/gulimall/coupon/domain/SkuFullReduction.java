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
 * 商品满减信息对象 sms_sku_full_reduction
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sms_sku_full_reduction")
public class SkuFullReduction implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** spu_id */
    @Excel(name = "spu_id")
    private Long skuId;

    /** 满多少 */
    @Excel(name = "满多少")
    private BigDecimal fullPrice;

    /** 减多少 */
    @Excel(name = "减多少")
    private BigDecimal reducePrice;

    /** 是否参与其他优惠 */
    @Excel(name = "是否参与其他优惠")
    private Integer addOther;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
