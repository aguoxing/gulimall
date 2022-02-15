package com.gulimall.order.service.impl;

import java.util.Arrays;
import java.util.List;
import com.gulimall.common.core.utils.DateUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.order.mapper.OrderOperateHistoryMapper;
import com.gulimall.order.domain.OrderOperateHistory;
import com.gulimall.order.service.IOrderOperateHistoryService;

/**
 * 订单操作历史记录Service业务层处理
 * 
 * @author admin
 * @date 2022-02-15
 */
@Service
public class OrderOperateHistoryServiceImpl extends ServiceImpl<OrderOperateHistoryMapper, OrderOperateHistory> implements IOrderOperateHistoryService {
    @Autowired
    private OrderOperateHistoryMapper orderOperateHistoryMapper;

    /**
     * 查询订单操作历史记录
     * 
     * @param id 订单操作历史记录主键
     * @return 订单操作历史记录
     */
    @Override
    public OrderOperateHistory selectOrderOperateHistoryById(Long id) {
        return orderOperateHistoryMapper.selectById(id);
    }

    /**
     * 查询订单操作历史记录列表
     * 
     * @param orderOperateHistory 订单操作历史记录
     * @return 订单操作历史记录
     */
    @Override
    public List<OrderOperateHistory> selectOrderOperateHistoryList(OrderOperateHistory orderOperateHistory) {
        return orderOperateHistoryMapper.selectOrderOperateHistoryList(orderOperateHistory);
    }

    /**
     * 新增订单操作历史记录
     * 
     * @param orderOperateHistory 订单操作历史记录
     * @return 结果
     */
    @Override
    public int insertOrderOperateHistory(OrderOperateHistory orderOperateHistory) {
        orderOperateHistory.setCreateTime(DateUtils.getNowDate());
        return orderOperateHistoryMapper.insert(orderOperateHistory);
    }

    /**
     * 修改订单操作历史记录
     * 
     * @param orderOperateHistory 订单操作历史记录
     * @return 结果
     */
    @Override
    public int updateOrderOperateHistory(OrderOperateHistory orderOperateHistory) {
        return orderOperateHistoryMapper.updateById(orderOperateHistory);
    }

    /**
     * 批量删除订单操作历史记录
     * 
     * @param ids 需要删除的订单操作历史记录主键
     * @return 结果
     */
    @Override
    public int deleteOrderOperateHistoryByIds(Long[] ids) {
        return orderOperateHistoryMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
