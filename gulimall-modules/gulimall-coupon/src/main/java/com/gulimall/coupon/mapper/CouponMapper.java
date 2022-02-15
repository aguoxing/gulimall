package com.gulimall.coupon.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.coupon.domain.Coupon;

/**
 * 优惠券信息Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface CouponMapper extends BaseMapper<Coupon> {

    /**
     * 查询优惠券信息列表
     * 
     * @param coupon 优惠券信息
     * @return 优惠券信息集合
     */
    List<Coupon> selectCouponList(Coupon coupon);

}
