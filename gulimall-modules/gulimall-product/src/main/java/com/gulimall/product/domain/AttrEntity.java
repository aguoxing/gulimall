package com.gulimall.product.domain;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 商品属性对象 pms_attr
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("pms_attr")
public class AttrEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 属性id
     */
    @TableId(value = "attr_id", type = IdType.AUTO)
    private Long attrId;

    /**
     * 属性名
     */
    @Excel(name = "属性名")
    private String attrName;

    /**
     * 是否需要检索[0-不需要，1-需要]
     */
    @Excel(name = "是否需要检索[0-不需要，1-需要]")
    private Integer searchType;

    /**
     * 属性图标
     */
    @Excel(name = "属性图标")
    private String icon;

    /**
     * 可选值列表[用逗号分隔]
     */
    @Excel(name = "可选值列表[用逗号分隔]")
    private String valueSelect;

    /**
     * 属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]
     */
    @Excel(name = "属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]")
    private Integer attrType;

    /**
     * 启用状态[0 - 禁用，1 - 启用]
     */
    @Excel(name = "启用状态[0 - 禁用，1 - 启用]")
    private Long enable;

    /**
     * 所属分类
     */
    @Excel(name = "所属分类")
    private Long catalogId;

    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
     */
    @Excel(name = "快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整")
    private Integer showDesc;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
