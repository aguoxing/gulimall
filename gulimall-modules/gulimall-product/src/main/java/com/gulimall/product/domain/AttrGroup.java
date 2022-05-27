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
 * 属性分组对象 pms_attr_group
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("pms_attr_group")
public class AttrGroup implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 分组id
     */
    @TableId(value = "attr_group_id", type = IdType.AUTO)
    private Long attrGroupId;

    /**
     * 组名
     */
    @Excel(name = "组名")
    private String attrGroupName;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;

    /**
     * 描述
     */
    @Excel(name = "描述")
    private String description;

    /**
     * 组图标
     */
    @Excel(name = "组图标")
    private String icon;

    /**
     * 所属分类id
     */
    @Excel(name = "所属分类id")
    private Long catalogId;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
