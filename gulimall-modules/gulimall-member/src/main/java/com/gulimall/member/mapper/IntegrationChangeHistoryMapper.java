package com.gulimall.member.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.member.domain.IntegrationChangeHistory;

/**
 * 积分变化历史记录Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface IntegrationChangeHistoryMapper extends BaseMapper<IntegrationChangeHistory> {

    /**
     * 查询积分变化历史记录列表
     * 
     * @param integrationChangeHistory 积分变化历史记录
     * @return 积分变化历史记录集合
     */
    List<IntegrationChangeHistory> selectIntegrationChangeHistoryList(IntegrationChangeHistory integrationChangeHistory);

}
