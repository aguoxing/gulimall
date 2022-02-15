package com.gulimall.coupon.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.coupon.domain.SeckillSkuRelation;

/**
 * 秒杀活动商品关联Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface SeckillSkuRelationMapper extends BaseMapper<SeckillSkuRelation> {

    /**
     * 查询秒杀活动商品关联列表
     * 
     * @param seckillSkuRelation 秒杀活动商品关联
     * @return 秒杀活动商品关联集合
     */
    List<SeckillSkuRelation> selectSeckillSkuRelationList(SeckillSkuRelation seckillSkuRelation);

}
