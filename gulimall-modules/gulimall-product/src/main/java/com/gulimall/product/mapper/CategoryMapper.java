package com.gulimall.product.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.product.domain.Category;

/**
 * 商品三级分类Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 查询商品三级分类列表
     * 
     * @param category 商品三级分类
     * @return 商品三级分类集合
     */
    List<Category> selectCategoryList(Category category);

}
