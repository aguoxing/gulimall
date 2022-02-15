package com.gulimall.order.service;

import java.util.List;
import com.gulimall.order.domain.OrderOperateHistory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 订单操作历史记录Service接口
 * 
 * @author admin
 * @date 2022-02-15
 */
public interface IOrderOperateHistoryService extends IService<OrderOperateHistory> {
    /**
     * 查询订单操作历史记录
     *
     * @param id 订单操作历史记录主键
     * @return 订单操作历史记录
     */
    OrderOperateHistory selectOrderOperateHistoryById(Long id);

    /**
     * 查询订单操作历史记录列表
     * 
     * @param orderOperateHistory 订单操作历史记录
     * @return 订单操作历史记录集合
     */
    List<OrderOperateHistory> selectOrderOperateHistoryList(OrderOperateHistory orderOperateHistory);

    /**
     * 新增订单操作历史记录
     * 
     * @param orderOperateHistory 订单操作历史记录
     * @return 结果
     */
    int insertOrderOperateHistory(OrderOperateHistory orderOperateHistory);

    /**
     * 修改订单操作历史记录
     * 
     * @param orderOperateHistory 订单操作历史记录
     * @return 结果
     */
    int updateOrderOperateHistory(OrderOperateHistory orderOperateHistory);

    /**
     * 批量删除订单操作历史记录
     * 
     * @param ids 需要删除的订单操作历史记录主键集合
     * @return 结果
     */
    int deleteOrderOperateHistoryByIds(Long[] ids);

}
