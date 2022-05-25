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
 * 品牌对象 pms_brand
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("pms_brand")
public class Brand implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 品牌id
     */
    @TableId(value = "brand_id")
    private Long brandId;

    /**
     * 品牌名
     */
    @Excel(name = "品牌名")
    private String name;

    /**
     * 品牌logo地址
     */
    @Excel(name = "品牌logo地址")
    private String logo;

    /**
     * 介绍
     */
    @Excel(name = "介绍")
    private String description;

    /**
     * 显示状态[0-不显示；1-显示]
     */
    @Excel(name = "显示状态[0-不显示；1-显示]")
    private Integer showStatus;

    /**
     * 检索首字母
     */
    @Excel(name = "检索首字母")
    private String firstLetter;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
