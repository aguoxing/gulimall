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
 * 优惠券分类关联对象 sms_coupon_spu_category_relation
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sms_coupon_spu_category_relation")
public class CouponSpuCategoryRelation implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** 优惠券id */
    @Excel(name = "优惠券id")
    private Long couponId;

    /** 产品分类id */
    @Excel(name = "产品分类id")
    private Long categoryId;

    /** 产品分类名称 */
    @Excel(name = "产品分类名称")
    private String categoryName;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
