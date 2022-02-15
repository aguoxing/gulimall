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
import com.gulimall.ware.domain.PurchaseDetail;
import com.gulimall.ware.service.IPurchaseDetailService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 采购信息详情Controller
 *
 * @author admin
 * @date 2022-02-15
 */
@RestController
@RequestMapping("/purchaseDetail")
public class PurchaseDetailController extends BaseController {
    @Autowired
    private IPurchaseDetailService purchaseDetailService;

    /**
     * 查询采购信息详情列表
     */
    @RequiresPermissions("ware:purchaseDetail:list")
    @GetMapping("/list")
    public TableDataInfo list(PurchaseDetail purchaseDetail) {
        startPage();
        List<PurchaseDetail> list = purchaseDetailService.selectPurchaseDetailList(purchaseDetail);
        return getDataTable(list);
    }

    /**
     * 导出采购信息详情列表
     */
    @RequiresPermissions("ware:purchaseDetail:export")
    @Log(title = "采购信息详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PurchaseDetail purchaseDetail) {
        List<PurchaseDetail> list = purchaseDetailService.selectPurchaseDetailList(purchaseDetail);
        ExcelUtil<PurchaseDetail> util = new ExcelUtil<PurchaseDetail>(PurchaseDetail.class);
        util.exportExcel(response, list, "采购信息详情数据");
    }

    /**
     * 获取采购信息详情详细信息
     */
    @RequiresPermissions("ware:purchaseDetail:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(purchaseDetailService.selectPurchaseDetailById(id));
    }

    /**
     * 新增采购信息详情
     */
    @RequiresPermissions("ware:purchaseDetail:add")
    @Log(title = "采购信息详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PurchaseDetail purchaseDetail) {
        return toAjax(purchaseDetailService.insertPurchaseDetail(purchaseDetail));
    }

    /**
     * 修改采购信息详情
     */
    @RequiresPermissions("ware:purchaseDetail:edit")
    @Log(title = "采购信息详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PurchaseDetail purchaseDetail) {
        return toAjax(purchaseDetailService.updatePurchaseDetail(purchaseDetail));
    }

    /**
     * 删除采购信息详情
     */
    @RequiresPermissions("ware:purchaseDetail:remove")
    @Log(title = "采购信息详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(purchaseDetailService.deletePurchaseDetailByIds(ids));
    }
}
