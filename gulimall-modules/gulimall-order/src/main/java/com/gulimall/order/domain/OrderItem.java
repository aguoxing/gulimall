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
 * 订单项信息对象 oms_order_item
 *
 * @author admin
 * @date 2022-02-15
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("oms_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** order_id */
    @Excel(name = "order_id")
    private Long orderId;

    /** order_sn */
    @Excel(name = "order_sn")
    private String orderSn;

    /** spu_id */
    @Excel(name = "spu_id")
    private Long spuId;

    /** spu_name */
    @Excel(name = "spu_name")
    private String spuName;

    /** spu_pic */
    @Excel(name = "spu_pic")
    private String spuPic;

    /** 品牌 */
    @Excel(name = "品牌")
    private String spuBrand;

    /** 商品分类id */
    @Excel(name = "商品分类id")
    private Long categoryId;

    /** 商品sku编号 */
    @Excel(name = "商品sku编号")
    private Long skuId;

    /** 商品sku名字 */
    @Excel(name = "商品sku名字")
    private String skuName;

    /** 商品sku图片 */
    @Excel(name = "商品sku图片")
    private String skuPic;

    /** 商品sku价格 */
    @Excel(name = "商品sku价格")
    private BigDecimal skuPrice;

    /** 商品购买的数量 */
    @Excel(name = "商品购买的数量")
    private Long skuQuantity;

    /** 商品销售属性组合（JSON） */
    @Excel(name = "商品销售属性组合" , readConverterExp = "J=SON")
    private String skuAttrsVals;

    /** 商品促销分解金额 */
    @Excel(name = "商品促销分解金额")
    private BigDecimal promotionAmount;

    /** 优惠券优惠分解金额 */
    @Excel(name = "优惠券优惠分解金额")
    private BigDecimal couponAmount;

    /** 积分优惠分解金额 */
    @Excel(name = "积分优惠分解金额")
    private BigDecimal integrationAmount;

    /** 该商品经过优惠后的分解金额 */
    @Excel(name = "该商品经过优惠后的分解金额")
    private BigDecimal realAmount;

    /** 赠送积分 */
    @Excel(name = "赠送积分")
    private Long giftIntegration;

    /** 赠送成长值 */
    @Excel(name = "赠送成长值")
    private Long giftGrowth;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
