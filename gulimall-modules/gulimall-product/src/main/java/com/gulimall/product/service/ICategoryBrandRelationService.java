package com.gulimall.product.service;

import java.util.List;
import com.gulimall.product.domain.CategoryBrandRelation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 品牌分类关联Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface ICategoryBrandRelationService extends IService<CategoryBrandRelation> {
    /**
     * 查询品牌分类关联
     *
     * @param id 品牌分类关联主键
     * @return 品牌分类关联
     */
    CategoryBrandRelation selectCategoryBrandRelationById(Long id);

    /**
     * 查询品牌分类关联列表
     * 
     * @param categoryBrandRelation 品牌分类关联
     * @return 品牌分类关联集合
     */
    List<CategoryBrandRelation> selectCategoryBrandRelationList(CategoryBrandRelation categoryBrandRelation);

    /**
     * 新增品牌分类关联
     * 
     * @param categoryBrandRelation 品牌分类关联
     * @return 结果
     */
    int insertCategoryBrandRelation(CategoryBrandRelation categoryBrandRelation);

    /**
     * 修改品牌分类关联
     * 
     * @param categoryBrandRelation 品牌分类关联
     * @return 结果
     */
    int updateCategoryBrandRelation(CategoryBrandRelation categoryBrandRelation);

    /**
     * 批量删除品牌分类关联
     * 
     * @param ids 需要删除的品牌分类关联主键集合
     * @return 结果
     */
    int deleteCategoryBrandRelationByIds(Long[] ids);

}
