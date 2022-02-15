package com.gulimall.coupon.service;

import java.util.List;
import com.gulimall.coupon.domain.CouponSpuCategoryRelation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 优惠券分类关联Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface ICouponSpuCategoryRelationService extends IService<CouponSpuCategoryRelation> {
    /**
     * 查询优惠券分类关联
     *
     * @param id 优惠券分类关联主键
     * @return 优惠券分类关联
     */
    CouponSpuCategoryRelation selectCouponSpuCategoryRelationById(Long id);

    /**
     * 查询优惠券分类关联列表
     * 
     * @param couponSpuCategoryRelation 优惠券分类关联
     * @return 优惠券分类关联集合
     */
    List<CouponSpuCategoryRelation> selectCouponSpuCategoryRelationList(CouponSpuCategoryRelation couponSpuCategoryRelation);

    /**
     * 新增优惠券分类关联
     * 
     * @param couponSpuCategoryRelation 优惠券分类关联
     * @return 结果
     */
    int insertCouponSpuCategoryRelation(CouponSpuCategoryRelation couponSpuCategoryRelation);

    /**
     * 修改优惠券分类关联
     * 
     * @param couponSpuCategoryRelation 优惠券分类关联
     * @return 结果
     */
    int updateCouponSpuCategoryRelation(CouponSpuCategoryRelation couponSpuCategoryRelation);

    /**
     * 批量删除优惠券分类关联
     * 
     * @param ids 需要删除的优惠券分类关联主键集合
     * @return 结果
     */
    int deleteCouponSpuCategoryRelationByIds(Long[] ids);

}
