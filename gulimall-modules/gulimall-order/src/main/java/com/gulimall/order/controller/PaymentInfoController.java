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
import com.gulimall.order.domain.PaymentInfo;
import com.gulimall.order.service.IPaymentInfoService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 支付信息Controller
 *
 * @author admin
 * @date 2022-02-15
 */
@RestController
@RequestMapping("/paymentInfo")
public class PaymentInfoController extends BaseController {
    @Autowired
    private IPaymentInfoService paymentInfoService;

    /**
     * 查询支付信息列表
     */
    @RequiresPermissions("order:paymentInfo:list")
    @GetMapping("/list")
    public TableDataInfo list(PaymentInfo paymentInfo) {
        startPage();
        List<PaymentInfo> list = paymentInfoService.selectPaymentInfoList(paymentInfo);
        return getDataTable(list);
    }

    /**
     * 导出支付信息列表
     */
    @RequiresPermissions("order:paymentInfo:export")
    @Log(title = "支付信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PaymentInfo paymentInfo) {
        List<PaymentInfo> list = paymentInfoService.selectPaymentInfoList(paymentInfo);
        ExcelUtil<PaymentInfo> util = new ExcelUtil<PaymentInfo>(PaymentInfo.class);
        util.exportExcel(response, list, "支付信息数据");
    }

    /**
     * 获取支付信息详细信息
     */
    @RequiresPermissions("order:paymentInfo:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(paymentInfoService.selectPaymentInfoById(id));
    }

    /**
     * 新增支付信息
     */
    @RequiresPermissions("order:paymentInfo:add")
    @Log(title = "支付信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PaymentInfo paymentInfo) {
        return toAjax(paymentInfoService.insertPaymentInfo(paymentInfo));
    }

    /**
     * 修改支付信息
     */
    @RequiresPermissions("order:paymentInfo:edit")
    @Log(title = "支付信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PaymentInfo paymentInfo) {
        return toAjax(paymentInfoService.updatePaymentInfo(paymentInfo));
    }

    /**
     * 删除支付信息
     */
    @RequiresPermissions("order:paymentInfo:remove")
    @Log(title = "支付信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(paymentInfoService.deletePaymentInfoByIds(ids));
    }
}
