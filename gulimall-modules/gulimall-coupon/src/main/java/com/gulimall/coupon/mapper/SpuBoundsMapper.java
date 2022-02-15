package com.gulimall.coupon.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.coupon.domain.SpuBounds;

/**
 * 商品spu积分设置Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface SpuBoundsMapper extends BaseMapper<SpuBounds> {

    /**
     * 查询商品spu积分设置列表
     * 
     * @param spuBounds 商品spu积分设置
     * @return 商品spu积分设置集合
     */
    List<SpuBounds> selectSpuBoundsList(SpuBounds spuBounds);

}
