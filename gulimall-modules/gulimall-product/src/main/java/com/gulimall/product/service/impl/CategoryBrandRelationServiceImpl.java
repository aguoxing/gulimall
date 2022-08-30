package com.gulimall.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimall.common.core.utils.StringUtils;
import com.gulimall.product.domain.Category;
import com.gulimall.product.domain.CategoryBrandRelation;
import com.gulimall.product.mapper.CategoryBrandRelationMapper;
import com.gulimall.product.mapper.CategoryMapper;
import com.gulimall.product.service.ICategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 品牌分类关联Service业务层处理
 *
 * @author admin
 * @date 2022-02-14
 */
@Service
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationMapper, CategoryBrandRelation> implements ICategoryBrandRelationService {
    @Autowired
    private CategoryBrandRelationMapper categoryBrandRelationMapper;
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询品牌分类关联
     *
     * @param id 品牌分类关联主键
     * @return 品牌分类关联
     */
    @Override
    public CategoryBrandRelation selectCategoryBrandRelationById(Long id) {
        return categoryBrandRelationMapper.selectById(id);
    }

    /**
     * 查询品牌分类关联列表
     *
     * @param categoryBrandRelation 品牌分类关联
     * @return 品牌分类关联
     */
    @Override
    public List<CategoryBrandRelation> selectCategoryBrandRelationList(CategoryBrandRelation categoryBrandRelation) {
        return categoryBrandRelationMapper.selectCategoryBrandRelationList(categoryBrandRelation);
    }

    /**
     * 新增品牌分类关联
     *
     * @param categoryBrandRelation 品牌分类关联
     * @return 结果
     */
    @Override
    public int insertCategoryBrandRelation(CategoryBrandRelation categoryBrandRelation) {
        Category category = categoryMapper.selectById(categoryBrandRelation.getCatalogId());
        if (StringUtils.isNotNull(category)) {
            categoryBrandRelation.setCatalogName(category.getName());
        }
        return categoryBrandRelationMapper.insert(categoryBrandRelation);
    }

    /**
     * 修改品牌分类关联
     *
     * @param categoryBrandRelation 品牌分类关联
     * @return 结果
     */
    @Override
    public int updateCategoryBrandRelation(CategoryBrandRelation categoryBrandRelation) {
        Category category = categoryMapper.selectById(categoryBrandRelation.getCatalogId());
        if (StringUtils.isNotNull(category)) {
            categoryBrandRelation.setCatalogName(category.getName());
        }
        return categoryBrandRelationMapper.updateById(categoryBrandRelation);
    }

    /**
     * 批量删除品牌分类关联
     *
     * @param ids 需要删除的品牌分类关联主键
     * @return 结果
     */
    @Override
    public int deleteCategoryBrandRelationByIds(Long[] ids) {
        return categoryBrandRelationMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
