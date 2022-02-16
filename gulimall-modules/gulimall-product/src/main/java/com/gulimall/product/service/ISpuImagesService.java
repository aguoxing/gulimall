package com.gulimall.product.service;

import java.util.List;
import com.gulimall.product.domain.SpuImages;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * spu图片Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface ISpuImagesService extends IService<SpuImages> {
    /**
     * 查询spu图片
     *
     * @param id spu图片主键
     * @return spu图片
     */
    SpuImages selectSpuImagesById(Long id);

    /**
     * 查询spu图片列表
     * 
     * @param spuImages spu图片
     * @return spu图片集合
     */
    List<SpuImages> selectSpuImagesList(SpuImages spuImages);

    /**
     * 新增spu图片
     * 
     * @param spuImages spu图片
     * @return 结果
     */
    int insertSpuImages(SpuImages spuImages);

    /**
     * 修改spu图片
     * 
     * @param spuImages spu图片
     * @return 结果
     */
    int updateSpuImages(SpuImages spuImages);

    /**
     * 批量删除spu图片
     * 
     * @param ids 需要删除的spu图片主键集合
     * @return 结果
     */
    int deleteSpuImagesByIds(Long[] ids);

}