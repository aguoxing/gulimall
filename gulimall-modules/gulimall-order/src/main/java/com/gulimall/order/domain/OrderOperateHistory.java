package com.gulimall.order.domain;

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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 订单操作历史记录对象 oms_order_operate_history
 *
 * @author admin
 * @date 2022-02-15
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("oms_order_operate_history")
public class OrderOperateHistory implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 订单id
     */
    @Excel(name = "订单id")
    private Long orderId;

    /**
     * 操作人[用户；系统；后台管理员]
     */
    @Excel(name = "操作人[用户；系统；后台管理员]")
    private String operateMan;

    /**
     * 操作时间
     */
    private Date createTime;

    /**
     * 订单状态【0-&gt;待付款；1-&gt;待发货；2-&gt;已发货；3-&gt;已完成；4-&gt;已关闭；5-&gt;无效订单】
     */
    @Excel(name = "订单状态【0-&gt;待付款；1-&gt;待发货；2-&gt;已发货；3-&gt;已完成；4-&gt;已关闭；5-&gt;无效订单】")
    private Integer orderStatus;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String note;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
