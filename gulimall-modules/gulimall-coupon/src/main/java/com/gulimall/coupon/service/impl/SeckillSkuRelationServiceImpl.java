package com.gulimall.coupon.service.impl;

import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.coupon.mapper.SeckillSkuRelationMapper;
import com.gulimall.coupon.domain.SeckillSkuRelation;
import com.gulimall.coupon.service.ISeckillSkuRelationService;

/**
 * 秒杀活动商品关联Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class SeckillSkuRelationServiceImpl extends ServiceImpl<SeckillSkuRelationMapper, SeckillSkuRelation> implements ISeckillSkuRelationService {
    @Autowired
    private SeckillSkuRelationMapper seckillSkuRelationMapper;

    /**
     * 查询秒杀活动商品关联
     * 
     * @param id 秒杀活动商品关联主键
     * @return 秒杀活动商品关联
     */
    @Override
    public SeckillSkuRelation selectSeckillSkuRelationById(Long id) {
        return seckillSkuRelationMapper.selectById(id);
    }

    /**
     * 查询秒杀活动商品关联列表
     * 
     * @param seckillSkuRelation 秒杀活动商品关联
     * @return 秒杀活动商品关联
     */
    @Override
    public List<SeckillSkuRelation> selectSeckillSkuRelationList(SeckillSkuRelation seckillSkuRelation) {
        return seckillSkuRelationMapper.selectSeckillSkuRelationList(seckillSkuRelation);
    }

    /**
     * 新增秒杀活动商品关联
     * 
     * @param seckillSkuRelation 秒杀活动商品关联
     * @return 结果
     */
    @Override
    public int insertSeckillSkuRelation(SeckillSkuRelation seckillSkuRelation) {
        return seckillSkuRelationMapper.insert(seckillSkuRelation);
    }

    /**
     * 修改秒杀活动商品关联
     * 
     * @param seckillSkuRelation 秒杀活动商品关联
     * @return 结果
     */
    @Override
    public int updateSeckillSkuRelation(SeckillSkuRelation seckillSkuRelation) {
        return seckillSkuRelationMapper.updateById(seckillSkuRelation);
    }

    /**
     * 批量删除秒杀活动商品关联
     * 
     * @param ids 需要删除的秒杀活动商品关联主键
     * @return 结果
     */
    @Override
    public int deleteSeckillSkuRelationByIds(Long[] ids) {
        return seckillSkuRelationMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
