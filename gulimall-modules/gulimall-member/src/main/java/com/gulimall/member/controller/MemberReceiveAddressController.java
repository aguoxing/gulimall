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
import com.gulimall.member.domain.MemberReceiveAddress;
import com.gulimall.member.service.IMemberReceiveAddressService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 会员收货地址Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/memberReceiveAddress")
public class MemberReceiveAddressController extends BaseController {
    @Autowired
    private IMemberReceiveAddressService memberReceiveAddressService;

    /**
     * 查询会员收货地址列表
     */
    @RequiresPermissions("member:memberReceiveAddress:list")
    @GetMapping("/list")
    public TableDataInfo list(MemberReceiveAddress memberReceiveAddress) {
        startPage();
        List<MemberReceiveAddress> list = memberReceiveAddressService.selectMemberReceiveAddressList(memberReceiveAddress);
        return getDataTable(list);
    }

    /**
     * 导出会员收货地址列表
     */
    @RequiresPermissions("member:memberReceiveAddress:export")
    @Log(title = "会员收货地址", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MemberReceiveAddress memberReceiveAddress) {
        List<MemberReceiveAddress> list = memberReceiveAddressService.selectMemberReceiveAddressList(memberReceiveAddress);
        ExcelUtil<MemberReceiveAddress> util = new ExcelUtil<MemberReceiveAddress>(MemberReceiveAddress.class);
        util.exportExcel(response, list, "会员收货地址数据");
    }

    /**
     * 获取会员收货地址详细信息
     */
    @RequiresPermissions("member:memberReceiveAddress:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(memberReceiveAddressService.selectMemberReceiveAddressById(id));
    }

    /**
     * 新增会员收货地址
     */
    @RequiresPermissions("member:memberReceiveAddress:add")
    @Log(title = "会员收货地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MemberReceiveAddress memberReceiveAddress) {
        return toAjax(memberReceiveAddressService.insertMemberReceiveAddress(memberReceiveAddress));
    }

    /**
     * 修改会员收货地址
     */
    @RequiresPermissions("member:memberReceiveAddress:edit")
    @Log(title = "会员收货地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MemberReceiveAddress memberReceiveAddress) {
        return toAjax(memberReceiveAddressService.updateMemberReceiveAddress(memberReceiveAddress));
    }

    /**
     * 删除会员收货地址
     */
    @RequiresPermissions("member:memberReceiveAddress:remove")
    @Log(title = "会员收货地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(memberReceiveAddressService.deleteMemberReceiveAddressByIds(ids));
    }
}
