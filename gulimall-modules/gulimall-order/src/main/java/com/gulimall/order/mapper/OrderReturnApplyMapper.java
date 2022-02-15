package com.gulimall.order.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.order.domain.OrderReturnApply;

/**
 * 订单退货申请Mapper接口
 * 
 * @author admin
 * @date 2022-02-15
 */
public interface OrderReturnApplyMapper extends BaseMapper<OrderReturnApply> {

    /**
     * 查询订单退货申请列表
     * 
     * @param orderReturnApply 订单退货申请
     * @return 订单退货申请集合
     */
    List<OrderReturnApply> selectOrderReturnApplyList(OrderReturnApply orderReturnApply);

}
