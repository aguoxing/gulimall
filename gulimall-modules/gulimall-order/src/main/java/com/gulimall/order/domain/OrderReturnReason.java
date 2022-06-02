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
 * 退货原因对象 oms_order_return_reason
 *
 * @author admin
 * @date 2022-02-15
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("oms_order_return_reason")
public class OrderReturnReason implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 退货原因名
     */
    @Excel(name = "退货原因名")
    private String name;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;

    /**
     * 启用状态
     */
    @Excel(name = "启用状态")
    private Integer status;

    /**
     * create_time
     */
    private Date createTime;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
