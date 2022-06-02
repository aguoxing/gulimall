package com.gulimall.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimall.common.core.utils.DateUtils;
import com.gulimall.order.domain.Order;
import com.gulimall.order.mapper.OrderMapper;
import com.gulimall.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 订单Service业务层处理
 *
 * @author admin
 * @date 2022-02-15
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 查询订单
     *
     * @param id 订单主键
     * @return 订单
     */
    @Override
    public Order selectOrderById(Long id) {
        return orderMapper.selectById(id);
    }

    /**
     * 查询订单列表
     *
     * @param order 订单
     * @return 订单
     */
    @Override
    public List<Order> selectOrderList(Order order) {
        return orderMapper.selectOrderList(order);
    }

    /**
     * 新增订单
     *
     * @param order 订单
     * @return 结果
     */
    @Override
    public int insertOrder(Order order) {
        order.setCreateTime(DateUtils.getNowDate());
        return orderMapper.insert(order);
    }

    /**
     * 修改订单
     *
     * @param order 订单
     * @return 结果
     */
    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateById(order);
    }

    /**
     * 批量删除订单
     *
     * @param ids 需要删除的订单主键
     * @return 结果
     */
    @Override
    public int deleteOrderByIds(Long[] ids) {
        return orderMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
