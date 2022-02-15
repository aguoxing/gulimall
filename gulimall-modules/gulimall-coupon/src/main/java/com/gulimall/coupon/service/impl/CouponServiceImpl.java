package com.gulimall.coupon.service.impl;

import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.coupon.mapper.CouponMapper;
import com.gulimall.coupon.domain.Coupon;
import com.gulimall.coupon.service.ICouponService;

/**
 * 优惠券信息Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements ICouponService {
    @Autowired
    private CouponMapper couponMapper;

    /**
     * 查询优惠券信息
     * 
     * @param id 优惠券信息主键
     * @return 优惠券信息
     */
    @Override
    public Coupon selectCouponById(Long id) {
        return couponMapper.selectById(id);
    }

    /**
     * 查询优惠券信息列表
     * 
     * @param coupon 优惠券信息
     * @return 优惠券信息
     */
    @Override
    public List<Coupon> selectCouponList(Coupon coupon) {
        return couponMapper.selectCouponList(coupon);
    }

    /**
     * 新增优惠券信息
     * 
     * @param coupon 优惠券信息
     * @return 结果
     */
    @Override
    public int insertCoupon(Coupon coupon) {
        return couponMapper.insert(coupon);
    }

    /**
     * 修改优惠券信息
     * 
     * @param coupon 优惠券信息
     * @return 结果
     */
    @Override
    public int updateCoupon(Coupon coupon) {
        return couponMapper.updateById(coupon);
    }

    /**
     * 批量删除优惠券信息
     * 
     * @param ids 需要删除的优惠券信息主键
     * @return 结果
     */
    @Override
    public int deleteCouponByIds(Long[] ids) {
        return couponMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
