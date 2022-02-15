package com.gulimall.coupon.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.coupon.domain.SkuLadder;

/**
 * 商品阶梯价格Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface SkuLadderMapper extends BaseMapper<SkuLadder> {

    /**
     * 查询商品阶梯价格列表
     * 
     * @param skuLadder 商品阶梯价格
     * @return 商品阶梯价格集合
     */
    List<SkuLadder> selectSkuLadderList(SkuLadder skuLadder);

}
