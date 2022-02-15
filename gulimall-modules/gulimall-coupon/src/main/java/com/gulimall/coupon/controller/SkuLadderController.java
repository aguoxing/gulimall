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
import com.gulimall.coupon.domain.SkuLadder;
import com.gulimall.coupon.service.ISkuLadderService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 商品阶梯价格Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/skuLadder")
public class SkuLadderController extends BaseController {
    @Autowired
    private ISkuLadderService skuLadderService;

    /**
     * 查询商品阶梯价格列表
     */
    @RequiresPermissions("coupon:skuLadder:list")
    @GetMapping("/list")
    public TableDataInfo list(SkuLadder skuLadder) {
        startPage();
        List<SkuLadder> list = skuLadderService.selectSkuLadderList(skuLadder);
        return getDataTable(list);
    }

    /**
     * 导出商品阶梯价格列表
     */
    @RequiresPermissions("coupon:skuLadder:export")
    @Log(title = "商品阶梯价格", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SkuLadder skuLadder) {
        List<SkuLadder> list = skuLadderService.selectSkuLadderList(skuLadder);
        ExcelUtil<SkuLadder> util = new ExcelUtil<SkuLadder>(SkuLadder.class);
        util.exportExcel(response, list, "商品阶梯价格数据");
    }

    /**
     * 获取商品阶梯价格详细信息
     */
    @RequiresPermissions("coupon:skuLadder:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(skuLadderService.selectSkuLadderById(id));
    }

    /**
     * 新增商品阶梯价格
     */
    @RequiresPermissions("coupon:skuLadder:add")
    @Log(title = "商品阶梯价格", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SkuLadder skuLadder) {
        return toAjax(skuLadderService.insertSkuLadder(skuLadder));
    }

    /**
     * 修改商品阶梯价格
     */
    @RequiresPermissions("coupon:skuLadder:edit")
    @Log(title = "商品阶梯价格", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SkuLadder skuLadder) {
        return toAjax(skuLadderService.updateSkuLadder(skuLadder));
    }

    /**
     * 删除商品阶梯价格
     */
    @RequiresPermissions("coupon:skuLadder:remove")
    @Log(title = "商品阶梯价格", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(skuLadderService.deleteSkuLadderByIds(ids));
    }
}
