package com.gulimall.coupon.service.impl;

import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.coupon.mapper.CouponSpuCategoryRelationMapper;
import com.gulimall.coupon.domain.CouponSpuCategoryRelation;
import com.gulimall.coupon.service.ICouponSpuCategoryRelationService;

/**
 * 优惠券分类关联Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class CouponSpuCategoryRelationServiceImpl extends ServiceImpl<CouponSpuCategoryRelationMapper, CouponSpuCategoryRelation> implements ICouponSpuCategoryRelationService {
    @Autowired
    private CouponSpuCategoryRelationMapper couponSpuCategoryRelationMapper;

    /**
     * 查询优惠券分类关联
     * 
     * @param id 优惠券分类关联主键
     * @return 优惠券分类关联
     */
    @Override
    public CouponSpuCategoryRelation selectCouponSpuCategoryRelationById(Long id) {
        return couponSpuCategoryRelationMapper.selectById(id);
    }

    /**
     * 查询优惠券分类关联列表
     * 
     * @param couponSpuCategoryRelation 优惠券分类关联
     * @return 优惠券分类关联
     */
    @Override
    public List<CouponSpuCategoryRelation> selectCouponSpuCategoryRelationList(CouponSpuCategoryRelation couponSpuCategoryRelation) {
        return couponSpuCategoryRelationMapper.selectCouponSpuCategoryRelationList(couponSpuCategoryRelation);
    }

    /**
     * 新增优惠券分类关联
     * 
     * @param couponSpuCategoryRelation 优惠券分类关联
     * @return 结果
     */
    @Override
    public int insertCouponSpuCategoryRelation(CouponSpuCategoryRelation couponSpuCategoryRelation) {
        return couponSpuCategoryRelationMapper.insert(couponSpuCategoryRelation);
    }

    /**
     * 修改优惠券分类关联
     * 
     * @param couponSpuCategoryRelation 优惠券分类关联
     * @return 结果
     */
    @Override
    public int updateCouponSpuCategoryRelation(CouponSpuCategoryRelation couponSpuCategoryRelation) {
        return couponSpuCategoryRelationMapper.updateById(couponSpuCategoryRelation);
    }

    /**
     * 批量删除优惠券分类关联
     * 
     * @param ids 需要删除的优惠券分类关联主键
     * @return 结果
     */
    @Override
    public int deleteCouponSpuCategoryRelationByIds(Long[] ids) {
        return couponSpuCategoryRelationMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
