package com.gulimall.product.service.impl;

import java.util.Arrays;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.product.mapper.CategoryMapper;
import com.gulimall.product.domain.Category;
import com.gulimall.product.service.ICategoryService;

/**
 * 商品三级分类Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询商品三级分类
     * 
     * @param catId 商品三级分类主键
     * @return 商品三级分类
     */
    @Override
    public Category selectCategoryByCatId(Long catId) {
        return categoryMapper.selectById(catId);
    }

    /**
     * 查询商品三级分类列表
     * 
     * @param category 商品三级分类
     * @return 商品三级分类
     */
    @Override
    public List<Category> selectCategoryList(Category category) {
        return categoryMapper.selectCategoryList(category);
    }

    /**
     * 新增商品三级分类
     * 
     * @param category 商品三级分类
     * @return 结果
     */
    @Override
    public int insertCategory(Category category) {
        return categoryMapper.insert(category);
    }

    /**
     * 修改商品三级分类
     * 
     * @param category 商品三级分类
     * @return 结果
     */
    @Override
    public int updateCategory(Category category) {
        return categoryMapper.updateById(category);
    }

    /**
     * 批量删除商品三级分类
     * 
     * @param catIds 需要删除的商品三级分类主键
     * @return 结果
     */
    @Override
    public int deleteCategoryByCatIds(Long[] catIds) {
        return categoryMapper.deleteBatchIds(Arrays.asList(catIds));
    }

}
