package com.gulimall.ware.controller;

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
import com.gulimall.ware.domain.WareInfo;
import com.gulimall.ware.service.IWareInfoService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 仓库信息Controller
 *
 * @author admin
 * @date 2022-02-15
 */
@RestController
@RequestMapping("/wareInfo")
public class WareInfoController extends BaseController {
    @Autowired
    private IWareInfoService wareInfoService;

    /**
     * 查询仓库信息列表
     */
    @RequiresPermissions("ware:wareInfo:list")
    @GetMapping("/list")
    public TableDataInfo list(WareInfo wareInfo) {
        startPage();
        List<WareInfo> list = wareInfoService.selectWareInfoList(wareInfo);
        return getDataTable(list);
    }

    /**
     * 导出仓库信息列表
     */
    @RequiresPermissions("ware:wareInfo:export")
    @Log(title = "仓库信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WareInfo wareInfo) {
        List<WareInfo> list = wareInfoService.selectWareInfoList(wareInfo);
        ExcelUtil<WareInfo> util = new ExcelUtil<WareInfo>(WareInfo.class);
        util.exportExcel(response, list, "仓库信息数据");
    }

    /**
     * 获取仓库信息详细信息
     */
    @RequiresPermissions("ware:wareInfo:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(wareInfoService.selectWareInfoById(id));
    }

    /**
     * 新增仓库信息
     */
    @RequiresPermissions("ware:wareInfo:add")
    @Log(title = "仓库信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WareInfo wareInfo) {
        return toAjax(wareInfoService.insertWareInfo(wareInfo));
    }

    /**
     * 修改仓库信息
     */
    @RequiresPermissions("ware:wareInfo:edit")
    @Log(title = "仓库信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WareInfo wareInfo) {
        return toAjax(wareInfoService.updateWareInfo(wareInfo));
    }

    /**
     * 删除仓库信息
     */
    @RequiresPermissions("ware:wareInfo:remove")
    @Log(title = "仓库信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(wareInfoService.deleteWareInfoByIds(ids));
    }
}
