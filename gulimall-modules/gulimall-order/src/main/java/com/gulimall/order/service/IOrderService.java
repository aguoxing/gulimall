package com.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimall.order.domain.Order;

import java.util.List;

/**
 * 订单Service接口
 *
 * @author admin
 * @date 2022-02-15
 */
public interface IOrderService extends IService<Order> {
    /**
     * 查询订单
     *
     * @param id 订单主键
     * @return 订单
     */
    Order selectOrderById(Long id);

    /**
     * 查询订单列表
     *
     * @param order 订单
     * @return 订单集合
     */
    List<Order> selectOrderList(Order order);

    /**
     * 新增订单
     *
     * @param order 订单
     * @return 结果
     */
    int insertOrder(Order order);

    /**
     * 修改订单
     *
     * @param order 订单
     * @return 结果
     */
    int updateOrder(Order order);

    /**
     * 批量删除订单
     *
     * @param ids 需要删除的订单主键集合
     * @return 结果
     */
    int deleteOrderByIds(Long[] ids);

}
