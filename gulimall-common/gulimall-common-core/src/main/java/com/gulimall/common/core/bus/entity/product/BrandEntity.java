package com.gulimall.common.core.bus.entity.product;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gulimall.common.core.bus.validator.ListValue;
import com.gulimall.common.core.bus.validator.UpdateStatusGroup;
import com.gulimall.common.core.bus.validator.group.AddGroup;
import com.gulimall.common.core.bus.validator.group.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @author admin
 * 品牌
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 品牌id
     */
    @NotNull(message = "修改必须指定品牌id", groups = {UpdateGroup.class, UpdateStatusGroup.class})
    @Null(message = "新增不能指定id", groups = {AddGroup.class})
    @TableId
    private Long brandId;
    /**
     * 品牌名
     */
    @NotBlank(message = "品牌名必须提交", groups = {AddGroup.class, UpdateGroup.class})
    private String name;
    /**
     * 品牌logo地址
     */
    @NotBlank(groups = {AddGroup.class})
    @URL(message = "logo必须是一个合法的url地址", groups = {AddGroup.class, UpdateGroup.class})
    private String logo;
    /**
     * 介绍
     */
    private String descript;
    /**
     * 显示状态[0-不显示；1-显示]
     */
    @NotNull(groups = {AddGroup.class, UpdateStatusGroup.class})
    @ListValue(vals = {0, 1}, groups = {AddGroup.class, UpdateStatusGroup.class})
    private Integer showStatus;
    /**
     * 检索首字母
     */
    @NotEmpty(groups = {AddGroup.class})
    @Pattern(regexp = "^[a-zA-Z]$", message = "检索首字母必须是一个字母", groups = {AddGroup.class, UpdateGroup.class})
    private String firstLetter;
    /**
     * 排序
     */
    @NotNull(groups = {AddGroup.class})
    @Min(value = 0, message = "排序必须大于等于0", groups = {AddGroup.class, UpdateGroup.class})
    private Integer sort;

}
