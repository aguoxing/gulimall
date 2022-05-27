package com.gulimall.product.controller;

import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.web.page.TableDataInfo;
import com.gulimall.common.log.annotation.Log;
import com.gulimall.common.log.enums.BusinessType;
import com.gulimall.common.security.annotation.RequiresPermissions;
import com.gulimall.product.domain.AttrEntity;
import com.gulimall.product.domain.AttrGroupRelation;
import com.gulimall.product.service.IAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 商品属性Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/attr")
public class AttrController extends BaseController {
    @Autowired
    private IAttrService attrService;

    /**
     * 查询商品属性列表
     */
    @RequiresPermissions("product:attr:list")
    @GetMapping("/list")
    public TableDataInfo list(AttrEntity attrEntity) {
        startPage();
        List<AttrEntity> list = attrService.selectAttrList(attrEntity);
        return getDataTable(list);
    }

    @GetMapping("/attrRelation")
    public TableDataInfo attrRelation(AttrGroupRelation attrGroupRelation) {
        startPage();
        return getDataTable(attrService.selectAttrByAttrGroupId(attrGroupRelation));
    }

    /**
     * 导出商品属性列表
     */
    @RequiresPermissions("product:attr:export")
    @Log(title = "商品属性", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AttrEntity attrEntity) {
        List<AttrEntity> list = attrService.selectAttrList(attrEntity);
        ExcelUtil<AttrEntity> util = new ExcelUtil<AttrEntity>(AttrEntity.class);
        util.exportExcel(response, list, "商品属性数据");
    }

    /**
     * 获取商品属性详细信息
     */
    @RequiresPermissions("product:attr:query")
    @GetMapping(value = "/{attrId}")
    public AjaxResult getInfo(@PathVariable("attrId") Long attrId) {
        return AjaxResult.success(attrService.selectAttrByAttrId(attrId));
    }

    /**
     * 新增商品属性
     */
    @RequiresPermissions("product:attr:add")
    @Log(title = "商品属性", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AttrEntity attrEntity) {
        return toAjax(attrService.insertAttr(attrEntity));
    }

    /**
     * 修改商品属性
     */
    @RequiresPermissions("product:attr:edit")
    @Log(title = "商品属性", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AttrEntity attrEntity) {
        return toAjax(attrService.updateAttr(attrEntity));
    }

    /**
     * 删除商品属性
     */
    @RequiresPermissions("product:attr:remove")
    @Log(title = "商品属性", businessType = BusinessType.DELETE)
	@DeleteMapping("/{attrIds}")
    public AjaxResult remove(@PathVariable Long[] attrIds) {
        return toAjax(attrService.deleteAttrByAttrIds(attrIds));
    }
}
