package com.gulimall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.product.domain.SpuInfo;

import java.util.List;

/**
 * spu信息Mapper接口
 *
 * @author admin
 * @date 2022-02-14
 */
public interface SpuInfoMapper extends BaseMapper<SpuInfo> {

    /**
     * 查询spu信息列表
     *
     * @param spuInfo spu信息
     * @return spu信息集合
     */
    List<SpuInfo> selectSpuInfoList(SpuInfo spuInfo);

}
