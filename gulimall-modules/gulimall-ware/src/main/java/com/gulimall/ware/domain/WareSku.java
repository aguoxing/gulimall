package com.gulimall.ware.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import com.gulimall.common.core.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

/**
 * 商品库存对象 wms_ware_sku
 *
 * @author admin
 * @date 2022-02-15
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("wms_ware_sku")
public class WareSku implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** sku_id */
    @Excel(name = "sku_id")
    private Long skuId;

    /** 仓库id */
    @Excel(name = "仓库id")
    private Long wareId;

    /** 库存数 */
    @Excel(name = "库存数")
    private Long stock;

    /** sku_name */
    @Excel(name = "sku_name")
    private String skuName;

    /** 锁定库存 */
    @Excel(name = "锁定库存")
    private Long stockLocked;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
