package com.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimall.product.domain.SkuSaleAttrValue;

import java.util.List;

/**
 * sku销售属性&值Service接口
 *
 * @author admin
 * @date 2022-02-14
 */
public interface ISkuSaleAttrValueService extends IService<SkuSaleAttrValue> {
    /**
     * 查询sku销售属性&值
     *
     * @param id sku销售属性&值主键
     * @return sku销售属性&值
     */
    SkuSaleAttrValue selectSkuSaleAttrValueById(Long id);

    /**
     * 查询sku销售属性&值列表
     *
     * @param skuSaleAttrValue sku销售属性&值
     * @return sku销售属性&值集合
     */
    List<SkuSaleAttrValue> selectSkuSaleAttrValueList(SkuSaleAttrValue skuSaleAttrValue);

    /**
     * 新增sku销售属性&值
     *
     * @param skuSaleAttrValue sku销售属性&值
     * @return 结果
     */
    int insertSkuSaleAttrValue(SkuSaleAttrValue skuSaleAttrValue);

    /**
     * 修改sku销售属性&值
     *
     * @param skuSaleAttrValue sku销售属性&值
     * @return 结果
     */
    int updateSkuSaleAttrValue(SkuSaleAttrValue skuSaleAttrValue);

    /**
     * 批量删除sku销售属性&值
     *
     * @param ids 需要删除的sku销售属性&值主键集合
     * @return 结果
     */
    int deleteSkuSaleAttrValueByIds(Long[] ids);

}
