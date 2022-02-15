package com.gulimall.coupon.service;

import java.util.List;
import com.gulimall.coupon.domain.SeckillSession;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 秒杀活动场次Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface ISeckillSessionService extends IService<SeckillSession> {
    /**
     * 查询秒杀活动场次
     *
     * @param id 秒杀活动场次主键
     * @return 秒杀活动场次
     */
    SeckillSession selectSeckillSessionById(Long id);

    /**
     * 查询秒杀活动场次列表
     * 
     * @param seckillSession 秒杀活动场次
     * @return 秒杀活动场次集合
     */
    List<SeckillSession> selectSeckillSessionList(SeckillSession seckillSession);

    /**
     * 新增秒杀活动场次
     * 
     * @param seckillSession 秒杀活动场次
     * @return 结果
     */
    int insertSeckillSession(SeckillSession seckillSession);

    /**
     * 修改秒杀活动场次
     * 
     * @param seckillSession 秒杀活动场次
     * @return 结果
     */
    int updateSeckillSession(SeckillSession seckillSession);

    /**
     * 批量删除秒杀活动场次
     * 
     * @param ids 需要删除的秒杀活动场次主键集合
     * @return 结果
     */
    int deleteSeckillSessionByIds(Long[] ids);

}
