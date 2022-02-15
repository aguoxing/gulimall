package com.gulimall.order.service.impl;

import java.util.Arrays;
import java.util.List;
import com.gulimall.common.core.utils.DateUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.order.mapper.OrderReturnReasonMapper;
import com.gulimall.order.domain.OrderReturnReason;
import com.gulimall.order.service.IOrderReturnReasonService;

/**
 * 退货原因Service业务层处理
 * 
 * @author admin
 * @date 2022-02-15
 */
@Service
public class OrderReturnReasonServiceImpl extends ServiceImpl<OrderReturnReasonMapper, OrderReturnReason> implements IOrderReturnReasonService {
    @Autowired
    private OrderReturnReasonMapper orderReturnReasonMapper;

    /**
     * 查询退货原因
     * 
     * @param id 退货原因主键
     * @return 退货原因
     */
    @Override
    public OrderReturnReason selectOrderReturnReasonById(Long id) {
        return orderReturnReasonMapper.selectById(id);
    }

    /**
     * 查询退货原因列表
     * 
     * @param orderReturnReason 退货原因
     * @return 退货原因
     */
    @Override
    public List<OrderReturnReason> selectOrderReturnReasonList(OrderReturnReason orderReturnReason) {
        return orderReturnReasonMapper.selectOrderReturnReasonList(orderReturnReason);
    }

    /**
     * 新增退货原因
     * 
     * @param orderReturnReason 退货原因
     * @return 结果
     */
    @Override
    public int insertOrderReturnReason(OrderReturnReason orderReturnReason) {
        orderReturnReason.setCreateTime(DateUtils.getNowDate());
        return orderReturnReasonMapper.insert(orderReturnReason);
    }

    /**
     * 修改退货原因
     * 
     * @param orderReturnReason 退货原因
     * @return 结果
     */
    @Override
    public int updateOrderReturnReason(OrderReturnReason orderReturnReason) {
        return orderReturnReasonMapper.updateById(orderReturnReason);
    }

    /**
     * 批量删除退货原因
     * 
     * @param ids 需要删除的退货原因主键
     * @return 结果
     */
    @Override
    public int deleteOrderReturnReasonByIds(Long[] ids) {
        return orderReturnReasonMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
