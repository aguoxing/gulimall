package com.gulimall.order.service.impl;

import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.order.mapper.OrderItemMapper;
import com.gulimall.order.domain.OrderItem;
import com.gulimall.order.service.IOrderItemService;

/**
 * 订单项信息Service业务层处理
 * 
 * @author admin
 * @date 2022-02-15
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements IOrderItemService {
    @Autowired
    private OrderItemMapper orderItemMapper;

    /**
     * 查询订单项信息
     * 
     * @param id 订单项信息主键
     * @return 订单项信息
     */
    @Override
    public OrderItem selectOrderItemById(Long id) {
        return orderItemMapper.selectById(id);
    }

    /**
     * 查询订单项信息列表
     * 
     * @param orderItem 订单项信息
     * @return 订单项信息
     */
    @Override
    public List<OrderItem> selectOrderItemList(OrderItem orderItem) {
        return orderItemMapper.selectOrderItemList(orderItem);
    }

    /**
     * 新增订单项信息
     * 
     * @param orderItem 订单项信息
     * @return 结果
     */
    @Override
    public int insertOrderItem(OrderItem orderItem) {
        return orderItemMapper.insert(orderItem);
    }

    /**
     * 修改订单项信息
     * 
     * @param orderItem 订单项信息
     * @return 结果
     */
    @Override
    public int updateOrderItem(OrderItem orderItem) {
        return orderItemMapper.updateById(orderItem);
    }

    /**
     * 批量删除订单项信息
     * 
     * @param ids 需要删除的订单项信息主键
     * @return 结果
     */
    @Override
    public int deleteOrderItemByIds(Long[] ids) {
        return orderItemMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
