package com.gulimall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.product.domain.SkuSaleAttrValue;

import java.util.List;

/**
 * sku销售属性&值Mapper接口
 *
 * @author admin
 * @date 2022-02-14
 */
public interface SkuSaleAttrValueMapper extends BaseMapper<SkuSaleAttrValue> {

    /**
     * 查询sku销售属性&值列表
     *
     * @param skuSaleAttrValue sku销售属性&值
     * @return sku销售属性&值集合
     */
    List<SkuSaleAttrValue> selectSkuSaleAttrValueList(SkuSaleAttrValue skuSaleAttrValue);

}
