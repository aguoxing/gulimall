package com.gulimall.coupon.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.coupon.domain.SeckillSkuNotice;

/**
 * 秒杀商品通知订阅Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface SeckillSkuNoticeMapper extends BaseMapper<SeckillSkuNotice> {

    /**
     * 查询秒杀商品通知订阅列表
     * 
     * @param seckillSkuNotice 秒杀商品通知订阅
     * @return 秒杀商品通知订阅集合
     */
    List<SeckillSkuNotice> selectSeckillSkuNoticeList(SeckillSkuNotice seckillSkuNotice);

}
