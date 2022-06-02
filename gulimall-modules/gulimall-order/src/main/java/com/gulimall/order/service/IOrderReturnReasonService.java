package com.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimall.order.domain.OrderReturnReason;

import java.util.List;

/**
 * 退货原因Service接口
 *
 * @author admin
 * @date 2022-02-15
 */
public interface IOrderReturnReasonService extends IService<OrderReturnReason> {
    /**
     * 查询退货原因
     *
     * @param id 退货原因主键
     * @return 退货原因
     */
    OrderReturnReason selectOrderReturnReasonById(Long id);

    /**
     * 查询退货原因列表
     *
     * @param orderReturnReason 退货原因
     * @return 退货原因集合
     */
    List<OrderReturnReason> selectOrderReturnReasonList(OrderReturnReason orderReturnReason);

    /**
     * 新增退货原因
     *
     * @param orderReturnReason 退货原因
     * @return 结果
     */
    int insertOrderReturnReason(OrderReturnReason orderReturnReason);

    /**
     * 修改退货原因
     *
     * @param orderReturnReason 退货原因
     * @return 结果
     */
    int updateOrderReturnReason(OrderReturnReason orderReturnReason);

    /**
     * 批量删除退货原因
     *
     * @param ids 需要删除的退货原因主键集合
     * @return 结果
     */
    int deleteOrderReturnReasonByIds(Long[] ids);

}
