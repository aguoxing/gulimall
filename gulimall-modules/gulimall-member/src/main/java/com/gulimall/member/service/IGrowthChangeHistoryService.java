package com.gulimall.member.service;

import java.util.List;
import com.gulimall.member.domain.GrowthChangeHistory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 成长值变化历史记录Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface IGrowthChangeHistoryService extends IService<GrowthChangeHistory> {
    /**
     * 查询成长值变化历史记录
     *
     * @param id 成长值变化历史记录主键
     * @return 成长值变化历史记录
     */
    GrowthChangeHistory selectGrowthChangeHistoryById(Long id);

    /**
     * 查询成长值变化历史记录列表
     * 
     * @param growthChangeHistory 成长值变化历史记录
     * @return 成长值变化历史记录集合
     */
    List<GrowthChangeHistory> selectGrowthChangeHistoryList(GrowthChangeHistory growthChangeHistory);

    /**
     * 新增成长值变化历史记录
     * 
     * @param growthChangeHistory 成长值变化历史记录
     * @return 结果
     */
    int insertGrowthChangeHistory(GrowthChangeHistory growthChangeHistory);

    /**
     * 修改成长值变化历史记录
     * 
     * @param growthChangeHistory 成长值变化历史记录
     * @return 结果
     */
    int updateGrowthChangeHistory(GrowthChangeHistory growthChangeHistory);

    /**
     * 批量删除成长值变化历史记录
     * 
     * @param ids 需要删除的成长值变化历史记录主键集合
     * @return 结果
     */
    int deleteGrowthChangeHistoryByIds(Long[] ids);

}
