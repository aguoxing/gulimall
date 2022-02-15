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
import com.gulimall.product.domain.SkuImages;
import com.gulimall.product.service.ISkuImagesService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * sku图片Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/skuImages")
public class SkuImagesController extends BaseController {
    @Autowired
    private ISkuImagesService skuImagesService;

    /**
     * 查询sku图片列表
     */
    @RequiresPermissions("product:skuImages:list")
    @GetMapping("/list")
    public TableDataInfo list(SkuImages skuImages) {
        startPage();
        List<SkuImages> list = skuImagesService.selectSkuImagesList(skuImages);
        return getDataTable(list);
    }

    /**
     * 导出sku图片列表
     */
    @RequiresPermissions("product:skuImages:export")
    @Log(title = "sku图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SkuImages skuImages) {
        List<SkuImages> list = skuImagesService.selectSkuImagesList(skuImages);
        ExcelUtil<SkuImages> util = new ExcelUtil<SkuImages>(SkuImages.class);
        util.exportExcel(response, list, "sku图片数据");
    }

    /**
     * 获取sku图片详细信息
     */
    @RequiresPermissions("product:skuImages:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(skuImagesService.selectSkuImagesById(id));
    }

    /**
     * 新增sku图片
     */
    @RequiresPermissions("product:skuImages:add")
    @Log(title = "sku图片", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SkuImages skuImages) {
        return toAjax(skuImagesService.insertSkuImages(skuImages));
    }

    /**
     * 修改sku图片
     */
    @RequiresPermissions("product:skuImages:edit")
    @Log(title = "sku图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SkuImages skuImages) {
        return toAjax(skuImagesService.updateSkuImages(skuImages));
    }

    /**
     * 删除sku图片
     */
    @RequiresPermissions("product:skuImages:remove")
    @Log(title = "sku图片", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(skuImagesService.deleteSkuImagesByIds(ids));
    }
}
