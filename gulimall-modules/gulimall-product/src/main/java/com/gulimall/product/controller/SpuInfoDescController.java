package com.gulimall.product.controller;

import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.web.page.TableDataInfo;
import com.gulimall.common.log.annotation.Log;
import com.gulimall.common.log.enums.BusinessType;
import com.gulimall.common.security.annotation.RequiresPermissions;
import com.gulimall.product.domain.SpuInfoDesc;
import com.gulimall.product.service.ISpuInfoDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * spu信息介绍Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/spuInfoDesc")
public class SpuInfoDescController extends BaseController {
    @Autowired
    private ISpuInfoDescService spuInfoDescService;

    /**
     * 查询spu信息介绍列表
     */
    @RequiresPermissions("product:spuInfoDesc:list")
    @GetMapping("/list")
    public TableDataInfo list(SpuInfoDesc spuInfoDesc) {
        startPage();
        List<SpuInfoDesc> list = spuInfoDescService.selectSpuInfoDescList(spuInfoDesc);
        return getDataTable(list);
    }

    /**
     * 导出spu信息介绍列表
     */
    @RequiresPermissions("product:spuInfoDesc:export")
    @Log(title = "spu信息介绍", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SpuInfoDesc spuInfoDesc) {
        List<SpuInfoDesc> list = spuInfoDescService.selectSpuInfoDescList(spuInfoDesc);
        ExcelUtil<SpuInfoDesc> util = new ExcelUtil<SpuInfoDesc>(SpuInfoDesc.class);
        util.exportExcel(response, list, "spu信息介绍数据");
    }

    /**
     * 获取spu信息介绍详细信息
     */
    @RequiresPermissions("product:spuInfoDesc:query")
    @GetMapping(value = "/{spuId}")
    public AjaxResult getInfo(@PathVariable("spuId") Long spuId) {
        return AjaxResult.success(spuInfoDescService.selectSpuInfoDescBySpuId(spuId));
    }

    /**
     * 新增spu信息介绍
     */
    @RequiresPermissions("product:spuInfoDesc:add")
    @Log(title = "spu信息介绍", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SpuInfoDesc spuInfoDesc) {
        return toAjax(spuInfoDescService.insertSpuInfoDesc(spuInfoDesc));
    }

    /**
     * 修改spu信息介绍
     */
    @RequiresPermissions("product:spuInfoDesc:edit")
    @Log(title = "spu信息介绍", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SpuInfoDesc spuInfoDesc) {
        return toAjax(spuInfoDescService.updateSpuInfoDesc(spuInfoDesc));
    }

    /**
     * 删除spu信息介绍
     */
    @RequiresPermissions("product:spuInfoDesc:remove")
    @Log(title = "spu信息介绍", businessType = BusinessType.DELETE)
    @DeleteMapping("/{spuIds}")
    public AjaxResult remove(@PathVariable Long[] spuIds) {
        return toAjax(spuInfoDescService.deleteSpuInfoDescBySpuIds(spuIds));
    }
}
