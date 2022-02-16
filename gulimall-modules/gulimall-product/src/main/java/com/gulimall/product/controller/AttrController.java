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
import com.gulimall.product.domain.Attr;
import com.gulimall.product.service.IAttrService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

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
    public TableDataInfo list(Attr attr) {
        startPage();
        List<Attr> list = attrService.selectAttrList(attr);
        return getDataTable(list);
    }

    /**
     * 导出商品属性列表
     */
    @RequiresPermissions("product:attr:export")
    @Log(title = "商品属性", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Attr attr) {
        List<Attr> list = attrService.selectAttrList(attr);
        ExcelUtil<Attr> util = new ExcelUtil<Attr>(Attr.class);
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
    public AjaxResult add(@RequestBody Attr attr) {
        return toAjax(attrService.insertAttr(attr));
    }

    /**
     * 修改商品属性
     */
    @RequiresPermissions("product:attr:edit")
    @Log(title = "商品属性", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Attr attr) {
        return toAjax(attrService.updateAttr(attr));
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