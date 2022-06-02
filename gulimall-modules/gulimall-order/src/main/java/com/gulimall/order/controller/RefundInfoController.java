package com.gulimall.order.controller;

import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.web.page.TableDataInfo;
import com.gulimall.common.log.annotation.Log;
import com.gulimall.common.log.enums.BusinessType;
import com.gulimall.common.security.annotation.RequiresPermissions;
import com.gulimall.order.domain.RefundInfo;
import com.gulimall.order.service.IRefundInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 退款信息Controller
 *
 * @author admin
 * @date 2022-02-15
 */
@RestController
@RequestMapping("/refundInfo")
public class RefundInfoController extends BaseController {
    @Autowired
    private IRefundInfoService refundInfoService;

    /**
     * 查询退款信息列表
     */
    @RequiresPermissions("order:refundInfo:list")
    @GetMapping("/list")
    public TableDataInfo list(RefundInfo refundInfo) {
        startPage();
        List<RefundInfo> list = refundInfoService.selectRefundInfoList(refundInfo);
        return getDataTable(list);
    }

    /**
     * 导出退款信息列表
     */
    @RequiresPermissions("order:refundInfo:export")
    @Log(title = "退款信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RefundInfo refundInfo) {
        List<RefundInfo> list = refundInfoService.selectRefundInfoList(refundInfo);
        ExcelUtil<RefundInfo> util = new ExcelUtil<RefundInfo>(RefundInfo.class);
        util.exportExcel(response, list, "退款信息数据");
    }

    /**
     * 获取退款信息详细信息
     */
    @RequiresPermissions("order:refundInfo:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(refundInfoService.selectRefundInfoById(id));
    }

    /**
     * 新增退款信息
     */
    @RequiresPermissions("order:refundInfo:add")
    @Log(title = "退款信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RefundInfo refundInfo) {
        return toAjax(refundInfoService.insertRefundInfo(refundInfo));
    }

    /**
     * 修改退款信息
     */
    @RequiresPermissions("order:refundInfo:edit")
    @Log(title = "退款信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RefundInfo refundInfo) {
        return toAjax(refundInfoService.updateRefundInfo(refundInfo));
    }

    /**
     * 删除退款信息
     */
    @RequiresPermissions("order:refundInfo:remove")
    @Log(title = "退款信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(refundInfoService.deleteRefundInfoByIds(ids));
    }
}
