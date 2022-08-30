package com.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimall.product.domain.Category;
import com.gulimall.product.domain.dto.CategoryDTO;
import com.gulimall.product.domain.vo.Catelog2Vo;

import java.util.List;
import java.util.Map;

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
     * 排序
     *
     * @param categoryDTO
     */
    void categoryChangeSort(CategoryDTO categoryDTO);

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

    /**
     * 查找一级分类
     *
     * @return
     */
    List<Category> getLevel1CategoryList();

    /**
     * 查询出所有分类以及子分类，以树形结构组装起来列表
     *
     * @return
     */
    List<Category> listCategoryTree();

    /**
     * getCatalogJson
     *
     * @return
     */
    Map<String, List<Catelog2Vo>> getCatalogJson();
}
