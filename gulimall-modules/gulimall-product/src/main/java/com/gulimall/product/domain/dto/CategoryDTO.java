package com.gulimall.product.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gulimall.product.domain.Category;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 商品三级分类对象 pms_category
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 分类id
     */
    private Long catId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 父分类id
     */
    private Long parentCid;

    /**
     * 层级
     */
    private Long catLevel;

    /**
     * 是否显示[0-不显示，1显示]
     */
    private Integer showStatus;

    /**
     * 排序
     */
    private Long sort;

    /**
     * 图标地址
     */
    private String icon;

    /**
     * 计量单位
     */
    private String productUnit;

    /**
     * 商品数量
     */
    private Long productCount;

    private List<Category> sorted;

    /**
     * 所有子分类
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CategoryDTO> children;
}
