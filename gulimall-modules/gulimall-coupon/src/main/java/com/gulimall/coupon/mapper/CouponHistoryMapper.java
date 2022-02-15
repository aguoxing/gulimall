package com.gulimall.coupon.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.coupon.domain.CouponHistory;

/**
 * 优惠券领取历史记录Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface CouponHistoryMapper extends BaseMapper<CouponHistory> {

    /**
     * 查询优惠券领取历史记录列表
     * 
     * @param couponHistory 优惠券领取历史记录
     * @return 优惠券领取历史记录集合
     */
    List<CouponHistory> selectCouponHistoryList(CouponHistory couponHistory);

}
