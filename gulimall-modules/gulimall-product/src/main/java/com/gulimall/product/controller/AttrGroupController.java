package com.gulimall.product.controller;

import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.web.page.TableDataInfo;
import com.gulimall.common.log.annotation.Log;
import com.gulimall.common.log.enums.BusinessType;
import com.gulimall.common.security.annotation.RequiresPermissions;
import com.gulimall.product.domain.AttrGroup;
import com.gulimall.product.service.IAttrGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 属性分组Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/group")
public class AttrGroupController extends BaseController {
    @Autowired
    private IAttrGroupService attrGroupService;

    /**
     * 查询属性分组列表
     */
    @RequiresPermissions("product:group:list")
    @GetMapping("/list")
    public TableDataInfo list(AttrGroup attrGroup) {
        startPage();
        List<AttrGroup> list = attrGroupService.selectAttrGroupList(attrGroup);
        return getDataTable(list);
    }

    /**
     * 导出属性分组列表
     */
    @RequiresPermissions("product:group:export")
    @Log(title = "属性分组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AttrGroup attrGroup) {
        List<AttrGroup> list = attrGroupService.selectAttrGroupList(attrGroup);
        ExcelUtil<AttrGroup> util = new ExcelUtil<AttrGroup>(AttrGroup.class);
        util.exportExcel(response, list, "属性分组数据");
    }

    /**
     * 获取属性分组详细信息
     */
    @RequiresPermissions("product:group:query")
    @GetMapping(value = "/{attrGroupId}")
    public AjaxResult getInfo(@PathVariable("attrGroupId") Long attrGroupId) {
        return AjaxResult.success(attrGroupService.selectAttrGroupByAttrGroupId(attrGroupId));
    }

    /**
     * 新增属性分组
     */
    @RequiresPermissions("product:group:add")
    @Log(title = "属性分组", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AttrGroup attrGroup) {
        return toAjax(attrGroupService.insertAttrGroup(attrGroup));
    }

    /**
     * 修改属性分组
     */
    @RequiresPermissions("product:group:edit")
    @Log(title = "属性分组", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AttrGroup attrGroup) {
        return toAjax(attrGroupService.updateAttrGroup(attrGroup));
    }

    /**
     * 删除属性分组
     */
    @RequiresPermissions("product:group:remove")
    @Log(title = "属性分组", businessType = BusinessType.DELETE)
    @DeleteMapping("/{attrGroupIds}")
    public AjaxResult remove(@PathVariable Long[] attrGroupIds) {
        return toAjax(attrGroupService.deleteAttrGroupByAttrGroupIds(attrGroupIds));
    }

    @GetMapping("/getAttrGroupWithAttrVo")
    public AjaxResult getAttrGroupWithAttrVo(AttrGroup attrGroup) {
        return AjaxResult.success(attrGroupService.getAttrGroupWithAttrVo(attrGroup));
    }
}
