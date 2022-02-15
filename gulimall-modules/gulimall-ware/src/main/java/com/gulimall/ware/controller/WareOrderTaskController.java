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
import com.gulimall.ware.domain.WareOrderTask;
import com.gulimall.ware.service.IWareOrderTaskService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 库存工作单Controller
 *
 * @author admin
 * @date 2022-02-15
 */
@RestController
@RequestMapping("/wareOrderTask")
public class WareOrderTaskController extends BaseController {
    @Autowired
    private IWareOrderTaskService wareOrderTaskService;

    /**
     * 查询库存工作单列表
     */
    @RequiresPermissions("ware:wareOrderTask:list")
    @GetMapping("/list")
    public TableDataInfo list(WareOrderTask wareOrderTask) {
        startPage();
        List<WareOrderTask> list = wareOrderTaskService.selectWareOrderTaskList(wareOrderTask);
        return getDataTable(list);
    }

    /**
     * 导出库存工作单列表
     */
    @RequiresPermissions("ware:wareOrderTask:export")
    @Log(title = "库存工作单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WareOrderTask wareOrderTask) {
        List<WareOrderTask> list = wareOrderTaskService.selectWareOrderTaskList(wareOrderTask);
        ExcelUtil<WareOrderTask> util = new ExcelUtil<WareOrderTask>(WareOrderTask.class);
        util.exportExcel(response, list, "库存工作单数据");
    }

    /**
     * 获取库存工作单详细信息
     */
    @RequiresPermissions("ware:wareOrderTask:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(wareOrderTaskService.selectWareOrderTaskById(id));
    }

    /**
     * 新增库存工作单
     */
    @RequiresPermissions("ware:wareOrderTask:add")
    @Log(title = "库存工作单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WareOrderTask wareOrderTask) {
        return toAjax(wareOrderTaskService.insertWareOrderTask(wareOrderTask));
    }

    /**
     * 修改库存工作单
     */
    @RequiresPermissions("ware:wareOrderTask:edit")
    @Log(title = "库存工作单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WareOrderTask wareOrderTask) {
        return toAjax(wareOrderTaskService.updateWareOrderTask(wareOrderTask));
    }

    /**
     * 删除库存工作单
     */
    @RequiresPermissions("ware:wareOrderTask:remove")
    @Log(title = "库存工作单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(wareOrderTaskService.deleteWareOrderTaskByIds(ids));
    }
}
