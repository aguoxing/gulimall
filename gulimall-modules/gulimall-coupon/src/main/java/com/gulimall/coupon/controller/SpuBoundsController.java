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
import com.gulimall.coupon.domain.SpuBounds;
import com.gulimall.coupon.service.ISpuBoundsService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 商品spu积分设置Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/spuBounds")
public class SpuBoundsController extends BaseController {
    @Autowired
    private ISpuBoundsService spuBoundsService;

    /**
     * 查询商品spu积分设置列表
     */
    @RequiresPermissions("coupon:spuBounds:list")
    @GetMapping("/list")
    public TableDataInfo list(SpuBounds spuBounds) {
        startPage();
        List<SpuBounds> list = spuBoundsService.selectSpuBoundsList(spuBounds);
        return getDataTable(list);
    }

    /**
     * 导出商品spu积分设置列表
     */
    @RequiresPermissions("coupon:spuBounds:export")
    @Log(title = "商品spu积分设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SpuBounds spuBounds) {
        List<SpuBounds> list = spuBoundsService.selectSpuBoundsList(spuBounds);
        ExcelUtil<SpuBounds> util = new ExcelUtil<SpuBounds>(SpuBounds.class);
        util.exportExcel(response, list, "商品spu积分设置数据");
    }

    /**
     * 获取商品spu积分设置详细信息
     */
    @RequiresPermissions("coupon:spuBounds:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(spuBoundsService.selectSpuBoundsById(id));
    }

    /**
     * 新增商品spu积分设置
     */
    @RequiresPermissions("coupon:spuBounds:add")
    @Log(title = "商品spu积分设置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SpuBounds spuBounds) {
        return toAjax(spuBoundsService.insertSpuBounds(spuBounds));
    }

    /**
     * 修改商品spu积分设置
     */
    @RequiresPermissions("coupon:spuBounds:edit")
    @Log(title = "商品spu积分设置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SpuBounds spuBounds) {
        return toAjax(spuBoundsService.updateSpuBounds(spuBounds));
    }

    /**
     * 删除商品spu积分设置
     */
    @RequiresPermissions("coupon:spuBounds:remove")
    @Log(title = "商品spu积分设置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(spuBoundsService.deleteSpuBoundsByIds(ids));
    }
}
