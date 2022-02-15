package com.gulimall.product.controller;

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
import com.gulimall.product.domain.AttrAttrgroupRelation;
import com.gulimall.product.service.IAttrAttrgroupRelationService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 属性&属性分组关联Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/attrAttrgroupRelation")
public class AttrAttrgroupRelationController extends BaseController {
    @Autowired
    private IAttrAttrgroupRelationService attrAttrgroupRelationService;

    /**
     * 查询属性&属性分组关联列表
     */
    @RequiresPermissions("product:attrAttrgroupRelation:list")
    @GetMapping("/list")
    public TableDataInfo list(AttrAttrgroupRelation attrAttrgroupRelation) {
        startPage();
        List<AttrAttrgroupRelation> list = attrAttrgroupRelationService.selectAttrAttrgroupRelationList(attrAttrgroupRelation);
        return getDataTable(list);
    }

    /**
     * 导出属性&属性分组关联列表
     */
    @RequiresPermissions("product:attrAttrgroupRelation:export")
    @Log(title = "属性&属性分组关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AttrAttrgroupRelation attrAttrgroupRelation) {
        List<AttrAttrgroupRelation> list = attrAttrgroupRelationService.selectAttrAttrgroupRelationList(attrAttrgroupRelation);
        ExcelUtil<AttrAttrgroupRelation> util = new ExcelUtil<AttrAttrgroupRelation>(AttrAttrgroupRelation.class);
        util.exportExcel(response, list, "属性&属性分组关联数据");
    }

    /**
     * 获取属性&属性分组关联详细信息
     */
    @RequiresPermissions("product:attrAttrgroupRelation:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(attrAttrgroupRelationService.selectAttrAttrgroupRelationById(id));
    }

    /**
     * 新增属性&属性分组关联
     */
    @RequiresPermissions("product:attrAttrgroupRelation:add")
    @Log(title = "属性&属性分组关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AttrAttrgroupRelation attrAttrgroupRelation) {
        return toAjax(attrAttrgroupRelationService.insertAttrAttrgroupRelation(attrAttrgroupRelation));
    }

    /**
     * 修改属性&属性分组关联
     */
    @RequiresPermissions("product:attrAttrgroupRelation:edit")
    @Log(title = "属性&属性分组关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AttrAttrgroupRelation attrAttrgroupRelation) {
        return toAjax(attrAttrgroupRelationService.updateAttrAttrgroupRelation(attrAttrgroupRelation));
    }

    /**
     * 删除属性&属性分组关联
     */
    @RequiresPermissions("product:attrAttrgroupRelation:remove")
    @Log(title = "属性&属性分组关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(attrAttrgroupRelationService.deleteAttrAttrgroupRelationByIds(ids));
    }
}
