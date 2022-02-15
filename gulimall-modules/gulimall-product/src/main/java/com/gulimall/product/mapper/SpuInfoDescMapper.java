package com.gulimall.product.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.product.domain.SpuInfoDesc;

/**
 * spu信息介绍Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface SpuInfoDescMapper extends BaseMapper<SpuInfoDesc> {

    /**
     * 查询spu信息介绍列表
     * 
     * @param spuInfoDesc spu信息介绍
     * @return spu信息介绍集合
     */
    List<SpuInfoDesc> selectSpuInfoDescList(SpuInfoDesc spuInfoDesc);

}
