package com.gulimall.product.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.product.domain.ProductAttrValue;

/**
 * spu属性值Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface ProductAttrValueMapper extends BaseMapper<ProductAttrValue> {

    /**
     * 查询spu属性值列表
     * 
     * @param productAttrValue spu属性值
     * @return spu属性值集合
     */
    List<ProductAttrValue> selectProductAttrValueList(ProductAttrValue productAttrValue);

}
