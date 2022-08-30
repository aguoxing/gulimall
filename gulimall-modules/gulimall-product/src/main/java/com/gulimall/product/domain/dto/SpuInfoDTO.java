package com.gulimall.product.domain.dto;

import com.gulimall.product.domain.vo.Bounds;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * spu信息对象 pms_spu_info
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
public class SpuInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    private String id;

    /**
     * 商品名称
     */
    private String spuName;

    /**
     * 商品描述
     */
    private String spuDescription;

    /**
     * 所属分类id
     */
    private Long catalogId;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * $column.columnComment
     */
    private BigDecimal weight;

    /**
     * 上架状态[0 - 下架，1 - 上架]
     */
    private Integer publishStatus;

    /**
     * $column.columnComment
     */
    private Date createTime;

    /**
     * $column.columnComment
     */
    private Date updateTime;

    private List<String> description;

    private List<String> images;

    private Bounds bounds;

}
