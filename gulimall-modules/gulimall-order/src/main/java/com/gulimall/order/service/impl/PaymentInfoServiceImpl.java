package com.gulimall.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimall.common.core.utils.DateUtils;
import com.gulimall.order.domain.PaymentInfo;
import com.gulimall.order.mapper.PaymentInfoMapper;
import com.gulimall.order.service.IPaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 支付信息Service业务层处理
 *
 * @author admin
 * @date 2022-02-15
 */
@Service
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfo> implements IPaymentInfoService {
    @Autowired
    private PaymentInfoMapper paymentInfoMapper;

    /**
     * 查询支付信息
     *
     * @param id 支付信息主键
     * @return 支付信息
     */
    @Override
    public PaymentInfo selectPaymentInfoById(Long id) {
        return paymentInfoMapper.selectById(id);
    }

    /**
     * 查询支付信息列表
     *
     * @param paymentInfo 支付信息
     * @return 支付信息
     */
    @Override
    public List<PaymentInfo> selectPaymentInfoList(PaymentInfo paymentInfo) {
        return paymentInfoMapper.selectPaymentInfoList(paymentInfo);
    }

    /**
     * 新增支付信息
     *
     * @param paymentInfo 支付信息
     * @return 结果
     */
    @Override
    public int insertPaymentInfo(PaymentInfo paymentInfo) {
        paymentInfo.setCreateTime(DateUtils.getNowDate());
        return paymentInfoMapper.insert(paymentInfo);
    }

    /**
     * 修改支付信息
     *
     * @param paymentInfo 支付信息
     * @return 结果
     */
    @Override
    public int updatePaymentInfo(PaymentInfo paymentInfo) {
        return paymentInfoMapper.updateById(paymentInfo);
    }

    /**
     * 批量删除支付信息
     *
     * @param ids 需要删除的支付信息主键
     * @return 结果
     */
    @Override
    public int deletePaymentInfoByIds(Long[] ids) {
        return paymentInfoMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
