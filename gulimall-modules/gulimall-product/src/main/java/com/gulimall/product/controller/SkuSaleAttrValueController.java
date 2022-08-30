package com.gulimall.product.controller;

import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.web.page.TableDataInfo;
import com.gulimall.common.log.annotation.Log;
import com.gulimall.common.log.enums.BusinessType;
import com.gulimall.common.security.annotation.RequiresPermissions;
import com.gulimall.product.domain.SkuSaleAttrValue;
import com.gulimall.product.service.ISkuSaleAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * sku销售属性&值Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/skuSaleAttrValue")
public class SkuSaleAttrValueController extends BaseController {
    @Autowired
    private ISkuSaleAttrValueService skuSaleAttrValueService;

    /**
     * 查询sku销售属性&值列表
     */
    @RequiresPermissions("product:skuSaleAttrValue:list")
    @GetMapping("/list")
    public TableDataInfo list(SkuSaleAttrValue skuSaleAttrValue) {
        startPage();
        List<SkuSaleAttrValue> list = skuSaleAttrValueService.selectSkuSaleAttrValueList(skuSaleAttrValue);
        return getDataTable(list);
    }

    /**
     * 导出sku销售属性&值列表
     */
    @RequiresPermissions("product:skuSaleAttrValue:export")
    @Log(title = "sku销售属性&值", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SkuSaleAttrValue skuSaleAttrValue) {
        List<SkuSaleAttrValue> list = skuSaleAttrValueService.selectSkuSaleAttrValueList(skuSaleAttrValue);
        ExcelUtil<SkuSaleAttrValue> util = new ExcelUtil<SkuSaleAttrValue>(SkuSaleAttrValue.class);
        util.exportExcel(response, list, "sku销售属性&值数据");
    }

    /**
     * 获取sku销售属性&值详细信息
     */
    @RequiresPermissions("product:skuSaleAttrValue:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(skuSaleAttrValueService.selectSkuSaleAttrValueById(id));
    }

    /**
     * 新增sku销售属性&值
     */
    @RequiresPermissions("product:skuSaleAttrValue:add")
    @Log(title = "sku销售属性&值", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SkuSaleAttrValue skuSaleAttrValue) {
        return toAjax(skuSaleAttrValueService.insertSkuSaleAttrValue(skuSaleAttrValue));
    }

    /**
     * 修改sku销售属性&值
     */
    @RequiresPermissions("product:skuSaleAttrValue:edit")
    @Log(title = "sku销售属性&值", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SkuSaleAttrValue skuSaleAttrValue) {
        return toAjax(skuSaleAttrValueService.updateSkuSaleAttrValue(skuSaleAttrValue));
    }

    /**
     * 删除sku销售属性&值
     */
    @RequiresPermissions("product:skuSaleAttrValue:remove")
    @Log(title = "sku销售属性&值", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(skuSaleAttrValueService.deleteSkuSaleAttrValueByIds(ids));
    }
}
