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
 * 采购信息详情对象 wms_purchase_detail
 *
 * @author admin
 * @date 2022-02-15
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("wms_purchase_detail")
public class PurchaseDetail implements Serializable {
    private static final long serialVersionUID=1L;

    /** $column.columnComment */
    @TableId(value = "id")
    private Long id;

    /** 采购单id */
    @Excel(name = "采购单id")
    private Long purchaseId;

    /** 采购商品id */
    @Excel(name = "采购商品id")
    private Long skuId;

    /** 采购数量 */
    @Excel(name = "采购数量")
    private Long skuNum;

    /** 采购金额 */
    @Excel(name = "采购金额")
    private BigDecimal skuPrice;

    /** 仓库id */
    @Excel(name = "仓库id")
    private Long wareId;

    /** 状态[0新建，1已分配，2正在采购，3已完成，4采购失败] */
    @Excel(name = "状态[0新建，1已分配，2正在采购，3已完成，4采购失败]")
    private Long status;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
