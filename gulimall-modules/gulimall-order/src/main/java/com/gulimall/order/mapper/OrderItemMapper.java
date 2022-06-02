package com.gulimall.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.order.domain.OrderItem;

import java.util.List;

/**
 * 订单项信息Mapper接口
 *
 * @author admin
 * @date 2022-02-15
 */
public interface OrderItemMapper extends BaseMapper<OrderItem> {

    /**
     * 查询订单项信息列表
     *
     * @param orderItem 订单项信息
     * @return 订单项信息集合
     */
    List<OrderItem> selectOrderItemList(OrderItem orderItem);

}
