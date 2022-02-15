package com.gulimall.order.controller;

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
import com.gulimall.order.domain.OrderOperateHistory;
import com.gulimall.order.service.IOrderOperateHistoryService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 订单操作历史记录Controller
 *
 * @author admin
 * @date 2022-02-15
 */
@RestController
@RequestMapping("/orderOperateHistory")
public class OrderOperateHistoryController extends BaseController {
    @Autowired
    private IOrderOperateHistoryService orderOperateHistoryService;

    /**
     * 查询订单操作历史记录列表
     */
    @RequiresPermissions("order:orderOperateHistory:list")
    @GetMapping("/list")
    public TableDataInfo list(OrderOperateHistory orderOperateHistory) {
        startPage();
        List<OrderOperateHistory> list = orderOperateHistoryService.selectOrderOperateHistoryList(orderOperateHistory);
        return getDataTable(list);
    }

    /**
     * 导出订单操作历史记录列表
     */
    @RequiresPermissions("order:orderOperateHistory:export")
    @Log(title = "订单操作历史记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OrderOperateHistory orderOperateHistory) {
        List<OrderOperateHistory> list = orderOperateHistoryService.selectOrderOperateHistoryList(orderOperateHistory);
        ExcelUtil<OrderOperateHistory> util = new ExcelUtil<OrderOperateHistory>(OrderOperateHistory.class);
        util.exportExcel(response, list, "订单操作历史记录数据");
    }

    /**
     * 获取订单操作历史记录详细信息
     */
    @RequiresPermissions("order:orderOperateHistory:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(orderOperateHistoryService.selectOrderOperateHistoryById(id));
    }

    /**
     * 新增订单操作历史记录
     */
    @RequiresPermissions("order:orderOperateHistory:add")
    @Log(title = "订单操作历史记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrderOperateHistory orderOperateHistory) {
        return toAjax(orderOperateHistoryService.insertOrderOperateHistory(orderOperateHistory));
    }

    /**
     * 修改订单操作历史记录
     */
    @RequiresPermissions("order:orderOperateHistory:edit")
    @Log(title = "订单操作历史记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrderOperateHistory orderOperateHistory) {
        return toAjax(orderOperateHistoryService.updateOrderOperateHistory(orderOperateHistory));
    }

    /**
     * 删除订单操作历史记录
     */
    @RequiresPermissions("order:orderOperateHistory:remove")
    @Log(title = "订单操作历史记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(orderOperateHistoryService.deleteOrderOperateHistoryByIds(ids));
    }
}
