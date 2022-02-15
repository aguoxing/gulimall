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
import com.gulimall.coupon.domain.SeckillSkuNotice;
import com.gulimall.coupon.service.ISeckillSkuNoticeService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 秒杀商品通知订阅Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/seckillSkuNotice")
public class SeckillSkuNoticeController extends BaseController {
    @Autowired
    private ISeckillSkuNoticeService seckillSkuNoticeService;

    /**
     * 查询秒杀商品通知订阅列表
     */
    @RequiresPermissions("coupon:seckillSkuNotice:list")
    @GetMapping("/list")
    public TableDataInfo list(SeckillSkuNotice seckillSkuNotice) {
        startPage();
        List<SeckillSkuNotice> list = seckillSkuNoticeService.selectSeckillSkuNoticeList(seckillSkuNotice);
        return getDataTable(list);
    }

    /**
     * 导出秒杀商品通知订阅列表
     */
    @RequiresPermissions("coupon:seckillSkuNotice:export")
    @Log(title = "秒杀商品通知订阅", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SeckillSkuNotice seckillSkuNotice) {
        List<SeckillSkuNotice> list = seckillSkuNoticeService.selectSeckillSkuNoticeList(seckillSkuNotice);
        ExcelUtil<SeckillSkuNotice> util = new ExcelUtil<SeckillSkuNotice>(SeckillSkuNotice.class);
        util.exportExcel(response, list, "秒杀商品通知订阅数据");
    }

    /**
     * 获取秒杀商品通知订阅详细信息
     */
    @RequiresPermissions("coupon:seckillSkuNotice:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(seckillSkuNoticeService.selectSeckillSkuNoticeById(id));
    }

    /**
     * 新增秒杀商品通知订阅
     */
    @RequiresPermissions("coupon:seckillSkuNotice:add")
    @Log(title = "秒杀商品通知订阅", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SeckillSkuNotice seckillSkuNotice) {
        return toAjax(seckillSkuNoticeService.insertSeckillSkuNotice(seckillSkuNotice));
    }

    /**
     * 修改秒杀商品通知订阅
     */
    @RequiresPermissions("coupon:seckillSkuNotice:edit")
    @Log(title = "秒杀商品通知订阅", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SeckillSkuNotice seckillSkuNotice) {
        return toAjax(seckillSkuNoticeService.updateSeckillSkuNotice(seckillSkuNotice));
    }

    /**
     * 删除秒杀商品通知订阅
     */
    @RequiresPermissions("coupon:seckillSkuNotice:remove")
    @Log(title = "秒杀商品通知订阅", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(seckillSkuNoticeService.deleteSeckillSkuNoticeByIds(ids));
    }
}
