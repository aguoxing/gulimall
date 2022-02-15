package com.gulimall.coupon.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.coupon.domain.SkuFullReduction;

/**
 * 商品满减信息Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface SkuFullReductionMapper extends BaseMapper<SkuFullReduction> {

    /**
     * 查询商品满减信息列表
     * 
     * @param skuFullReduction 商品满减信息
     * @return 商品满减信息集合
     */
    List<SkuFullReduction> selectSkuFullReductionList(SkuFullReduction skuFullReduction);

}
