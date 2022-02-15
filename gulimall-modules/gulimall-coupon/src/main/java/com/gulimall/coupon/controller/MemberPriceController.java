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
import com.gulimall.coupon.domain.MemberPrice;
import com.gulimall.coupon.service.IMemberPriceService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 商品会员价格Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/memberPrice")
public class MemberPriceController extends BaseController {
    @Autowired
    private IMemberPriceService memberPriceService;

    /**
     * 查询商品会员价格列表
     */
    @RequiresPermissions("coupon:memberPrice:list")
    @GetMapping("/list")
    public TableDataInfo list(MemberPrice memberPrice) {
        startPage();
        List<MemberPrice> list = memberPriceService.selectMemberPriceList(memberPrice);
        return getDataTable(list);
    }

    /**
     * 导出商品会员价格列表
     */
    @RequiresPermissions("coupon:memberPrice:export")
    @Log(title = "商品会员价格", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MemberPrice memberPrice) {
        List<MemberPrice> list = memberPriceService.selectMemberPriceList(memberPrice);
        ExcelUtil<MemberPrice> util = new ExcelUtil<MemberPrice>(MemberPrice.class);
        util.exportExcel(response, list, "商品会员价格数据");
    }

    /**
     * 获取商品会员价格详细信息
     */
    @RequiresPermissions("coupon:memberPrice:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(memberPriceService.selectMemberPriceById(id));
    }

    /**
     * 新增商品会员价格
     */
    @RequiresPermissions("coupon:memberPrice:add")
    @Log(title = "商品会员价格", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MemberPrice memberPrice) {
        return toAjax(memberPriceService.insertMemberPrice(memberPrice));
    }

    /**
     * 修改商品会员价格
     */
    @RequiresPermissions("coupon:memberPrice:edit")
    @Log(title = "商品会员价格", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MemberPrice memberPrice) {
        return toAjax(memberPriceService.updateMemberPrice(memberPrice));
    }

    /**
     * 删除商品会员价格
     */
    @RequiresPermissions("coupon:memberPrice:remove")
    @Log(title = "商品会员价格", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(memberPriceService.deleteMemberPriceByIds(ids));
    }
}
