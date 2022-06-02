package com.gulimall.order.controller;

import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.web.page.TableDataInfo;
import com.gulimall.common.log.annotation.Log;
import com.gulimall.common.log.enums.BusinessType;
import com.gulimall.common.security.annotation.RequiresPermissions;
import com.gulimall.order.domain.OrderSetting;
import com.gulimall.order.service.IOrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 订单配置信息Controller
 *
 * @author admin
 * @date 2022-02-15
 */
@RestController
@RequestMapping("/orderSetting")
public class OrderSettingController extends BaseController {
    @Autowired
    private IOrderSettingService orderSettingService;

    /**
     * 查询订单配置信息列表
     */
    @RequiresPermissions("order:orderSetting:list")
    @GetMapping("/list")
    public TableDataInfo list(OrderSetting orderSetting) {
        startPage();
        List<OrderSetting> list = orderSettingService.selectOrderSettingList(orderSetting);
        return getDataTable(list);
    }

    /**
     * 导出订单配置信息列表
     */
    @RequiresPermissions("order:orderSetting:export")
    @Log(title = "订单配置信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OrderSetting orderSetting) {
        List<OrderSetting> list = orderSettingService.selectOrderSettingList(orderSetting);
        ExcelUtil<OrderSetting> util = new ExcelUtil<OrderSetting>(OrderSetting.class);
        util.exportExcel(response, list, "订单配置信息数据");
    }

    /**
     * 获取订单配置信息详细信息
     */
    @RequiresPermissions("order:orderSetting:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(orderSettingService.selectOrderSettingById(id));
    }

    /**
     * 新增订单配置信息
     */
    @RequiresPermissions("order:orderSetting:add")
    @Log(title = "订单配置信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrderSetting orderSetting) {
        return toAjax(orderSettingService.insertOrderSetting(orderSetting));
    }

    /**
     * 修改订单配置信息
     */
    @RequiresPermissions("order:orderSetting:edit")
    @Log(title = "订单配置信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrderSetting orderSetting) {
        return toAjax(orderSettingService.updateOrderSetting(orderSetting));
    }

    /**
     * 删除订单配置信息
     */
    @RequiresPermissions("order:orderSetting:remove")
    @Log(title = "订单配置信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(orderSettingService.deleteOrderSettingByIds(ids));
    }
}
