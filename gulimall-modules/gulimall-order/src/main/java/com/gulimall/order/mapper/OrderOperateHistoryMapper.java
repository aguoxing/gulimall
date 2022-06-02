package com.gulimall.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.order.domain.OrderOperateHistory;

import java.util.List;

/**
 * 订单操作历史记录Mapper接口
 *
 * @author admin
 * @date 2022-02-15
 */
public interface OrderOperateHistoryMapper extends BaseMapper<OrderOperateHistory> {

    /**
     * 查询订单操作历史记录列表
     *
     * @param orderOperateHistory 订单操作历史记录
     * @return 订单操作历史记录集合
     */
    List<OrderOperateHistory> selectOrderOperateHistoryList(OrderOperateHistory orderOperateHistory);

}
