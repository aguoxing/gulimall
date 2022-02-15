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
import com.gulimall.member.domain.MemberLoginLog;
import com.gulimall.member.service.IMemberLoginLogService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 会员登录记录Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/memberLoginLog")
public class MemberLoginLogController extends BaseController {
    @Autowired
    private IMemberLoginLogService memberLoginLogService;

    /**
     * 查询会员登录记录列表
     */
    @RequiresPermissions("member:memberLoginLog:list")
    @GetMapping("/list")
    public TableDataInfo list(MemberLoginLog memberLoginLog) {
        startPage();
        List<MemberLoginLog> list = memberLoginLogService.selectMemberLoginLogList(memberLoginLog);
        return getDataTable(list);
    }

    /**
     * 导出会员登录记录列表
     */
    @RequiresPermissions("member:memberLoginLog:export")
    @Log(title = "会员登录记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MemberLoginLog memberLoginLog) {
        List<MemberLoginLog> list = memberLoginLogService.selectMemberLoginLogList(memberLoginLog);
        ExcelUtil<MemberLoginLog> util = new ExcelUtil<MemberLoginLog>(MemberLoginLog.class);
        util.exportExcel(response, list, "会员登录记录数据");
    }

    /**
     * 获取会员登录记录详细信息
     */
    @RequiresPermissions("member:memberLoginLog:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(memberLoginLogService.selectMemberLoginLogById(id));
    }

    /**
     * 新增会员登录记录
     */
    @RequiresPermissions("member:memberLoginLog:add")
    @Log(title = "会员登录记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MemberLoginLog memberLoginLog) {
        return toAjax(memberLoginLogService.insertMemberLoginLog(memberLoginLog));
    }

    /**
     * 修改会员登录记录
     */
    @RequiresPermissions("member:memberLoginLog:edit")
    @Log(title = "会员登录记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MemberLoginLog memberLoginLog) {
        return toAjax(memberLoginLogService.updateMemberLoginLog(memberLoginLog));
    }

    /**
     * 删除会员登录记录
     */
    @RequiresPermissions("member:memberLoginLog:remove")
    @Log(title = "会员登录记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(memberLoginLogService.deleteMemberLoginLogByIds(ids));
    }
}
