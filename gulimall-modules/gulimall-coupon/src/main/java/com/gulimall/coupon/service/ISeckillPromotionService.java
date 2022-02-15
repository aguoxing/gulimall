package com.gulimall.coupon.service;

import java.util.List;
import com.gulimall.coupon.domain.SeckillPromotion;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 秒杀活动Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface ISeckillPromotionService extends IService<SeckillPromotion> {
    /**
     * 查询秒杀活动
     *
     * @param id 秒杀活动主键
     * @return 秒杀活动
     */
    SeckillPromotion selectSeckillPromotionById(Long id);

    /**
     * 查询秒杀活动列表
     * 
     * @param seckillPromotion 秒杀活动
     * @return 秒杀活动集合
     */
    List<SeckillPromotion> selectSeckillPromotionList(SeckillPromotion seckillPromotion);

    /**
     * 新增秒杀活动
     * 
     * @param seckillPromotion 秒杀活动
     * @return 结果
     */
    int insertSeckillPromotion(SeckillPromotion seckillPromotion);

    /**
     * 修改秒杀活动
     * 
     * @param seckillPromotion 秒杀活动
     * @return 结果
     */
    int updateSeckillPromotion(SeckillPromotion seckillPromotion);

    /**
     * 批量删除秒杀活动
     * 
     * @param ids 需要删除的秒杀活动主键集合
     * @return 结果
     */
    int deleteSeckillPromotionByIds(Long[] ids);

}
