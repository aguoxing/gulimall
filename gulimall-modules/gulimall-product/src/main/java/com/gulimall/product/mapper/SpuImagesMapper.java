package com.gulimall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.product.domain.SpuImages;

import java.util.List;

/**
 * spu图片Mapper接口
 *
 * @author admin
 * @date 2022-02-14
 */
public interface SpuImagesMapper extends BaseMapper<SpuImages> {

    /**
     * 查询spu图片列表
     *
     * @param spuImages spu图片
     * @return spu图片集合
     */
    List<SpuImages> selectSpuImagesList(SpuImages spuImages);

}
