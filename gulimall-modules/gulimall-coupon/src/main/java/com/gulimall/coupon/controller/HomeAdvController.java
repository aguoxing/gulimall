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
import com.gulimall.coupon.domain.HomeAdv;
import com.gulimall.coupon.service.IHomeAdvService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 首页轮播广告Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/homeAdv")
public class HomeAdvController extends BaseController {
    @Autowired
    private IHomeAdvService homeAdvService;

    /**
     * 查询首页轮播广告列表
     */
    @RequiresPermissions("coupon:homeAdv:list")
    @GetMapping("/list")
    public TableDataInfo list(HomeAdv homeAdv) {
        startPage();
        List<HomeAdv> list = homeAdvService.selectHomeAdvList(homeAdv);
        return getDataTable(list);
    }

    /**
     * 导出首页轮播广告列表
     */
    @RequiresPermissions("coupon:homeAdv:export")
    @Log(title = "首页轮播广告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HomeAdv homeAdv) {
        List<HomeAdv> list = homeAdvService.selectHomeAdvList(homeAdv);
        ExcelUtil<HomeAdv> util = new ExcelUtil<HomeAdv>(HomeAdv.class);
        util.exportExcel(response, list, "首页轮播广告数据");
    }

    /**
     * 获取首页轮播广告详细信息
     */
    @RequiresPermissions("coupon:homeAdv:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(homeAdvService.selectHomeAdvById(id));
    }

    /**
     * 新增首页轮播广告
     */
    @RequiresPermissions("coupon:homeAdv:add")
    @Log(title = "首页轮播广告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HomeAdv homeAdv) {
        return toAjax(homeAdvService.insertHomeAdv(homeAdv));
    }

    /**
     * 修改首页轮播广告
     */
    @RequiresPermissions("coupon:homeAdv:edit")
    @Log(title = "首页轮播广告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HomeAdv homeAdv) {
        return toAjax(homeAdvService.updateHomeAdv(homeAdv));
    }

    /**
     * 删除首页轮播广告
     */
    @RequiresPermissions("coupon:homeAdv:remove")
    @Log(title = "首页轮播广告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(homeAdvService.deleteHomeAdvByIds(ids));
    }
}
