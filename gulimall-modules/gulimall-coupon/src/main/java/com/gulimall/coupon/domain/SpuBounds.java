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
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 商品spu积分设置对象 sms_spu_bounds
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sms_spu_bounds")
public class SpuBounds implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}" , readConverterExp = "$column.readConverterExp()")
    private String spuId;

    /** 成长积分 */
    @Excel(name = "成长积分")
    private BigDecimal growBounds;

    /** 购物积分 */
    @Excel(name = "购物积分")
    private BigDecimal buyBounds;

    /** 优惠生效情况[1111（四个状态位，从右到左）;0 - 无优惠，成长积分是否赠送;1 - 无优惠，购物积分是否赠送;2 - 有优惠，成长积分是否赠送;3 - 有优惠，购物积分是否赠送【状态位0：不赠送，1：赠送】] */
    @Excel(name = "优惠生效情况[1111" , readConverterExp = "四=个状态位，从右到左")
    private Integer work;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
