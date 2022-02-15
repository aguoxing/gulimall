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
import com.gulimall.member.domain.Member;
import com.gulimall.member.service.IMemberService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 会员Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/member")
public class MemberController extends BaseController {
    @Autowired
    private IMemberService memberService;

    /**
     * 查询会员列表
     */
    @RequiresPermissions("member:member:list")
    @GetMapping("/list")
    public TableDataInfo list(Member member) {
        startPage();
        List<Member> list = memberService.selectMemberList(member);
        return getDataTable(list);
    }

    /**
     * 导出会员列表
     */
    @RequiresPermissions("member:member:export")
    @Log(title = "会员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Member member) {
        List<Member> list = memberService.selectMemberList(member);
        ExcelUtil<Member> util = new ExcelUtil<Member>(Member.class);
        util.exportExcel(response, list, "会员数据");
    }

    /**
     * 获取会员详细信息
     */
    @RequiresPermissions("member:member:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(memberService.selectMemberById(id));
    }

    /**
     * 新增会员
     */
    @RequiresPermissions("member:member:add")
    @Log(title = "会员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Member member) {
        return toAjax(memberService.insertMember(member));
    }

    /**
     * 修改会员
     */
    @RequiresPermissions("member:member:edit")
    @Log(title = "会员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Member member) {
        return toAjax(memberService.updateMember(member));
    }

    /**
     * 删除会员
     */
    @RequiresPermissions("member:member:remove")
    @Log(title = "会员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(memberService.deleteMemberByIds(ids));
    }
}
