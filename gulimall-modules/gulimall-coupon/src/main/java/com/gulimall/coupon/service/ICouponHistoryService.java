package com.gulimall.coupon.service;

import java.util.List;
import com.gulimall.coupon.domain.CouponHistory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 优惠券领取历史记录Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface ICouponHistoryService extends IService<CouponHistory> {
    /**
     * 查询优惠券领取历史记录
     *
     * @param id 优惠券领取历史记录主键
     * @return 优惠券领取历史记录
     */
    CouponHistory selectCouponHistoryById(Long id);

    /**
     * 查询优惠券领取历史记录列表
     * 
     * @param couponHistory 优惠券领取历史记录
     * @return 优惠券领取历史记录集合
     */
    List<CouponHistory> selectCouponHistoryList(CouponHistory couponHistory);

    /**
     * 新增优惠券领取历史记录
     * 
     * @param couponHistory 优惠券领取历史记录
     * @return 结果
     */
    int insertCouponHistory(CouponHistory couponHistory);

    /**
     * 修改优惠券领取历史记录
     * 
     * @param couponHistory 优惠券领取历史记录
     * @return 结果
     */
    int updateCouponHistory(CouponHistory couponHistory);

    /**
     * 批量删除优惠券领取历史记录
     * 
     * @param ids 需要删除的优惠券领取历史记录主键集合
     * @return 结果
     */
    int deleteCouponHistoryByIds(Long[] ids);

}
