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
 * 库存工作单对象 wms_ware_order_task
 *
 * @author admin
 * @date 2022-02-15
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("wms_ware_order_task")
public class WareOrderTask implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** order_id */
    @Excel(name = "order_id")
    private Long orderId;

    /** order_sn */
    @Excel(name = "order_sn")
    private String orderSn;

    /** 收货人 */
    @Excel(name = "收货人")
    private String consignee;

    /** 收货人电话 */
    @Excel(name = "收货人电话")
    private String consigneeTel;

    /** 配送地址 */
    @Excel(name = "配送地址")
    private String deliveryAddress;

    /** 订单备注 */
    @Excel(name = "订单备注")
    private String orderComment;

    /** 付款方式【 1:在线付款 2:货到付款】 */
    @Excel(name = "付款方式【 1:在线付款 2:货到付款】")
    private Integer paymentWay;

    /** 任务状态 */
    @Excel(name = "任务状态")
    private Integer taskStatus;

    /** 订单描述 */
    @Excel(name = "订单描述")
    private String orderBody;

    /** 物流单号 */
    @Excel(name = "物流单号")
    private String trackingNo;

    /** create_time */
    private Date createTime;

    /** 仓库id */
    @Excel(name = "仓库id")
    private Long wareId;

    /** 工作单备注 */
    @Excel(name = "工作单备注")
    private String taskComment;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
