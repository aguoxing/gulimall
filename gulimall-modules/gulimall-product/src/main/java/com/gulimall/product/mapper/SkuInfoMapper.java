package com.gulimall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.product.domain.SkuInfo;

import java.util.List;

/**
 * sku信息Mapper接口
 *
 * @author admin
 * @date 2022-02-14
 */
public interface SkuInfoMapper extends BaseMapper<SkuInfo> {

    /**
     * 查询sku信息列表
     *
     * @param skuInfo sku信息
     * @return sku信息集合
     */
    List<SkuInfo> selectSkuInfoList(SkuInfo skuInfo);

}
