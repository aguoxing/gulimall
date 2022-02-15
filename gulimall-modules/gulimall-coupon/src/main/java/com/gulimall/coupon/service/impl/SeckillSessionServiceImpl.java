package com.gulimall.coupon.service.impl;

import java.util.Arrays;
import java.util.List;
import com.gulimall.common.core.utils.DateUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.coupon.mapper.SeckillSessionMapper;
import com.gulimall.coupon.domain.SeckillSession;
import com.gulimall.coupon.service.ISeckillSessionService;

/**
 * 秒杀活动场次Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class SeckillSessionServiceImpl extends ServiceImpl<SeckillSessionMapper, SeckillSession> implements ISeckillSessionService {
    @Autowired
    private SeckillSessionMapper seckillSessionMapper;

    /**
     * 查询秒杀活动场次
     * 
     * @param id 秒杀活动场次主键
     * @return 秒杀活动场次
     */
    @Override
    public SeckillSession selectSeckillSessionById(Long id) {
        return seckillSessionMapper.selectById(id);
    }

    /**
     * 查询秒杀活动场次列表
     * 
     * @param seckillSession 秒杀活动场次
     * @return 秒杀活动场次
     */
    @Override
    public List<SeckillSession> selectSeckillSessionList(SeckillSession seckillSession) {
        return seckillSessionMapper.selectSeckillSessionList(seckillSession);
    }

    /**
     * 新增秒杀活动场次
     * 
     * @param seckillSession 秒杀活动场次
     * @return 结果
     */
    @Override
    public int insertSeckillSession(SeckillSession seckillSession) {
        seckillSession.setCreateTime(DateUtils.getNowDate());
        return seckillSessionMapper.insert(seckillSession);
    }

    /**
     * 修改秒杀活动场次
     * 
     * @param seckillSession 秒杀活动场次
     * @return 结果
     */
    @Override
    public int updateSeckillSession(SeckillSession seckillSession) {
        return seckillSessionMapper.updateById(seckillSession);
    }

    /**
     * 批量删除秒杀活动场次
     * 
     * @param ids 需要删除的秒杀活动场次主键
     * @return 结果
     */
    @Override
    public int deleteSeckillSessionByIds(Long[] ids) {
        return seckillSessionMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
