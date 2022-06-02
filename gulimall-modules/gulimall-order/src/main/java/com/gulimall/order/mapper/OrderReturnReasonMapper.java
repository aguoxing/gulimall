package com.gulimall.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.order.domain.OrderReturnReason;

import java.util.List;

/**
 * 退货原因Mapper接口
 *
 * @author admin
 * @date 2022-02-15
 */
public interface OrderReturnReasonMapper extends BaseMapper<OrderReturnReason> {

    /**
     * 查询退货原因列表
     *
     * @param orderReturnReason 退货原因
     * @return 退货原因集合
     */
    List<OrderReturnReason> selectOrderReturnReasonList(OrderReturnReason orderReturnReason);

}
