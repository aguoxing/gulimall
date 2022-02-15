package com.gulimall.coupon.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.coupon.domain.SeckillPromotion;

/**
 * 秒杀活动Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface SeckillPromotionMapper extends BaseMapper<SeckillPromotion> {

    /**
     * 查询秒杀活动列表
     * 
     * @param seckillPromotion 秒杀活动
     * @return 秒杀活动集合
     */
    List<SeckillPromotion> selectSeckillPromotionList(SeckillPromotion seckillPromotion);

}
