package com.gulimall.product.controller;

import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.web.page.TableDataInfo;
import com.gulimall.common.log.annotation.Log;
import com.gulimall.common.log.enums.BusinessType;
import com.gulimall.common.security.annotation.RequiresPermissions;
import com.gulimall.product.domain.Brand;
import com.gulimall.product.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 品牌Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/brand")
public class BrandController extends BaseController {
    @Autowired
    private IBrandService brandService;

    /**
     * 查询品牌列表
     */
    @RequiresPermissions("product:brand:list")
    @GetMapping("/list")
    public TableDataInfo list(Brand brand) {
        startPage();
        List<Brand> list = brandService.selectBrandList(brand);
        return getDataTable(list);
    }

    /**
     * 导出品牌列表
     */
    @RequiresPermissions("product:brand:export")
    @Log(title = "品牌", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Brand brand) {
        List<Brand> list = brandService.selectBrandList(brand);
        ExcelUtil<Brand> util = new ExcelUtil<Brand>(Brand.class);
        util.exportExcel(response, list, "品牌数据");
    }

    /**
     * 获取品牌详细信息
     */
    @RequiresPermissions("product:brand:query")
    @GetMapping(value = "/{brandId}")
    public AjaxResult getInfo(@PathVariable("brandId") Long brandId) {
        return AjaxResult.success(brandService.selectBrandByBrandId(brandId));
    }

    /**
     * 新增品牌
     */
    @RequiresPermissions("product:brand:add")
    @Log(title = "品牌", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Brand brand) {
        return toAjax(brandService.insertBrand(brand));
    }

    /**
     * 修改品牌
     */
    @RequiresPermissions("product:brand:edit")
    @Log(title = "品牌", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Brand brand) {
        return toAjax(brandService.updateBrand(brand));
    }

    /**
     * 删除品牌
     */
    @RequiresPermissions("product:brand:remove")
    @Log(title = "品牌", businessType = BusinessType.DELETE)
    @DeleteMapping("/{brandIds}")
    public AjaxResult remove(@PathVariable Long[] brandIds) {
        return toAjax(brandService.deleteBrandByBrandIds(brandIds));
    }
}
