package com.gulimall.coupon.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.coupon.domain.SeckillSession;

/**
 * 秒杀活动场次Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface SeckillSessionMapper extends BaseMapper<SeckillSession> {

    /**
     * 查询秒杀活动场次列表
     * 
     * @param seckillSession 秒杀活动场次
     * @return 秒杀活动场次集合
     */
    List<SeckillSession> selectSeckillSessionList(SeckillSession seckillSession);

}
