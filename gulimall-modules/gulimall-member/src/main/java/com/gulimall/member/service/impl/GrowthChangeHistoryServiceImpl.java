package com.gulimall.member.service.impl;

import java.util.Arrays;
import java.util.List;
import com.gulimall.common.core.utils.DateUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.member.mapper.GrowthChangeHistoryMapper;
import com.gulimall.member.domain.GrowthChangeHistory;
import com.gulimall.member.service.IGrowthChangeHistoryService;

/**
 * 成长值变化历史记录Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class GrowthChangeHistoryServiceImpl extends ServiceImpl<GrowthChangeHistoryMapper, GrowthChangeHistory> implements IGrowthChangeHistoryService {
    @Autowired
    private GrowthChangeHistoryMapper growthChangeHistoryMapper;

    /**
     * 查询成长值变化历史记录
     * 
     * @param id 成长值变化历史记录主键
     * @return 成长值变化历史记录
     */
    @Override
    public GrowthChangeHistory selectGrowthChangeHistoryById(Long id) {
        return growthChangeHistoryMapper.selectById(id);
    }

    /**
     * 查询成长值变化历史记录列表
     * 
     * @param growthChangeHistory 成长值变化历史记录
     * @return 成长值变化历史记录
     */
    @Override
    public List<GrowthChangeHistory> selectGrowthChangeHistoryList(GrowthChangeHistory growthChangeHistory) {
        return growthChangeHistoryMapper.selectGrowthChangeHistoryList(growthChangeHistory);
    }

    /**
     * 新增成长值变化历史记录
     * 
     * @param growthChangeHistory 成长值变化历史记录
     * @return 结果
     */
    @Override
    public int insertGrowthChangeHistory(GrowthChangeHistory growthChangeHistory) {
        growthChangeHistory.setCreateTime(DateUtils.getNowDate());
        return growthChangeHistoryMapper.insert(growthChangeHistory);
    }

    /**
     * 修改成长值变化历史记录
     * 
     * @param growthChangeHistory 成长值变化历史记录
     * @return 结果
     */
    @Override
    public int updateGrowthChangeHistory(GrowthChangeHistory growthChangeHistory) {
        return growthChangeHistoryMapper.updateById(growthChangeHistory);
    }

    /**
     * 批量删除成长值变化历史记录
     * 
     * @param ids 需要删除的成长值变化历史记录主键
     * @return 结果
     */
    @Override
    public int deleteGrowthChangeHistoryByIds(Long[] ids) {
        return growthChangeHistoryMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
