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
import com.gulimall.coupon.domain.HomeSubjectSpu;
import com.gulimall.coupon.service.IHomeSubjectSpuService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 专题商品Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/homeSubjectSpu")
public class HomeSubjectSpuController extends BaseController {
    @Autowired
    private IHomeSubjectSpuService homeSubjectSpuService;

    /**
     * 查询专题商品列表
     */
    @RequiresPermissions("coupon:homeSubjectSpu:list")
    @GetMapping("/list")
    public TableDataInfo list(HomeSubjectSpu homeSubjectSpu) {
        startPage();
        List<HomeSubjectSpu> list = homeSubjectSpuService.selectHomeSubjectSpuList(homeSubjectSpu);
        return getDataTable(list);
    }

    /**
     * 导出专题商品列表
     */
    @RequiresPermissions("coupon:homeSubjectSpu:export")
    @Log(title = "专题商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HomeSubjectSpu homeSubjectSpu) {
        List<HomeSubjectSpu> list = homeSubjectSpuService.selectHomeSubjectSpuList(homeSubjectSpu);
        ExcelUtil<HomeSubjectSpu> util = new ExcelUtil<HomeSubjectSpu>(HomeSubjectSpu.class);
        util.exportExcel(response, list, "专题商品数据");
    }

    /**
     * 获取专题商品详细信息
     */
    @RequiresPermissions("coupon:homeSubjectSpu:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(homeSubjectSpuService.selectHomeSubjectSpuById(id));
    }

    /**
     * 新增专题商品
     */
    @RequiresPermissions("coupon:homeSubjectSpu:add")
    @Log(title = "专题商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HomeSubjectSpu homeSubjectSpu) {
        return toAjax(homeSubjectSpuService.insertHomeSubjectSpu(homeSubjectSpu));
    }

    /**
     * 修改专题商品
     */
    @RequiresPermissions("coupon:homeSubjectSpu:edit")
    @Log(title = "专题商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HomeSubjectSpu homeSubjectSpu) {
        return toAjax(homeSubjectSpuService.updateHomeSubjectSpu(homeSubjectSpu));
    }

    /**
     * 删除专题商品
     */
    @RequiresPermissions("coupon:homeSubjectSpu:remove")
    @Log(title = "专题商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(homeSubjectSpuService.deleteHomeSubjectSpuByIds(ids));
    }
}
