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
import com.gulimall.product.domain.ProductAttrValue;
import com.gulimall.product.service.IProductAttrValueService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * spu属性值Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/productAttrValue")
public class ProductAttrValueController extends BaseController {
    @Autowired
    private IProductAttrValueService productAttrValueService;

    /**
     * 查询spu属性值列表
     */
    @RequiresPermissions("product:productAttrValue:list")
    @GetMapping("/list")
    public TableDataInfo list(ProductAttrValue productAttrValue) {
        startPage();
        List<ProductAttrValue> list = productAttrValueService.selectProductAttrValueList(productAttrValue);
        return getDataTable(list);
    }

    /**
     * 导出spu属性值列表
     */
    @RequiresPermissions("product:productAttrValue:export")
    @Log(title = "spu属性值", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductAttrValue productAttrValue) {
        List<ProductAttrValue> list = productAttrValueService.selectProductAttrValueList(productAttrValue);
        ExcelUtil<ProductAttrValue> util = new ExcelUtil<ProductAttrValue>(ProductAttrValue.class);
        util.exportExcel(response, list, "spu属性值数据");
    }

    /**
     * 获取spu属性值详细信息
     */
    @RequiresPermissions("product:productAttrValue:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(productAttrValueService.selectProductAttrValueById(id));
    }

    /**
     * 新增spu属性值
     */
    @RequiresPermissions("product:productAttrValue:add")
    @Log(title = "spu属性值", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductAttrValue productAttrValue) {
        return toAjax(productAttrValueService.insertProductAttrValue(productAttrValue));
    }

    /**
     * 修改spu属性值
     */
    @RequiresPermissions("product:productAttrValue:edit")
    @Log(title = "spu属性值", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductAttrValue productAttrValue) {
        return toAjax(productAttrValueService.updateProductAttrValue(productAttrValue));
    }

    /**
     * 删除spu属性值
     */
    @RequiresPermissions("product:productAttrValue:remove")
    @Log(title = "spu属性值", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(productAttrValueService.deleteProductAttrValueByIds(ids));
    }
}
