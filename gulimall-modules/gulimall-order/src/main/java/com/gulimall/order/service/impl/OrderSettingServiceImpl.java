package com.gulimall.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimall.order.domain.OrderSetting;
import com.gulimall.order.mapper.OrderSettingMapper;
import com.gulimall.order.service.IOrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 订单配置信息Service业务层处理
 *
 * @author admin
 * @date 2022-02-15
 */
@Service
public class OrderSettingServiceImpl extends ServiceImpl<OrderSettingMapper, OrderSetting> implements IOrderSettingService {
    @Autowired
    private OrderSettingMapper orderSettingMapper;

    /**
     * 查询订单配置信息
     *
     * @param id 订单配置信息主键
     * @return 订单配置信息
     */
    @Override
    public OrderSetting selectOrderSettingById(Long id) {
        return orderSettingMapper.selectById(id);
    }

    /**
     * 查询订单配置信息列表
     *
     * @param orderSetting 订单配置信息
     * @return 订单配置信息
     */
    @Override
    public List<OrderSetting> selectOrderSettingList(OrderSetting orderSetting) {
        return orderSettingMapper.selectOrderSettingList(orderSetting);
    }

    /**
     * 新增订单配置信息
     *
     * @param orderSetting 订单配置信息
     * @return 结果
     */
    @Override
    public int insertOrderSetting(OrderSetting orderSetting) {
        return orderSettingMapper.insert(orderSetting);
    }

    /**
     * 修改订单配置信息
     *
     * @param orderSetting 订单配置信息
     * @return 结果
     */
    @Override
    public int updateOrderSetting(OrderSetting orderSetting) {
        return orderSettingMapper.updateById(orderSetting);
    }

    /**
     * 批量删除订单配置信息
     *
     * @param ids 需要删除的订单配置信息主键
     * @return 结果
     */
    @Override
    public int deleteOrderSettingByIds(Long[] ids) {
        return orderSettingMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
