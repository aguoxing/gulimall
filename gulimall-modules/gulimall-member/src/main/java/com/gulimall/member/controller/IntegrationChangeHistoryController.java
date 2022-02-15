package com.gulimall.member.controller;

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
import com.gulimall.member.domain.IntegrationChangeHistory;
import com.gulimall.member.service.IIntegrationChangeHistoryService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 积分变化历史记录Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/integrationChangeHistory")
public class IntegrationChangeHistoryController extends BaseController {
    @Autowired
    private IIntegrationChangeHistoryService integrationChangeHistoryService;

    /**
     * 查询积分变化历史记录列表
     */
    @RequiresPermissions("member:integrationChangeHistory:list")
    @GetMapping("/list")
    public TableDataInfo list(IntegrationChangeHistory integrationChangeHistory) {
        startPage();
        List<IntegrationChangeHistory> list = integrationChangeHistoryService.selectIntegrationChangeHistoryList(integrationChangeHistory);
        return getDataTable(list);
    }

    /**
     * 导出积分变化历史记录列表
     */
    @RequiresPermissions("member:integrationChangeHistory:export")
    @Log(title = "积分变化历史记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, IntegrationChangeHistory integrationChangeHistory) {
        List<IntegrationChangeHistory> list = integrationChangeHistoryService.selectIntegrationChangeHistoryList(integrationChangeHistory);
        ExcelUtil<IntegrationChangeHistory> util = new ExcelUtil<IntegrationChangeHistory>(IntegrationChangeHistory.class);
        util.exportExcel(response, list, "积分变化历史记录数据");
    }

    /**
     * 获取积分变化历史记录详细信息
     */
    @RequiresPermissions("member:integrationChangeHistory:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(integrationChangeHistoryService.selectIntegrationChangeHistoryById(id));
    }

    /**
     * 新增积分变化历史记录
     */
    @RequiresPermissions("member:integrationChangeHistory:add")
    @Log(title = "积分变化历史记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody IntegrationChangeHistory integrationChangeHistory) {
        return toAjax(integrationChangeHistoryService.insertIntegrationChangeHistory(integrationChangeHistory));
    }

    /**
     * 修改积分变化历史记录
     */
    @RequiresPermissions("member:integrationChangeHistory:edit")
    @Log(title = "积分变化历史记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody IntegrationChangeHistory integrationChangeHistory) {
        return toAjax(integrationChangeHistoryService.updateIntegrationChangeHistory(integrationChangeHistory));
    }

    /**
     * 删除积分变化历史记录
     */
    @RequiresPermissions("member:integrationChangeHistory:remove")
    @Log(title = "积分变化历史记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(integrationChangeHistoryService.deleteIntegrationChangeHistoryByIds(ids));
    }
}
