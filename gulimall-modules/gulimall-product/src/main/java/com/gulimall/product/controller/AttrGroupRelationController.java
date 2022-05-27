package com.gulimall.product.controller;

import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.web.page.TableDataInfo;
import com.gulimall.common.log.annotation.Log;
import com.gulimall.common.log.enums.BusinessType;
import com.gulimall.common.security.annotation.RequiresPermissions;
import com.gulimall.product.domain.AttrGroupRelation;
import com.gulimall.product.domain.dto.AttrGroupRelationDTO;
import com.gulimall.product.service.IAttrGroupRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 属性&属性分组关联Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/attrGroupRelation")
public class AttrGroupRelationController extends BaseController {
    @Autowired
    private IAttrGroupRelationService attrGroupRelationService;

    /**
     * 查询属性&属性分组关联列表
     */
    @RequiresPermissions("product:attrGroupRelation:list")
    @GetMapping("/list")
    public TableDataInfo list(AttrGroupRelation attrGroupRelation) {
        startPage();
        List<AttrGroupRelation> list = attrGroupRelationService.selectAttrGroupRelationList(attrGroupRelation);
        return getDataTable(list);
    }

    /**
     * 导出属性&属性分组关联列表
     */
    @RequiresPermissions("product:attrGroupRelation:export")
    @Log(title = "属性&属性分组关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AttrGroupRelation attrGroupRelation) {
        List<AttrGroupRelation> list = attrGroupRelationService.selectAttrGroupRelationList(attrGroupRelation);
        ExcelUtil<AttrGroupRelation> util = new ExcelUtil<AttrGroupRelation>(AttrGroupRelation.class);
        util.exportExcel(response, list, "属性&属性分组关联数据");
    }

    /**
     * 获取属性&属性分组关联详细信息
     */
    @RequiresPermissions("product:attrGroupRelation:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(attrGroupRelationService.selectAttrGroupRelationById(id));
    }

    /**
     * 新增属性&属性分组关联
     */
    @RequiresPermissions("product:attrGroupRelation:add")
    @Log(title = "属性&属性分组关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AttrGroupRelationDTO attrGroupRelationDTO) {
        return toAjax(attrGroupRelationService.insertAttrGroupRelation(attrGroupRelationDTO));
    }

    /**
     * 修改属性&属性分组关联
     */
    @RequiresPermissions("product:attrGroupRelation:edit")
    @Log(title = "属性&属性分组关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AttrGroupRelation attrGroupRelation) {
        return toAjax(attrGroupRelationService.updateAttrGroupRelation(attrGroupRelation));
    }

    /**
     * 删除属性&属性分组关联
     */
    @RequiresPermissions("product:attrGroupRelation:remove")
    @Log(title = "属性&属性分组关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(attrGroupRelationService.deleteAttrGroupRelationByIds(ids));
    }
}
