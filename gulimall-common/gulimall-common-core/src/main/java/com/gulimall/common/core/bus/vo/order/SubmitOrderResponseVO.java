package com.gulimall.common.core.bus.vo.order;

import com.gulimall.common.core.bus.entity.order.OrderEntity;
import lombok.Data;

/**
 * @author: admin
 * 提交订单返回结果
 */
@Data
public class SubmitOrderResponseVO {
    private OrderEntity order;
}
