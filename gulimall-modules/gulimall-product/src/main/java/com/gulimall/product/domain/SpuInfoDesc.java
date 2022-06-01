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
 * spu信息介绍对象 pms_spu_info_desc
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("pms_spu_info_desc")
public class SpuInfoDesc implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(value = "spu_id")
    private String spuId;

    /**
     * 商品介绍
     */
    @Excel(name = "商品介绍")
    private String description;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
