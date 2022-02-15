package com.gulimall.coupon.service.impl;

import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.coupon.mapper.CouponSpuRelationMapper;
import com.gulimall.coupon.domain.CouponSpuRelation;
import com.gulimall.coupon.service.ICouponSpuRelationService;

/**
 * 优惠券与产品关联Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class CouponSpuRelationServiceImpl extends ServiceImpl<CouponSpuRelationMapper, CouponSpuRelation> implements ICouponSpuRelationService {
    @Autowired
    private CouponSpuRelationMapper couponSpuRelationMapper;

    /**
     * 查询优惠券与产品关联
     * 
     * @param id 优惠券与产品关联主键
     * @return 优惠券与产品关联
     */
    @Override
    public CouponSpuRelation selectCouponSpuRelationById(Long id) {
        return couponSpuRelationMapper.selectById(id);
    }

    /**
     * 查询优惠券与产品关联列表
     * 
     * @param couponSpuRelation 优惠券与产品关联
     * @return 优惠券与产品关联
     */
    @Override
    public List<CouponSpuRelation> selectCouponSpuRelationList(CouponSpuRelation couponSpuRelation) {
        return couponSpuRelationMapper.selectCouponSpuRelationList(couponSpuRelation);
    }

    /**
     * 新增优惠券与产品关联
     * 
     * @param couponSpuRelation 优惠券与产品关联
     * @return 结果
     */
    @Override
    public int insertCouponSpuRelation(CouponSpuRelation couponSpuRelation) {
        return couponSpuRelationMapper.insert(couponSpuRelation);
    }

    /**
     * 修改优惠券与产品关联
     * 
     * @param couponSpuRelation 优惠券与产品关联
     * @return 结果
     */
    @Override
    public int updateCouponSpuRelation(CouponSpuRelation couponSpuRelation) {
        return couponSpuRelationMapper.updateById(couponSpuRelation);
    }

    /**
     * 批量删除优惠券与产品关联
     * 
     * @param ids 需要删除的优惠券与产品关联主键
     * @return 结果
     */
    @Override
    public int deleteCouponSpuRelationByIds(Long[] ids) {
        return couponSpuRelationMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
