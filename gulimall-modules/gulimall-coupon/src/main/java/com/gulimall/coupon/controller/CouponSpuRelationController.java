package com.gulimall.coupon.controller;

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
import com.gulimall.coupon.domain.CouponSpuRelation;
import com.gulimall.coupon.service.ICouponSpuRelationService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 优惠券与产品关联Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/couponSpuRelation")
public class CouponSpuRelationController extends BaseController {
    @Autowired
    private ICouponSpuRelationService couponSpuRelationService;

    /**
     * 查询优惠券与产品关联列表
     */
    @RequiresPermissions("coupon:couponSpuRelation:list")
    @GetMapping("/list")
    public TableDataInfo list(CouponSpuRelation couponSpuRelation) {
        startPage();
        List<CouponSpuRelation> list = couponSpuRelationService.selectCouponSpuRelationList(couponSpuRelation);
        return getDataTable(list);
    }

    /**
     * 导出优惠券与产品关联列表
     */
    @RequiresPermissions("coupon:couponSpuRelation:export")
    @Log(title = "优惠券与产品关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CouponSpuRelation couponSpuRelation) {
        List<CouponSpuRelation> list = couponSpuRelationService.selectCouponSpuRelationList(couponSpuRelation);
        ExcelUtil<CouponSpuRelation> util = new ExcelUtil<CouponSpuRelation>(CouponSpuRelation.class);
        util.exportExcel(response, list, "优惠券与产品关联数据");
    }

    /**
     * 获取优惠券与产品关联详细信息
     */
    @RequiresPermissions("coupon:couponSpuRelation:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(couponSpuRelationService.selectCouponSpuRelationById(id));
    }

    /**
     * 新增优惠券与产品关联
     */
    @RequiresPermissions("coupon:couponSpuRelation:add")
    @Log(title = "优惠券与产品关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CouponSpuRelation couponSpuRelation) {
        return toAjax(couponSpuRelationService.insertCouponSpuRelation(couponSpuRelation));
    }

    /**
     * 修改优惠券与产品关联
     */
    @RequiresPermissions("coupon:couponSpuRelation:edit")
    @Log(title = "优惠券与产品关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CouponSpuRelation couponSpuRelation) {
        return toAjax(couponSpuRelationService.updateCouponSpuRelation(couponSpuRelation));
    }

    /**
     * 删除优惠券与产品关联
     */
    @RequiresPermissions("coupon:couponSpuRelation:remove")
    @Log(title = "优惠券与产品关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(couponSpuRelationService.deleteCouponSpuRelationByIds(ids));
    }
}
