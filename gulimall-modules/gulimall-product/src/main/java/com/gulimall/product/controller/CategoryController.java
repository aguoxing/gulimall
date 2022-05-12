package com.gulimall.product.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gulimall.common.log.annotation.Log;
import com.gulimall.common.log.enums.BusinessType;
import com.gulimall.common.security.annotation.RequiresPermissions;
import com.gulimall.product.domain.Category;
import com.gulimall.product.service.ICategoryService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 商品三级分类Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController {
    @Autowired
    private ICategoryService categoryService;

    /**
     * 查询商品三级分类列表
     */
    @RequiresPermissions("product:category:list")
    @GetMapping("/list")
    public TableDataInfo list(Category category) {
        startPage();
        List<Category> list = categoryService.selectCategoryList(category);
        return getDataTable(list);
    }

    /**
     * 导出商品三级分类列表
     */
    @RequiresPermissions("product:category:export")
    @Log(title = "商品三级分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Category category) {
        List<Category> list = categoryService.selectCategoryList(category);
        ExcelUtil<Category> util = new ExcelUtil<Category>(Category.class);
        util.exportExcel(response, list, "商品三级分类数据");
    }

    /**
     * 获取商品三级分类详细信息
     */
    @RequiresPermissions("product:category:query")
    @GetMapping(value = "/{catId}")
    public AjaxResult getInfo(@PathVariable("catId") Long catId) {
        return AjaxResult.success(categoryService.selectCategoryByCatId(catId));
    }

    /**
     * 新增商品三级分类
     */
    @RequiresPermissions("product:category:add")
    @Log(title = "商品三级分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Category category) {
        return toAjax(categoryService.insertCategory(category));
    }

    /**
     * 修改商品三级分类
     */
    @RequiresPermissions("product:category:edit")
    @Log(title = "商品三级分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Category category) {
        return toAjax(categoryService.updateCategory(category));
    }

    /**
     * 删除商品三级分类
     */
    @RequiresPermissions("product:category:remove")
    @Log(title = "商品三级分类", businessType = BusinessType.DELETE)
    @DeleteMapping("/{catIds}")
    public AjaxResult remove(@PathVariable Long[] catIds) {
        return toAjax(categoryService.deleteCategoryByCatIds(catIds));
    }

    /**
     * 查询出所有分类以及子分类，以树形结构组装起来列表
     *
     * @return
     */
    @GetMapping("/list/tree")
    public AjaxResult listCategoryTree() {
        return AjaxResult.success(categoryService.listCategoryTree());
    }
}
