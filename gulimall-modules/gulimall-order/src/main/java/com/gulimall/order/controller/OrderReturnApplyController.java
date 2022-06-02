package com.gulimall.order.controller;

import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.web.page.TableDataInfo;
import com.gulimall.common.log.annotation.Log;
import com.gulimall.common.log.enums.BusinessType;
import com.gulimall.common.security.annotation.RequiresPermissions;
import com.gulimall.order.domain.OrderReturnApply;
import com.gulimall.order.service.IOrderReturnApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 订单退货申请Controller
 *
 * @author admin
 * @date 2022-02-15
 */
@RestController
@RequestMapping("/orderReturnApply")
public class OrderReturnApplyController extends BaseController {
    @Autowired
    private IOrderReturnApplyService orderReturnApplyService;

    /**
     * 查询订单退货申请列表
     */
    @RequiresPermissions("order:orderReturnApply:list")
    @GetMapping("/list")
    public TableDataInfo list(OrderReturnApply orderReturnApply) {
        startPage();
        List<OrderReturnApply> list = orderReturnApplyService.selectOrderReturnApplyList(orderReturnApply);
        return getDataTable(list);
    }

    /**
     * 导出订单退货申请列表
     */
    @RequiresPermissions("order:orderReturnApply:export")
    @Log(title = "订单退货申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OrderReturnApply orderReturnApply) {
        List<OrderReturnApply> list = orderReturnApplyService.selectOrderReturnApplyList(orderReturnApply);
        ExcelUtil<OrderReturnApply> util = new ExcelUtil<OrderReturnApply>(OrderReturnApply.class);
        util.exportExcel(response, list, "订单退货申请数据");
    }

    /**
     * 获取订单退货申请详细信息
     */
    @RequiresPermissions("order:orderReturnApply:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(orderReturnApplyService.selectOrderReturnApplyById(id));
    }

    /**
     * 新增订单退货申请
     */
    @RequiresPermissions("order:orderReturnApply:add")
    @Log(title = "订单退货申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrderReturnApply orderReturnApply) {
        return toAjax(orderReturnApplyService.insertOrderReturnApply(orderReturnApply));
    }

    /**
     * 修改订单退货申请
     */
    @RequiresPermissions("order:orderReturnApply:edit")
    @Log(title = "订单退货申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrderReturnApply orderReturnApply) {
        return toAjax(orderReturnApplyService.updateOrderReturnApply(orderReturnApply));
    }

    /**
     * 删除订单退货申请
     */
    @RequiresPermissions("order:orderReturnApply:remove")
    @Log(title = "订单退货申请", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(orderReturnApplyService.deleteOrderReturnApplyByIds(ids));
    }
}
