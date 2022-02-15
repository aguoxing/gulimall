package com.gulimall.coupon.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.coupon.domain.MemberPrice;

/**
 * 商品会员价格Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface MemberPriceMapper extends BaseMapper<MemberPrice> {

    /**
     * 查询商品会员价格列表
     * 
     * @param memberPrice 商品会员价格
     * @return 商品会员价格集合
     */
    List<MemberPrice> selectMemberPriceList(MemberPrice memberPrice);

}
