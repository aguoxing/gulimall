package com.gulimall.order.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.order.domain.Order;

/**
 * 订单Mapper接口
 * 
 * @author admin
 * @date 2022-02-15
 */
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 查询订单列表
     * 
     * @param order 订单
     * @return 订单集合
     */
    List<Order> selectOrderList(Order order);

}
