package com.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimall.common.core.utils.StringUtils;
import com.gulimall.common.redis.service.RedisService;
import com.gulimall.product.domain.Category;
import com.gulimall.product.domain.dto.CategoryDTO;
import com.gulimall.product.domain.vo.Catelog2Vo;
import com.gulimall.product.mapper.CategoryMapper;
import com.gulimall.product.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 商品三级分类Service业务层处理
 *
 * @author admin
 * @date 2022-02-14
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
    @Autowired
    private RedisService redisService;

    /**
     * 查询商品三级分类
     *
     * @param catId 商品三级分类主键
     * @return 商品三级分类
     */
    @Override
    public Category selectCategoryByCatId(Long catId) {
        return this.baseMapper.selectById(catId);
    }

    /**
     * 查询商品三级分类列表
     *
     * @param category 商品三级分类
     * @return 商品三级分类
     */
    @Override
    public List<Category> selectCategoryList(Category category) {
        return this.baseMapper.selectCategoryList(category);
    }

    /**
     * 新增商品三级分类
     *
     * @param category 商品三级分类
     * @return 结果
     */
    @Override
    public int insertCategory(Category category) {
        return this.baseMapper.insert(category);
    }

    /**
     * 修改商品三级分类
     *
     * @param category 商品三级分类
     * @return 结果
     */
    @Override
    public int updateCategory(Category category) {
        return this.baseMapper.updateById(category);
    }

    /**
     * 批量删除商品三级分类
     *
     * @param catIds 需要删除的商品三级分类主键
     * @return 结果
     */
    @Override
    public int deleteCategoryByCatIds(Long[] catIds) {
        return this.baseMapper.deleteBatchIds(Arrays.asList(catIds));
    }

    /**
     * 查询出所有分类以及子分类，以树形结构组装起来列表
     *
     * @return
     */
    @Override
    public List<Category> listCategoryTree() {
        List<Category> categoryList = baseMapper.selectList(new LambdaQueryWrapper<Category>().orderByAsc(Category::getSort));
        Map<Long, Category> map = categoryList.stream().collect(Collectors.toMap(Category::getCatId, Function.identity()));
        List<Category> resList = new ArrayList<>();
        List<Category> childList;
        for (Category category : categoryList) {
            Category parent = map.get(category.getParentCid());
            if (StringUtils.isNotNull(parent)) {
                if (StringUtils.isNull(parent.getChildren())) {
                    childList = parent.getChildren();
                    if (StringUtils.isNull(childList)) {
                        childList = new ArrayList<>();
                    }
                    childList.add(category);
                    parent.setChildren(childList);
                } else {
                    parent.getChildren().add(category);
                }
            }
            if (StringUtils.isNull(parent) || StringUtils.isNull(category.getParentCid())) {
                resList.add(category);
            }
        }
        return resList;
    }

    /**
     * 查出所有的一级分类
     * 适合：读多写少，即时性，一致性要求不高的数据；写模式：设置过期时间
     *
     * @return
     */
    @Override
    public List<Category> getLevel1CategoryList() {
        String key = "product:category:getLevel1CategoryList";
        List<Category> categoryListCache = redisService.getCacheObject(key);
        if (StringUtils.isNull(categoryListCache)) {
            categoryListCache = this.baseMapper.selectList(new LambdaQueryWrapper<Category>().eq(Category::getParentCid, "0"));
            redisService.setCacheObject(key, categoryListCache, 60L, TimeUnit.MINUTES);
        }
        return categoryListCache;
    }

    @Override
    public Map<String, List<Catelog2Vo>> getCatalogJson() {
        return null;
    }

    /**
     * 排序
     *
     * @param categoryDTO
     */
    @Override
    public void categoryChangeSort(CategoryDTO categoryDTO) {
        List<Category> categoryList = categoryDTO.getSorted();
        for (Category category : categoryList) {
            baseMapper.updateById(category);
        }
    }

}
