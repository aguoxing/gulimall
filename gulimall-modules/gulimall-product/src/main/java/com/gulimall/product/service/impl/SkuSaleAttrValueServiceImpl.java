package com.gulimall.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimall.product.domain.SkuSaleAttrValue;
import com.gulimall.product.mapper.SkuSaleAttrValueMapper;
import com.gulimall.product.service.ISkuSaleAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * sku销售属性&值Service业务层处理
 *
 * @author admin
 * @date 2022-02-14
 */
@Service
public class SkuSaleAttrValueServiceImpl extends ServiceImpl<SkuSaleAttrValueMapper, SkuSaleAttrValue> implements ISkuSaleAttrValueService {
    @Autowired
    private SkuSaleAttrValueMapper skuSaleAttrValueMapper;

    /**
     * 查询sku销售属性&值
     *
     * @param id sku销售属性&值主键
     * @return sku销售属性&值
     */
    @Override
    public SkuSaleAttrValue selectSkuSaleAttrValueById(Long id) {
        return skuSaleAttrValueMapper.selectById(id);
    }

    /**
     * 查询sku销售属性&值列表
     *
     * @param skuSaleAttrValue sku销售属性&值
     * @return sku销售属性&值
     */
    @Override
    public List<SkuSaleAttrValue> selectSkuSaleAttrValueList(SkuSaleAttrValue skuSaleAttrValue) {
        return skuSaleAttrValueMapper.selectSkuSaleAttrValueList(skuSaleAttrValue);
    }

    /**
     * 新增sku销售属性&值
     *
     * @param skuSaleAttrValue sku销售属性&值
     * @return 结果
     */
    @Override
    public int insertSkuSaleAttrValue(SkuSaleAttrValue skuSaleAttrValue) {
        return skuSaleAttrValueMapper.insert(skuSaleAttrValue);
    }

    /**
     * 修改sku销售属性&值
     *
     * @param skuSaleAttrValue sku销售属性&值
     * @return 结果
     */
    @Override
    public int updateSkuSaleAttrValue(SkuSaleAttrValue skuSaleAttrValue) {
        return skuSaleAttrValueMapper.updateById(skuSaleAttrValue);
    }

    /**
     * 批量删除sku销售属性&值
     *
     * @param ids 需要删除的sku销售属性&值主键
     * @return 结果
     */
    @Override
    public int deleteSkuSaleAttrValueByIds(Long[] ids) {
        return skuSaleAttrValueMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
