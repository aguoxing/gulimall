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
import com.gulimall.coupon.domain.HomeSubject;
import com.gulimall.coupon.service.IHomeSubjectService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 首页专题Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/homeSubject")
public class HomeSubjectController extends BaseController {
    @Autowired
    private IHomeSubjectService homeSubjectService;

    /**
     * 查询首页专题列表
     */
    @RequiresPermissions("coupon:homeSubject:list")
    @GetMapping("/list")
    public TableDataInfo list(HomeSubject homeSubject) {
        startPage();
        List<HomeSubject> list = homeSubjectService.selectHomeSubjectList(homeSubject);
        return getDataTable(list);
    }

    /**
     * 导出首页专题列表
     */
    @RequiresPermissions("coupon:homeSubject:export")
    @Log(title = "首页专题", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HomeSubject homeSubject) {
        List<HomeSubject> list = homeSubjectService.selectHomeSubjectList(homeSubject);
        ExcelUtil<HomeSubject> util = new ExcelUtil<HomeSubject>(HomeSubject.class);
        util.exportExcel(response, list, "首页专题数据");
    }

    /**
     * 获取首页专题详细信息
     */
    @RequiresPermissions("coupon:homeSubject:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(homeSubjectService.selectHomeSubjectById(id));
    }

    /**
     * 新增首页专题
     */
    @RequiresPermissions("coupon:homeSubject:add")
    @Log(title = "首页专题", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HomeSubject homeSubject) {
        return toAjax(homeSubjectService.insertHomeSubject(homeSubject));
    }

    /**
     * 修改首页专题
     */
    @RequiresPermissions("coupon:homeSubject:edit")
    @Log(title = "首页专题", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HomeSubject homeSubject) {
        return toAjax(homeSubjectService.updateHomeSubject(homeSubject));
    }

    /**
     * 删除首页专题
     */
    @RequiresPermissions("coupon:homeSubject:remove")
    @Log(title = "首页专题", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(homeSubjectService.deleteHomeSubjectByIds(ids));
    }
}
