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
import com.gulimall.product.domain.SpuInfo;
import com.gulimall.product.service.ISpuInfoService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * spu信息Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/spuInfo")
public class SpuInfoController extends BaseController {
    @Autowired
    private ISpuInfoService spuInfoService;

    /**
     * 查询spu信息列表
     */
    @RequiresPermissions("product:spuInfo:list")
    @GetMapping("/list")
    public TableDataInfo list(SpuInfo spuInfo) {
        startPage();
        List<SpuInfo> list = spuInfoService.selectSpuInfoList(spuInfo);
        return getDataTable(list);
    }

    /**
     * 导出spu信息列表
     */
    @RequiresPermissions("product:spuInfo:export")
    @Log(title = "spu信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SpuInfo spuInfo) {
        List<SpuInfo> list = spuInfoService.selectSpuInfoList(spuInfo);
        ExcelUtil<SpuInfo> util = new ExcelUtil<SpuInfo>(SpuInfo.class);
        util.exportExcel(response, list, "spu信息数据");
    }

    /**
     * 获取spu信息详细信息
     */
    @RequiresPermissions("product:spuInfo:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(spuInfoService.selectSpuInfoById(id));
    }

    /**
     * 新增spu信息
     */
    @RequiresPermissions("product:spuInfo:add")
    @Log(title = "spu信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SpuInfo spuInfo) {
        return toAjax(spuInfoService.insertSpuInfo(spuInfo));
    }

    /**
     * 修改spu信息
     */
    @RequiresPermissions("product:spuInfo:edit")
    @Log(title = "spu信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SpuInfo spuInfo) {
        return toAjax(spuInfoService.updateSpuInfo(spuInfo));
    }

    /**
     * 删除spu信息
     */
    @RequiresPermissions("product:spuInfo:remove")
    @Log(title = "spu信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(spuInfoService.deleteSpuInfoByIds(ids));
    }
}
