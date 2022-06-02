package com.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimall.order.domain.OrderSetting;

import java.util.List;

/**
 * 订单配置信息Service接口
 *
 * @author admin
 * @date 2022-02-15
 */
public interface IOrderSettingService extends IService<OrderSetting> {
    /**
     * 查询订单配置信息
     *
     * @param id 订单配置信息主键
     * @return 订单配置信息
     */
    OrderSetting selectOrderSettingById(Long id);

    /**
     * 查询订单配置信息列表
     *
     * @param orderSetting 订单配置信息
     * @return 订单配置信息集合
     */
    List<OrderSetting> selectOrderSettingList(OrderSetting orderSetting);

    /**
     * 新增订单配置信息
     *
     * @param orderSetting 订单配置信息
     * @return 结果
     */
    int insertOrderSetting(OrderSetting orderSetting);

    /**
     * 修改订单配置信息
     *
     * @param orderSetting 订单配置信息
     * @return 结果
     */
    int updateOrderSetting(OrderSetting orderSetting);

    /**
     * 批量删除订单配置信息
     *
     * @param ids 需要删除的订单配置信息主键集合
     * @return 结果
     */
    int deleteOrderSettingByIds(Long[] ids);

}
