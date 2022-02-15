package com.gulimall.coupon.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.coupon.domain.CouponSpuRelation;

/**
 * 优惠券与产品关联Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface CouponSpuRelationMapper extends BaseMapper<CouponSpuRelation> {

    /**
     * 查询优惠券与产品关联列表
     * 
     * @param couponSpuRelation 优惠券与产品关联
     * @return 优惠券与产品关联集合
     */
    List<CouponSpuRelation> selectCouponSpuRelationList(CouponSpuRelation couponSpuRelation);

}
