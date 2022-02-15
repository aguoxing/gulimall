package com.gulimall.coupon.service.impl;

import java.util.Arrays;
import java.util.List;
import com.gulimall.common.core.utils.DateUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.coupon.mapper.CouponHistoryMapper;
import com.gulimall.coupon.domain.CouponHistory;
import com.gulimall.coupon.service.ICouponHistoryService;

/**
 * 优惠券领取历史记录Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class CouponHistoryServiceImpl extends ServiceImpl<CouponHistoryMapper, CouponHistory> implements ICouponHistoryService {
    @Autowired
    private CouponHistoryMapper couponHistoryMapper;

    /**
     * 查询优惠券领取历史记录
     * 
     * @param id 优惠券领取历史记录主键
     * @return 优惠券领取历史记录
     */
    @Override
    public CouponHistory selectCouponHistoryById(Long id) {
        return couponHistoryMapper.selectById(id);
    }

    /**
     * 查询优惠券领取历史记录列表
     * 
     * @param couponHistory 优惠券领取历史记录
     * @return 优惠券领取历史记录
     */
    @Override
    public List<CouponHistory> selectCouponHistoryList(CouponHistory couponHistory) {
        return couponHistoryMapper.selectCouponHistoryList(couponHistory);
    }

    /**
     * 新增优惠券领取历史记录
     * 
     * @param couponHistory 优惠券领取历史记录
     * @return 结果
     */
    @Override
    public int insertCouponHistory(CouponHistory couponHistory) {
        couponHistory.setCreateTime(DateUtils.getNowDate());
        return couponHistoryMapper.insert(couponHistory);
    }

    /**
     * 修改优惠券领取历史记录
     * 
     * @param couponHistory 优惠券领取历史记录
     * @return 结果
     */
    @Override
    public int updateCouponHistory(CouponHistory couponHistory) {
        return couponHistoryMapper.updateById(couponHistory);
    }

    /**
     * 批量删除优惠券领取历史记录
     * 
     * @param ids 需要删除的优惠券领取历史记录主键
     * @return 结果
     */
    @Override
    public int deleteCouponHistoryByIds(Long[] ids) {
        return couponHistoryMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
