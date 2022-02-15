package com.gulimall.order.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.order.domain.PaymentInfo;

/**
 * 支付信息Mapper接口
 * 
 * @author admin
 * @date 2022-02-15
 */
public interface PaymentInfoMapper extends BaseMapper<PaymentInfo> {

    /**
     * 查询支付信息列表
     * 
     * @param paymentInfo 支付信息
     * @return 支付信息集合
     */
    List<PaymentInfo> selectPaymentInfoList(PaymentInfo paymentInfo);

}
