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
 * spu图片对象 pms_spu_images
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("pms_spu_images")
public class SpuImages implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * spu_id
     */
    @Excel(name = "spu_id")
    private Long spuId;

    /**
     * 图片名
     */
    @Excel(name = "图片名")
    private String imgName;

    /**
     * 图片地址
     */
    @Excel(name = "图片地址")
    private String imgUrl;

    /**
     * 顺序
     */
    @Excel(name = "顺序")
    private Long imgSort;

    /**
     * 是否默认图
     */
    @Excel(name = "是否默认图")
    private Integer defaultImg;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
