package com.gulimall.coupon.service;

import java.util.List;
import com.gulimall.coupon.domain.SeckillSkuRelation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 秒杀活动商品关联Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface ISeckillSkuRelationService extends IService<SeckillSkuRelation> {
    /**
     * 查询秒杀活动商品关联
     *
     * @param id 秒杀活动商品关联主键
     * @return 秒杀活动商品关联
     */
    SeckillSkuRelation selectSeckillSkuRelationById(Long id);

    /**
     * 查询秒杀活动商品关联列表
     * 
     * @param seckillSkuRelation 秒杀活动商品关联
     * @return 秒杀活动商品关联集合
     */
    List<SeckillSkuRelation> selectSeckillSkuRelationList(SeckillSkuRelation seckillSkuRelation);

    /**
     * 新增秒杀活动商品关联
     * 
     * @param seckillSkuRelation 秒杀活动商品关联
     * @return 结果
     */
    int insertSeckillSkuRelation(SeckillSkuRelation seckillSkuRelation);

    /**
     * 修改秒杀活动商品关联
     * 
     * @param seckillSkuRelation 秒杀活动商品关联
     * @return 结果
     */
    int updateSeckillSkuRelation(SeckillSkuRelation seckillSkuRelation);

    /**
     * 批量删除秒杀活动商品关联
     * 
     * @param ids 需要删除的秒杀活动商品关联主键集合
     * @return 结果
     */
    int deleteSeckillSkuRelationByIds(Long[] ids);

}
