package com.gulimall.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.order.domain.AlipayConfig;

import java.util.List;

/**
 * 支付宝配置类Mapper接口
 *
 * @author admin
 * @date 2022-06-02
 */
public interface AlipayConfigMapper extends BaseMapper<AlipayConfig> {

    /**
     * 查询支付宝配置类列表
     *
     * @param alipayConfig 支付宝配置类
     * @return 支付宝配置类集合
     */
    List<AlipayConfig> selectAlipayConfigList(AlipayConfig alipayConfig);

}
