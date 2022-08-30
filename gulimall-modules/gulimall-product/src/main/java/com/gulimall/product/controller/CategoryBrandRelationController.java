package com.gulimall.product.controller;

import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.web.page.TableDataInfo;
import com.gulimall.common.log.annotation.Log;
import com.gulimall.common.log.enums.BusinessType;
import com.gulimall.common.security.annotation.RequiresPermissions;
import com.gulimall.product.domain.CategoryBrandRelation;
import com.gulimall.product.service.ICategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 品牌分类关联Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/categoryBrandRelation")
public class CategoryBrandRelationController extends BaseController {
    @Autowired
    private ICategoryBrandRelationService categoryBrandRelationService;

    /**
     * 查询品牌分类关联列表
     */
    @RequiresPermissions("product:categoryBrandRelation:list")
    @GetMapping("/list")
    public TableDataInfo list(CategoryBrandRelation categoryBrandRelation) {
        startPage();
        List<CategoryBrandRelation> list = categoryBrandRelationService.selectCategoryBrandRelationList(categoryBrandRelation);
        return getDataTable(list);
    }

    /**
     * 导出品牌分类关联列表
     */
    @RequiresPermissions("product:categoryBrandRelation:export")
    @Log(title = "品牌分类关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CategoryBrandRelation categoryBrandRelation) {
        List<CategoryBrandRelation> list = categoryBrandRelationService.selectCategoryBrandRelationList(categoryBrandRelation);
        ExcelUtil<CategoryBrandRelation> util = new ExcelUtil<CategoryBrandRelation>(CategoryBrandRelation.class);
        util.exportExcel(response, list, "品牌分类关联数据");
    }

    /**
     * 获取品牌分类关联详细信息
     */
    @RequiresPermissions("product:categoryBrandRelation:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(categoryBrandRelationService.selectCategoryBrandRelationById(id));
    }

    /**
     * 新增品牌分类关联
     */
    @RequiresPermissions("product:categoryBrandRelation:add")
    @Log(title = "品牌分类关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CategoryBrandRelation categoryBrandRelation) {
        return toAjax(categoryBrandRelationService.insertCategoryBrandRelation(categoryBrandRelation));
    }

    /**
     * 修改品牌分类关联
     */
    @RequiresPermissions("product:categoryBrandRelation:edit")
    @Log(title = "品牌分类关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CategoryBrandRelation categoryBrandRelation) {
        return toAjax(categoryBrandRelationService.updateCategoryBrandRelation(categoryBrandRelation));
    }

    /**
     * 删除品牌分类关联
     */
    @RequiresPermissions("product:categoryBrandRelation:remove")
    @Log(title = "品牌分类关联", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(categoryBrandRelationService.deleteCategoryBrandRelationByIds(ids));
    }
}
