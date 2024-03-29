package com.gulimall.order.controller;

import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.web.page.TableDataInfo;
import com.gulimall.common.log.annotation.Log;
import com.gulimall.common.log.enums.BusinessType;
import com.gulimall.common.security.annotation.RequiresPermissions;
import com.gulimall.order.domain.OrderItem;
import com.gulimall.order.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 订单项信息Controller
 *
 * @author admin
 * @date 2022-02-15
 */
@RestController
@RequestMapping("/orderItem")
public class OrderItemController extends BaseController {
    @Autowired
    private IOrderItemService orderItemService;

    /**
     * 查询订单项信息列表
     */
    @RequiresPermissions("order:orderItem:list")
    @GetMapping("/list")
    public TableDataInfo list(OrderItem orderItem) {
        startPage();
        List<OrderItem> list = orderItemService.selectOrderItemList(orderItem);
        return getDataTable(list);
    }

    /**
     * 导出订单项信息列表
     */
    @RequiresPermissions("order:orderItem:export")
    @Log(title = "订单项信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OrderItem orderItem) {
        List<OrderItem> list = orderItemService.selectOrderItemList(orderItem);
        ExcelUtil<OrderItem> util = new ExcelUtil<OrderItem>(OrderItem.class);
        util.exportExcel(response, list, "订单项信息数据");
    }

    /**
     * 获取订单项信息详细信息
     */
    @RequiresPermissions("order:orderItem:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(orderItemService.selectOrderItemById(id));
    }

    /**
     * 新增订单项信息
     */
    @RequiresPermissions("order:orderItem:add")
    @Log(title = "订单项信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrderItem orderItem) {
        return toAjax(orderItemService.insertOrderItem(orderItem));
    }

    /**
     * 修改订单项信息
     */
    @RequiresPermissions("order:orderItem:edit")
    @Log(title = "订单项信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrderItem orderItem) {
        return toAjax(orderItemService.updateOrderItem(orderItem));
    }

    /**
     * 删除订单项信息
     */
    @RequiresPermissions("order:orderItem:remove")
    @Log(title = "订单项信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(orderItemService.deleteOrderItemByIds(ids));
    }
}
