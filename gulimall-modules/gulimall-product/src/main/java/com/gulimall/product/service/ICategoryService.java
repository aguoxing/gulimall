package com.gulimall.product.service;

import java.util.List;
import com.gulimall.product.domain.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 商品三级分类Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface ICategoryService extends IService<Category> {
    /**
     * 查询商品三级分类
     *
     * @param catId 商品三级分类主键
     * @return 商品三级分类
     */
    Category selectCategoryByCatId(Long catId);

    /**
     * 查询商品三级分类列表
     * 
     * @param category 商品三级分类
     * @return 商品三级分类集合
     */
    List<Category> selectCategoryList(Category category);

    /**
     * 新增商品三级分类
     * 
     * @param category 商品三级分类
     * @return 结果
     */
    int insertCategory(Category category);

    /**
     * 修改商品三级分类
     * 
     * @param category 商品三级分类
     * @return 结果
     */
    int updateCategory(Category category);

    /**
     * 批量删除商品三级分类
     * 
     * @param catIds 需要删除的商品三级分类主键集合
     * @return 结果
     */
    int deleteCategoryByCatIds(Long[] catIds);

}
