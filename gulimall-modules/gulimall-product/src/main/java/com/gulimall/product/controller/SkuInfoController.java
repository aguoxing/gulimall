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
import com.gulimall.product.domain.SkuInfo;
import com.gulimall.product.service.ISkuInfoService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * sku信息Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/skuInfo")
public class SkuInfoController extends BaseController {
    @Autowired
    private ISkuInfoService skuInfoService;

    /**
     * 查询sku信息列表
     */
    @RequiresPermissions("product:skuInfo:list")
    @GetMapping("/list")
    public TableDataInfo list(SkuInfo skuInfo) {
        startPage();
        List<SkuInfo> list = skuInfoService.selectSkuInfoList(skuInfo);
        return getDataTable(list);
    }

    /**
     * 导出sku信息列表
     */
    @RequiresPermissions("product:skuInfo:export")
    @Log(title = "sku信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SkuInfo skuInfo) {
        List<SkuInfo> list = skuInfoService.selectSkuInfoList(skuInfo);
        ExcelUtil<SkuInfo> util = new ExcelUtil<SkuInfo>(SkuInfo.class);
        util.exportExcel(response, list, "sku信息数据");
    }

    /**
     * 获取sku信息详细信息
     */
    @RequiresPermissions("product:skuInfo:query")
    @GetMapping(value = "/{skuId}")
    public AjaxResult getInfo(@PathVariable("skuId") Long skuId) {
        return AjaxResult.success(skuInfoService.selectSkuInfoBySkuId(skuId));
    }

    /**
     * 新增sku信息
     */
    @RequiresPermissions("product:skuInfo:add")
    @Log(title = "sku信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SkuInfo skuInfo) {
        return toAjax(skuInfoService.insertSkuInfo(skuInfo));
    }

    /**
     * 修改sku信息
     */
    @RequiresPermissions("product:skuInfo:edit")
    @Log(title = "sku信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SkuInfo skuInfo) {
        return toAjax(skuInfoService.updateSkuInfo(skuInfo));
    }

    /**
     * 删除sku信息
     */
    @RequiresPermissions("product:skuInfo:remove")
    @Log(title = "sku信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{skuIds}")
    public AjaxResult remove(@PathVariable Long[] skuIds) {
        return toAjax(skuInfoService.deleteSkuInfoBySkuIds(skuIds));
    }
}
