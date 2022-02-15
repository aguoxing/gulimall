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
import com.gulimall.ware.domain.WareOrderTaskDetail;
import com.gulimall.ware.service.IWareOrderTaskDetailService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 库存工作单详情Controller
 *
 * @author admin
 * @date 2022-02-15
 */
@RestController
@RequestMapping("/wareOrderTaskDetail")
public class WareOrderTaskDetailController extends BaseController {
    @Autowired
    private IWareOrderTaskDetailService wareOrderTaskDetailService;

    /**
     * 查询库存工作单详情列表
     */
    @RequiresPermissions("ware:wareOrderTaskDetail:list")
    @GetMapping("/list")
    public TableDataInfo list(WareOrderTaskDetail wareOrderTaskDetail) {
        startPage();
        List<WareOrderTaskDetail> list = wareOrderTaskDetailService.selectWareOrderTaskDetailList(wareOrderTaskDetail);
        return getDataTable(list);
    }

    /**
     * 导出库存工作单详情列表
     */
    @RequiresPermissions("ware:wareOrderTaskDetail:export")
    @Log(title = "库存工作单详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WareOrderTaskDetail wareOrderTaskDetail) {
        List<WareOrderTaskDetail> list = wareOrderTaskDetailService.selectWareOrderTaskDetailList(wareOrderTaskDetail);
        ExcelUtil<WareOrderTaskDetail> util = new ExcelUtil<WareOrderTaskDetail>(WareOrderTaskDetail.class);
        util.exportExcel(response, list, "库存工作单详情数据");
    }

    /**
     * 获取库存工作单详情详细信息
     */
    @RequiresPermissions("ware:wareOrderTaskDetail:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(wareOrderTaskDetailService.selectWareOrderTaskDetailById(id));
    }

    /**
     * 新增库存工作单详情
     */
    @RequiresPermissions("ware:wareOrderTaskDetail:add")
    @Log(title = "库存工作单详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WareOrderTaskDetail wareOrderTaskDetail) {
        return toAjax(wareOrderTaskDetailService.insertWareOrderTaskDetail(wareOrderTaskDetail));
    }

    /**
     * 修改库存工作单详情
     */
    @RequiresPermissions("ware:wareOrderTaskDetail:edit")
    @Log(title = "库存工作单详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WareOrderTaskDetail wareOrderTaskDetail) {
        return toAjax(wareOrderTaskDetailService.updateWareOrderTaskDetail(wareOrderTaskDetail));
    }

    /**
     * 删除库存工作单详情
     */
    @RequiresPermissions("ware:wareOrderTaskDetail:remove")
    @Log(title = "库存工作单详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(wareOrderTaskDetailService.deleteWareOrderTaskDetailByIds(ids));
    }
}
