package com.gulimall.order.service.impl;

import java.util.Arrays;
import java.util.List;
import com.gulimall.common.core.utils.DateUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.order.mapper.OrderReturnApplyMapper;
import com.gulimall.order.domain.OrderReturnApply;
import com.gulimall.order.service.IOrderReturnApplyService;

/**
 * 订单退货申请Service业务层处理
 * 
 * @author admin
 * @date 2022-02-15
 */
@Service
public class OrderReturnApplyServiceImpl extends ServiceImpl<OrderReturnApplyMapper, OrderReturnApply> implements IOrderReturnApplyService {
    @Autowired
    private OrderReturnApplyMapper orderReturnApplyMapper;

    /**
     * 查询订单退货申请
     * 
     * @param id 订单退货申请主键
     * @return 订单退货申请
     */
    @Override
    public OrderReturnApply selectOrderReturnApplyById(Long id) {
        return orderReturnApplyMapper.selectById(id);
    }

    /**
     * 查询订单退货申请列表
     * 
     * @param orderReturnApply 订单退货申请
     * @return 订单退货申请
     */
    @Override
    public List<OrderReturnApply> selectOrderReturnApplyList(OrderReturnApply orderReturnApply) {
        return orderReturnApplyMapper.selectOrderReturnApplyList(orderReturnApply);
    }

    /**
     * 新增订单退货申请
     * 
     * @param orderReturnApply 订单退货申请
     * @return 结果
     */
    @Override
    public int insertOrderReturnApply(OrderReturnApply orderReturnApply) {
        orderReturnApply.setCreateTime(DateUtils.getNowDate());
        return orderReturnApplyMapper.insert(orderReturnApply);
    }

    /**
     * 修改订单退货申请
     * 
     * @param orderReturnApply 订单退货申请
     * @return 结果
     */
    @Override
    public int updateOrderReturnApply(OrderReturnApply orderReturnApply) {
        return orderReturnApplyMapper.updateById(orderReturnApply);
    }

    /**
     * 批量删除订单退货申请
     * 
     * @param ids 需要删除的订单退货申请主键
     * @return 结果
     */
    @Override
    public int deleteOrderReturnApplyByIds(Long[] ids) {
        return orderReturnApplyMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
