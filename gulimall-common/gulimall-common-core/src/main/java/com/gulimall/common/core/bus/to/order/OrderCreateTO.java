package com.gulimall.common.core.bus.to.order;

import com.gulimall.common.core.bus.entity.order.OrderEntity;
import com.gulimall.common.core.bus.entity.order.OrderItemEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author admin
 * 创建的订单TO对象
 * 1、订单
 * 2、订单项
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: wan
 */
@Data
public class OrderCreateTO {
    /**
     * 订单
     */
    private OrderEntity order;
    /**
     * 订单项
     */
    private List<OrderItemEntity> orderItems;
    /**
     * 订单计算的应付价格 TODO 是否可删？
     **/
    private BigDecimal payPrice;
    /**
     * 运费 TODO 是否可删？
     **/
    private BigDecimal fare;
}
