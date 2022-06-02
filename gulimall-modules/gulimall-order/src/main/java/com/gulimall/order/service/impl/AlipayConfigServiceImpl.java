package com.gulimall.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimall.order.domain.AlipayConfig;
import com.gulimall.order.mapper.AlipayConfigMapper;
import com.gulimall.order.service.IAlipayConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 支付宝配置类Service业务层处理
 *
 * @author admin
 * @date 2022-06-02
 */
@Service
public class AlipayConfigServiceImpl extends ServiceImpl<AlipayConfigMapper, AlipayConfig> implements IAlipayConfigService {
    @Autowired
    private AlipayConfigMapper alipayConfigMapper;

    /**
     * 查询支付宝配置类
     *
     * @param configId 支付宝配置类主键
     * @return 支付宝配置类
     */
    @Override
    public AlipayConfig selectAlipayConfigByConfigId(String configId) {
        return alipayConfigMapper.selectById(configId);
    }

    /**
     * 查询支付宝配置类列表
     *
     * @param alipayConfig 支付宝配置类
     * @return 支付宝配置类
     */
    @Override
    public List<AlipayConfig> selectAlipayConfigList(AlipayConfig alipayConfig) {
        return alipayConfigMapper.selectAlipayConfigList(alipayConfig);
    }

    /**
     * 新增支付宝配置类
     *
     * @param alipayConfig 支付宝配置类
     * @return 结果
     */
    @Override
    public int insertAlipayConfig(AlipayConfig alipayConfig) {
        return alipayConfigMapper.insert(alipayConfig);
    }

    /**
     * 修改支付宝配置类
     *
     * @param alipayConfig 支付宝配置类
     * @return 结果
     */
    @Override
    public int updateAlipayConfig(AlipayConfig alipayConfig) {
        return alipayConfigMapper.updateById(alipayConfig);
    }

    /**
     * 批量删除支付宝配置类
     *
     * @param configIds 需要删除的支付宝配置类主键
     * @return 结果
     */
    @Override
    public int deleteAlipayConfigByConfigIds(String[] configIds) {
        return alipayConfigMapper.deleteBatchIds(Arrays.asList(configIds));
    }

}
