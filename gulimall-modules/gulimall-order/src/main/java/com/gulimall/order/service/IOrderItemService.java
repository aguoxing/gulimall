package com.gulimall.order.service;

import java.util.List;
import com.gulimall.order.domain.OrderItem;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 订单项信息Service接口
 * 
 * @author admin
 * @date 2022-02-15
 */
public interface IOrderItemService extends IService<OrderItem> {
    /**
     * 查询订单项信息
     *
     * @param id 订单项信息主键
     * @return 订单项信息
     */
    OrderItem selectOrderItemById(Long id);

    /**
     * 查询订单项信息列表
     * 
     * @param orderItem 订单项信息
     * @return 订单项信息集合
     */
    List<OrderItem> selectOrderItemList(OrderItem orderItem);

    /**
     * 新增订单项信息
     * 
     * @param orderItem 订单项信息
     * @return 结果
     */
    int insertOrderItem(OrderItem orderItem);

    /**
     * 修改订单项信息
     * 
     * @param orderItem 订单项信息
     * @return 结果
     */
    int updateOrderItem(OrderItem orderItem);

    /**
     * 批量删除订单项信息
     * 
     * @param ids 需要删除的订单项信息主键集合
     * @return 结果
     */
    int deleteOrderItemByIds(Long[] ids);

}
