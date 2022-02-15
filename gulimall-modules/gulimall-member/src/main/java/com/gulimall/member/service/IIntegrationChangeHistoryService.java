package com.gulimall.member.service;

import java.util.List;
import com.gulimall.member.domain.IntegrationChangeHistory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 积分变化历史记录Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface IIntegrationChangeHistoryService extends IService<IntegrationChangeHistory> {
    /**
     * 查询积分变化历史记录
     *
     * @param id 积分变化历史记录主键
     * @return 积分变化历史记录
     */
    IntegrationChangeHistory selectIntegrationChangeHistoryById(Long id);

    /**
     * 查询积分变化历史记录列表
     * 
     * @param integrationChangeHistory 积分变化历史记录
     * @return 积分变化历史记录集合
     */
    List<IntegrationChangeHistory> selectIntegrationChangeHistoryList(IntegrationChangeHistory integrationChangeHistory);

    /**
     * 新增积分变化历史记录
     * 
     * @param integrationChangeHistory 积分变化历史记录
     * @return 结果
     */
    int insertIntegrationChangeHistory(IntegrationChangeHistory integrationChangeHistory);

    /**
     * 修改积分变化历史记录
     * 
     * @param integrationChangeHistory 积分变化历史记录
     * @return 结果
     */
    int updateIntegrationChangeHistory(IntegrationChangeHistory integrationChangeHistory);

    /**
     * 批量删除积分变化历史记录
     * 
     * @param ids 需要删除的积分变化历史记录主键集合
     * @return 结果
     */
    int deleteIntegrationChangeHistoryByIds(Long[] ids);

}
