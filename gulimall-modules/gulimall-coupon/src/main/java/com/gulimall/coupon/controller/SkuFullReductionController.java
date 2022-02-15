package com.gulimall.coupon.controller;

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
import com.gulimall.coupon.domain.SkuFullReduction;
import com.gulimall.coupon.service.ISkuFullReductionService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 商品满减信息Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/skuFullReduction")
public class SkuFullReductionController extends BaseController {
    @Autowired
    private ISkuFullReductionService skuFullReductionService;

    /**
     * 查询商品满减信息列表
     */
    @RequiresPermissions("coupon:skuFullReduction:list")
    @GetMapping("/list")
    public TableDataInfo list(SkuFullReduction skuFullReduction) {
        startPage();
        List<SkuFullReduction> list = skuFullReductionService.selectSkuFullReductionList(skuFullReduction);
        return getDataTable(list);
    }

    /**
     * 导出商品满减信息列表
     */
    @RequiresPermissions("coupon:skuFullReduction:export")
    @Log(title = "商品满减信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SkuFullReduction skuFullReduction) {
        List<SkuFullReduction> list = skuFullReductionService.selectSkuFullReductionList(skuFullReduction);
        ExcelUtil<SkuFullReduction> util = new ExcelUtil<SkuFullReduction>(SkuFullReduction.class);
        util.exportExcel(response, list, "商品满减信息数据");
    }

    /**
     * 获取商品满减信息详细信息
     */
    @RequiresPermissions("coupon:skuFullReduction:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(skuFullReductionService.selectSkuFullReductionById(id));
    }

    /**
     * 新增商品满减信息
     */
    @RequiresPermissions("coupon:skuFullReduction:add")
    @Log(title = "商品满减信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SkuFullReduction skuFullReduction) {
        return toAjax(skuFullReductionService.insertSkuFullReduction(skuFullReduction));
    }

    /**
     * 修改商品满减信息
     */
    @RequiresPermissions("coupon:skuFullReduction:edit")
    @Log(title = "商品满减信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SkuFullReduction skuFullReduction) {
        return toAjax(skuFullReductionService.updateSkuFullReduction(skuFullReduction));
    }

    /**
     * 删除商品满减信息
     */
    @RequiresPermissions("coupon:skuFullReduction:remove")
    @Log(title = "商品满减信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(skuFullReductionService.deleteSkuFullReductionByIds(ids));
    }
}
