package com.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimall.product.domain.SkuImages;

import java.util.List;

/**
 * sku图片Service接口
 *
 * @author admin
 * @date 2022-02-14
 */
public interface ISkuImagesService extends IService<SkuImages> {
    /**
     * 查询sku图片
     *
     * @param id sku图片主键
     * @return sku图片
     */
    SkuImages selectSkuImagesById(Long id);

    /**
     * 查询sku图片列表
     *
     * @param skuImages sku图片
     * @return sku图片集合
     */
    List<SkuImages> selectSkuImagesList(SkuImages skuImages);

    /**
     * 新增sku图片
     *
     * @param skuImages sku图片
     * @return 结果
     */
    int insertSkuImages(SkuImages skuImages);

    /**
     * 修改sku图片
     *
     * @param skuImages sku图片
     * @return 结果
     */
    int updateSkuImages(SkuImages skuImages);

    /**
     * 批量删除sku图片
     *
     * @param ids 需要删除的sku图片主键集合
     * @return 结果
     */
    int deleteSkuImagesByIds(Long[] ids);

}
