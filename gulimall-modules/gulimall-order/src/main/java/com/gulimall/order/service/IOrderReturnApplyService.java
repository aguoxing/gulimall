package com.gulimall.order.service;

import java.util.List;
import com.gulimall.order.domain.OrderReturnApply;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 订单退货申请Service接口
 * 
 * @author admin
 * @date 2022-02-15
 */
public interface IOrderReturnApplyService extends IService<OrderReturnApply> {
    /**
     * 查询订单退货申请
     *
     * @param id 订单退货申请主键
     * @return 订单退货申请
     */
    OrderReturnApply selectOrderReturnApplyById(Long id);

    /**
     * 查询订单退货申请列表
     * 
     * @param orderReturnApply 订单退货申请
     * @return 订单退货申请集合
     */
    List<OrderReturnApply> selectOrderReturnApplyList(OrderReturnApply orderReturnApply);

    /**
     * 新增订单退货申请
     * 
     * @param orderReturnApply 订单退货申请
     * @return 结果
     */
    int insertOrderReturnApply(OrderReturnApply orderReturnApply);

    /**
     * 修改订单退货申请
     * 
     * @param orderReturnApply 订单退货申请
     * @return 结果
     */
    int updateOrderReturnApply(OrderReturnApply orderReturnApply);

    /**
     * 批量删除订单退货申请
     * 
     * @param ids 需要删除的订单退货申请主键集合
     * @return 结果
     */
    int deleteOrderReturnApplyByIds(Long[] ids);

}
