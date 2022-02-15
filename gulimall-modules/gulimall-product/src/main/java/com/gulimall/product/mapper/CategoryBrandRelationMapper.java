package com.gulimall.product.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.product.domain.CategoryBrandRelation;

/**
 * 品牌分类关联Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface CategoryBrandRelationMapper extends BaseMapper<CategoryBrandRelation> {

    /**
     * 查询品牌分类关联列表
     * 
     * @param categoryBrandRelation 品牌分类关联
     * @return 品牌分类关联集合
     */
    List<CategoryBrandRelation> selectCategoryBrandRelationList(CategoryBrandRelation categoryBrandRelation);

}
