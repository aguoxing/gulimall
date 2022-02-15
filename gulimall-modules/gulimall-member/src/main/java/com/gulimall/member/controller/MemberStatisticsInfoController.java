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
import com.gulimall.member.domain.MemberStatisticsInfo;
import com.gulimall.member.service.IMemberStatisticsInfoService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 会员统计信息Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/memberStatisticsInfo")
public class MemberStatisticsInfoController extends BaseController {
    @Autowired
    private IMemberStatisticsInfoService memberStatisticsInfoService;

    /**
     * 查询会员统计信息列表
     */
    @RequiresPermissions("member:memberStatisticsInfo:list")
    @GetMapping("/list")
    public TableDataInfo list(MemberStatisticsInfo memberStatisticsInfo) {
        startPage();
        List<MemberStatisticsInfo> list = memberStatisticsInfoService.selectMemberStatisticsInfoList(memberStatisticsInfo);
        return getDataTable(list);
    }

    /**
     * 导出会员统计信息列表
     */
    @RequiresPermissions("member:memberStatisticsInfo:export")
    @Log(title = "会员统计信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MemberStatisticsInfo memberStatisticsInfo) {
        List<MemberStatisticsInfo> list = memberStatisticsInfoService.selectMemberStatisticsInfoList(memberStatisticsInfo);
        ExcelUtil<MemberStatisticsInfo> util = new ExcelUtil<MemberStatisticsInfo>(MemberStatisticsInfo.class);
        util.exportExcel(response, list, "会员统计信息数据");
    }

    /**
     * 获取会员统计信息详细信息
     */
    @RequiresPermissions("member:memberStatisticsInfo:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(memberStatisticsInfoService.selectMemberStatisticsInfoById(id));
    }

    /**
     * 新增会员统计信息
     */
    @RequiresPermissions("member:memberStatisticsInfo:add")
    @Log(title = "会员统计信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MemberStatisticsInfo memberStatisticsInfo) {
        return toAjax(memberStatisticsInfoService.insertMemberStatisticsInfo(memberStatisticsInfo));
    }

    /**
     * 修改会员统计信息
     */
    @RequiresPermissions("member:memberStatisticsInfo:edit")
    @Log(title = "会员统计信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MemberStatisticsInfo memberStatisticsInfo) {
        return toAjax(memberStatisticsInfoService.updateMemberStatisticsInfo(memberStatisticsInfo));
    }

    /**
     * 删除会员统计信息
     */
    @RequiresPermissions("member:memberStatisticsInfo:remove")
    @Log(title = "会员统计信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(memberStatisticsInfoService.deleteMemberStatisticsInfoByIds(ids));
    }
}
