package com.gulimall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.product.domain.SkuImages;

import java.util.List;

/**
 * sku图片Mapper接口
 *
 * @author admin
 * @date 2022-02-14
 */
public interface SkuImagesMapper extends BaseMapper<SkuImages> {

    /**
     * 查询sku图片列表
     *
     * @param skuImages sku图片
     * @return sku图片集合
     */
    List<SkuImages> selectSkuImagesList(SkuImages skuImages);

}
