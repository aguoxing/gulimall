package com.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimall.order.domain.AlipayConfig;

import java.util.List;

/**
 * 支付宝配置类Service接口
 *
 * @author admin
 * @date 2022-06-02
 */
public interface IAlipayConfigService extends IService<AlipayConfig> {
    /**
     * 查询支付宝配置类
     *
     * @param configId 支付宝配置类主键
     * @return 支付宝配置类
     */
    AlipayConfig selectAlipayConfigByConfigId(String configId);

    /**
     * 查询支付宝配置类列表
     *
     * @param alipayConfig 支付宝配置类
     * @return 支付宝配置类集合
     */
    List<AlipayConfig> selectAlipayConfigList(AlipayConfig alipayConfig);

    /**
     * 新增支付宝配置类
     *
     * @param alipayConfig 支付宝配置类
     * @return 结果
     */
    int insertAlipayConfig(AlipayConfig alipayConfig);

    /**
     * 修改支付宝配置类
     *
     * @param alipayConfig 支付宝配置类
     * @return 结果
     */
    int updateAlipayConfig(AlipayConfig alipayConfig);

    /**
     * 批量删除支付宝配置类
     *
     * @param configIds 需要删除的支付宝配置类主键集合
     * @return 结果
     */
    int deleteAlipayConfigByConfigIds(String[] configIds);

}
