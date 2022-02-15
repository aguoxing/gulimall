package com.gulimall.member.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.member.domain.GrowthChangeHistory;

/**
 * 成长值变化历史记录Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface GrowthChangeHistoryMapper extends BaseMapper<GrowthChangeHistory> {

    /**
     * 查询成长值变化历史记录列表
     * 
     * @param growthChangeHistory 成长值变化历史记录
     * @return 成长值变化历史记录集合
     */
    List<GrowthChangeHistory> selectGrowthChangeHistoryList(GrowthChangeHistory growthChangeHistory);

}
