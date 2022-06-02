package com.gulimall.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.order.domain.OrderSetting;

import java.util.List;

/**
 * 订单配置信息Mapper接口
 *
 * @author admin
 * @date 2022-02-15
 */
public interface OrderSettingMapper extends BaseMapper<OrderSetting> {

    /**
     * 查询订单配置信息列表
     *
     * @param orderSetting 订单配置信息
     * @return 订单配置信息集合
     */
    List<OrderSetting> selectOrderSettingList(OrderSetting orderSetting);

}
