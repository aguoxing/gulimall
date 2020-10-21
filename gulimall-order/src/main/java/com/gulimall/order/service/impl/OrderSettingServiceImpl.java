package com.gulimall.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimall.order.entity.OrderSetting;
import com.gulimall.order.mapper.OrderSettingMapper;
import com.gulimall.order.service.OrderSettingService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单配置信息 服务实现类
 * </p>
 *
 * @author guoxing
 * @since 2020-10-21
 */
@Service
public class OrderSettingServiceImpl extends ServiceImpl<OrderSettingMapper, OrderSetting> implements OrderSettingService {

}
