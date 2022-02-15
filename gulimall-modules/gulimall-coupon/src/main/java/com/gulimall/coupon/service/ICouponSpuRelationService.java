package com.gulimall.coupon.service;

import java.util.List;
import com.gulimall.coupon.domain.CouponSpuRelation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 优惠券与产品关联Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface ICouponSpuRelationService extends IService<CouponSpuRelation> {
    /**
     * 查询优惠券与产品关联
     *
     * @param id 优惠券与产品关联主键
     * @return 优惠券与产品关联
     */
    CouponSpuRelation selectCouponSpuRelationById(Long id);

    /**
     * 查询优惠券与产品关联列表
     * 
     * @param couponSpuRelation 优惠券与产品关联
     * @return 优惠券与产品关联集合
     */
    List<CouponSpuRelation> selectCouponSpuRelationList(CouponSpuRelation couponSpuRelation);

    /**
     * 新增优惠券与产品关联
     * 
     * @param couponSpuRelation 优惠券与产品关联
     * @return 结果
     */
    int insertCouponSpuRelation(CouponSpuRelation couponSpuRelation);

    /**
     * 修改优惠券与产品关联
     * 
     * @param couponSpuRelation 优惠券与产品关联
     * @return 结果
     */
    int updateCouponSpuRelation(CouponSpuRelation couponSpuRelation);

    /**
     * 批量删除优惠券与产品关联
     * 
     * @param ids 需要删除的优惠券与产品关联主键集合
     * @return 结果
     */
    int deleteCouponSpuRelationByIds(Long[] ids);

}
