package com.gulimall.common.core.bus.vo.cart;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author admin
 * 购物项VO（购物车内每一项商品内容）
 */
public class CartItemVO {
    /**
     * skuId
     */
    private Long skuId;
    /**
     * 是否选中
     */
    private Boolean check = true;
    /**
     * 标题
     */
    private String title;
    /**
     * 图片
     */
    private String image;
    /**
     * 销售属性
     */
    private List<String> skuAttrValues;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 商品数量
     */
    private Integer count;
    /**
     * 总价
     */
    private BigDecimal totalPrice;

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getSkuAttrValues() {
        return skuAttrValues;
    }

    public void setSkuAttrValues(List<String> skuAttrValues) {
        this.skuAttrValues = skuAttrValues;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 计算当前购物项总价
     */
    public BigDecimal getTotalPrice() {
        return this.price.multiply(new BigDecimal("" + this.count));
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
