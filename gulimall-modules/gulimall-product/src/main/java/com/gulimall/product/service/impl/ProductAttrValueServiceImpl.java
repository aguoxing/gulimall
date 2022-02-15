package com.gulimall.product.service.impl;

import java.util.Arrays;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.product.mapper.ProductAttrValueMapper;
import com.gulimall.product.domain.ProductAttrValue;
import com.gulimall.product.service.IProductAttrValueService;

/**
 * spu属性值Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class ProductAttrValueServiceImpl extends ServiceImpl<ProductAttrValueMapper, ProductAttrValue> implements IProductAttrValueService {
    @Autowired
    private ProductAttrValueMapper productAttrValueMapper;

    /**
     * 查询spu属性值
     * 
     * @param id spu属性值主键
     * @return spu属性值
     */
    @Override
    public ProductAttrValue selectProductAttrValueById(Long id) {
        return productAttrValueMapper.selectById(id);
    }

    /**
     * 查询spu属性值列表
     * 
     * @param productAttrValue spu属性值
     * @return spu属性值
     */
    @Override
    public List<ProductAttrValue> selectProductAttrValueList(ProductAttrValue productAttrValue) {
        return productAttrValueMapper.selectProductAttrValueList(productAttrValue);
    }

    /**
     * 新增spu属性值
     * 
     * @param productAttrValue spu属性值
     * @return 结果
     */
    @Override
    public int insertProductAttrValue(ProductAttrValue productAttrValue) {
        return productAttrValueMapper.insert(productAttrValue);
    }

    /**
     * 修改spu属性值
     * 
     * @param productAttrValue spu属性值
     * @return 结果
     */
    @Override
    public int updateProductAttrValue(ProductAttrValue productAttrValue) {
        return productAttrValueMapper.updateById(productAttrValue);
    }

    /**
     * 批量删除spu属性值
     * 
     * @param ids 需要删除的spu属性值主键
     * @return 结果
     */
    @Override
    public int deleteProductAttrValueByIds(Long[] ids) {
        return productAttrValueMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
