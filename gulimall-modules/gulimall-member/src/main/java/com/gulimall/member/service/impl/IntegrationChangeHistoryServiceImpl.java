package com.gulimall.member.service.impl;

import java.util.Arrays;
import java.util.List;
import com.gulimall.common.core.utils.DateUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.member.mapper.IntegrationChangeHistoryMapper;
import com.gulimall.member.domain.IntegrationChangeHistory;
import com.gulimall.member.service.IIntegrationChangeHistoryService;

/**
 * 积分变化历史记录Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class IntegrationChangeHistoryServiceImpl extends ServiceImpl<IntegrationChangeHistoryMapper, IntegrationChangeHistory> implements IIntegrationChangeHistoryService {
    @Autowired
    private IntegrationChangeHistoryMapper integrationChangeHistoryMapper;

    /**
     * 查询积分变化历史记录
     * 
     * @param id 积分变化历史记录主键
     * @return 积分变化历史记录
     */
    @Override
    public IntegrationChangeHistory selectIntegrationChangeHistoryById(Long id) {
        return integrationChangeHistoryMapper.selectById(id);
    }

    /**
     * 查询积分变化历史记录列表
     * 
     * @param integrationChangeHistory 积分变化历史记录
     * @return 积分变化历史记录
     */
    @Override
    public List<IntegrationChangeHistory> selectIntegrationChangeHistoryList(IntegrationChangeHistory integrationChangeHistory) {
        return integrationChangeHistoryMapper.selectIntegrationChangeHistoryList(integrationChangeHistory);
    }

    /**
     * 新增积分变化历史记录
     * 
     * @param integrationChangeHistory 积分变化历史记录
     * @return 结果
     */
    @Override
    public int insertIntegrationChangeHistory(IntegrationChangeHistory integrationChangeHistory) {
        integrationChangeHistory.setCreateTime(DateUtils.getNowDate());
        return integrationChangeHistoryMapper.insert(integrationChangeHistory);
    }

    /**
     * 修改积分变化历史记录
     * 
     * @param integrationChangeHistory 积分变化历史记录
     * @return 结果
     */
    @Override
    public int updateIntegrationChangeHistory(IntegrationChangeHistory integrationChangeHistory) {
        return integrationChangeHistoryMapper.updateById(integrationChangeHistory);
    }

    /**
     * 批量删除积分变化历史记录
     * 
     * @param ids 需要删除的积分变化历史记录主键
     * @return 结果
     */
    @Override
    public int deleteIntegrationChangeHistoryByIds(Long[] ids) {
        return integrationChangeHistoryMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
