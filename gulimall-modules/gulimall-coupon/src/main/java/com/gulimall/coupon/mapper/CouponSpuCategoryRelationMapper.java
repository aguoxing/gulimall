package com.gulimall.coupon.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.coupon.domain.CouponSpuCategoryRelation;

/**
 * 优惠券分类关联Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface CouponSpuCategoryRelationMapper extends BaseMapper<CouponSpuCategoryRelation> {

    /**
     * 查询优惠券分类关联列表
     * 
     * @param couponSpuCategoryRelation 优惠券分类关联
     * @return 优惠券分类关联集合
     */
    List<CouponSpuCategoryRelation> selectCouponSpuCategoryRelationList(CouponSpuCategoryRelation couponSpuCategoryRelation);

}
