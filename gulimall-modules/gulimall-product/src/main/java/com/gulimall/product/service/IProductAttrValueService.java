package com.gulimall.product.service;

import java.util.List;
import com.gulimall.product.domain.ProductAttrValue;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * spu属性值Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface IProductAttrValueService extends IService<ProductAttrValue> {
    /**
     * 查询spu属性值
     *
     * @param id spu属性值主键
     * @return spu属性值
     */
    ProductAttrValue selectProductAttrValueById(Long id);

    /**
     * 查询spu属性值列表
     * 
     * @param productAttrValue spu属性值
     * @return spu属性值集合
     */
    List<ProductAttrValue> selectProductAttrValueList(ProductAttrValue productAttrValue);

    /**
     * 新增spu属性值
     * 
     * @param productAttrValue spu属性值
     * @return 结果
     */
    int insertProductAttrValue(ProductAttrValue productAttrValue);

    /**
     * 修改spu属性值
     * 
     * @param productAttrValue spu属性值
     * @return 结果
     */
    int updateProductAttrValue(ProductAttrValue productAttrValue);

    /**
     * 批量删除spu属性值
     * 
     * @param ids 需要删除的spu属性值主键集合
     * @return 结果
     */
    int deleteProductAttrValueByIds(Long[] ids);

}
