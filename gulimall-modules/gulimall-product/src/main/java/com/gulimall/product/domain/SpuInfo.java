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
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * spu信息对象 pms_spu_info
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("pms_spu_info")
public class SpuInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 商品名称
     */
    @Excel(name = "商品名称")
    private String spuName;

    /**
     * 商品描述
     */
    @Excel(name = "商品描述")
    private String spuDescription;

    /**
     * 所属分类id
     */
    @Excel(name = "所属分类id")
    private Long catalogId;

    /**
     * 品牌id
     */
    @Excel(name = "品牌id")
    private Long brandId;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal weight;

    /**
     * 上架状态[0 - 下架，1 - 上架]
     */
    @Excel(name = "上架状态[0 - 下架，1 - 上架]")
    private Integer publishStatus;

    /**
     * $column.columnComment
     */
    private Date createTime;

    /**
     * $column.columnComment
     */
    private Date updateTime;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
