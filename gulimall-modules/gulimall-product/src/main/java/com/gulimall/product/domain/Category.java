package com.gulimall.product.domain;

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
 * 商品三级分类对象 pms_category
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("pms_category")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 分类id
     */
    @TableId(value = "cat_id")
    private Long catId;

    /**
     * 分类名称
     */
    @Excel(name = "分类名称")
    private String name;

    /**
     * 父分类id
     */
    @Excel(name = "父分类id")
    private Long parentCid;

    /**
     * 层级
     */
    @Excel(name = "层级")
    private Long catLevel;

    /**
     * 是否显示[0-不显示，1显示]
     */
    @Excel(name = "是否显示[0-不显示，1显示]")
    private Integer showStatus;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;

    /**
     * 图标地址
     */
    @Excel(name = "图标地址")
    private String icon;

    /**
     * 计量单位
     */
    @Excel(name = "计量单位")
    private String productUnit;

    /**
     * 商品数量
     */
    @Excel(name = "商品数量")
    private Long productCount;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
