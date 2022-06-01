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
 * sku图片对象 pms_sku_images
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("pms_sku_images")
public class SkuImages implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * sku_id
     */
    @Excel(name = "sku_id")
    private String skuId;

    /**
     * 图片地址
     */
    @Excel(name = "图片地址")
    private String imgUrl;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long imgSort;

    /**
     * 默认图[0 - 不是默认图，1 - 是默认图]
     */
    @Excel(name = "默认图[0 - 不是默认图，1 - 是默认图]")
    private Long defaultImg;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
