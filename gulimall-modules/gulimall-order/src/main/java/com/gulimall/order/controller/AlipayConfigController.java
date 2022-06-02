package com.gulimall.order.controller;

import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.web.page.TableDataInfo;
import com.gulimall.common.log.annotation.Log;
import com.gulimall.common.log.enums.BusinessType;
import com.gulimall.common.security.annotation.RequiresPermissions;
import com.gulimall.order.domain.AlipayConfig;
import com.gulimall.order.service.IAlipayConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 支付宝配置类Controller
 *
 * @author admin
 * @date 2022-06-02
 */
@RestController
@RequestMapping("/config")
public class AlipayConfigController extends BaseController {
    @Autowired
    private IAlipayConfigService alipayConfigService;

    /**
     * 查询支付宝配置类列表
     */
    @RequiresPermissions("order:config:list")
    @GetMapping("/list")
    public TableDataInfo list(AlipayConfig alipayConfig) {
        startPage();
        List<AlipayConfig> list = alipayConfigService.selectAlipayConfigList(alipayConfig);
        return getDataTable(list);
    }

    /**
     * 导出支付宝配置类列表
     */
    @RequiresPermissions("order:config:export")
    @Log(title = "支付宝配置类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AlipayConfig alipayConfig) {
        List<AlipayConfig> list = alipayConfigService.selectAlipayConfigList(alipayConfig);
        ExcelUtil<AlipayConfig> util = new ExcelUtil<AlipayConfig>(AlipayConfig.class);
        util.exportExcel(response, list, "支付宝配置类数据");
    }

    /**
     * 获取支付宝配置类详细信息
     */
    @RequiresPermissions("order:config:query")
    @GetMapping(value = "/{configId}")
    public AjaxResult getInfo(@PathVariable("configId") String configId) {
        return AjaxResult.success(alipayConfigService.selectAlipayConfigByConfigId(configId));
    }

    /**
     * 新增支付宝配置类
     */
    @RequiresPermissions("order:config:add")
    @Log(title = "支付宝配置类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AlipayConfig alipayConfig) {
        return toAjax(alipayConfigService.insertAlipayConfig(alipayConfig));
    }

    /**
     * 修改支付宝配置类
     */
    @RequiresPermissions("order:config:edit")
    @Log(title = "支付宝配置类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AlipayConfig alipayConfig) {
        return toAjax(alipayConfigService.updateAlipayConfig(alipayConfig));
    }

    /**
     * 删除支付宝配置类
     */
    @RequiresPermissions("order:config:remove")
    @Log(title = "支付宝配置类", businessType = BusinessType.DELETE)
    @DeleteMapping("/{configIds}")
    public AjaxResult remove(@PathVariable String[] configIds) {
        return toAjax(alipayConfigService.deleteAlipayConfigByConfigIds(configIds));
    }
}
