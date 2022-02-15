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
import com.gulimall.ware.domain.WareSku;
import com.gulimall.ware.service.IWareSkuService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 商品库存Controller
 *
 * @author admin
 * @date 2022-02-15
 */
@RestController
@RequestMapping("/wareSku")
public class WareSkuController extends BaseController {
    @Autowired
    private IWareSkuService wareSkuService;

    /**
     * 查询商品库存列表
     */
    @RequiresPermissions("ware:wareSku:list")
    @GetMapping("/list")
    public TableDataInfo list(WareSku wareSku) {
        startPage();
        List<WareSku> list = wareSkuService.selectWareSkuList(wareSku);
        return getDataTable(list);
    }

    /**
     * 导出商品库存列表
     */
    @RequiresPermissions("ware:wareSku:export")
    @Log(title = "商品库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WareSku wareSku) {
        List<WareSku> list = wareSkuService.selectWareSkuList(wareSku);
        ExcelUtil<WareSku> util = new ExcelUtil<WareSku>(WareSku.class);
        util.exportExcel(response, list, "商品库存数据");
    }

    /**
     * 获取商品库存详细信息
     */
    @RequiresPermissions("ware:wareSku:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(wareSkuService.selectWareSkuById(id));
    }

    /**
     * 新增商品库存
     */
    @RequiresPermissions("ware:wareSku:add")
    @Log(title = "商品库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WareSku wareSku) {
        return toAjax(wareSkuService.insertWareSku(wareSku));
    }

    /**
     * 修改商品库存
     */
    @RequiresPermissions("ware:wareSku:edit")
    @Log(title = "商品库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WareSku wareSku) {
        return toAjax(wareSkuService.updateWareSku(wareSku));
    }

    /**
     * 删除商品库存
     */
    @RequiresPermissions("ware:wareSku:remove")
    @Log(title = "商品库存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(wareSkuService.deleteWareSkuByIds(ids));
    }
}
