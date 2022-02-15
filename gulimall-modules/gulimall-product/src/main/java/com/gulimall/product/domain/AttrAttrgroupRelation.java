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
 * 属性&属性分组关联对象 pms_attr_attrgroup_relation
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("pms_attr_attrgroup_relation")
public class AttrAttrgroupRelation implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 属性id
     */
    @Excel(name = "属性id")
    private Long attrId;

    /**
     * 属性分组id
     */
    @Excel(name = "属性分组id")
    private Long attrGroupId;

    /**
     * 属性组内排序
     */
    @Excel(name = "属性组内排序")
    private Long attrSort;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
