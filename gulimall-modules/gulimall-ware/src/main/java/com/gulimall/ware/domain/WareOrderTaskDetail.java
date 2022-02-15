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
 * 库存工作单详情对象 wms_ware_order_task_detail
 *
 * @author admin
 * @date 2022-02-15
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("wms_ware_order_task_detail")
public class WareOrderTaskDetail implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** sku_id */
    @Excel(name = "sku_id")
    private Long skuId;

    /** sku_name */
    @Excel(name = "sku_name")
    private String skuName;

    /** 购买个数 */
    @Excel(name = "购买个数")
    private Long skuNum;

    /** 工作单id */
    @Excel(name = "工作单id")
    private Long taskId;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
