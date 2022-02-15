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
import com.gulimall.member.domain.MemberCollectSpu;
import com.gulimall.member.service.IMemberCollectSpuService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 会员收藏的商品Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/memberCollectSpu")
public class MemberCollectSpuController extends BaseController {
    @Autowired
    private IMemberCollectSpuService memberCollectSpuService;

    /**
     * 查询会员收藏的商品列表
     */
    @RequiresPermissions("member:memberCollectSpu:list")
    @GetMapping("/list")
    public TableDataInfo list(MemberCollectSpu memberCollectSpu) {
        startPage();
        List<MemberCollectSpu> list = memberCollectSpuService.selectMemberCollectSpuList(memberCollectSpu);
        return getDataTable(list);
    }

    /**
     * 导出会员收藏的商品列表
     */
    @RequiresPermissions("member:memberCollectSpu:export")
    @Log(title = "会员收藏的商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MemberCollectSpu memberCollectSpu) {
        List<MemberCollectSpu> list = memberCollectSpuService.selectMemberCollectSpuList(memberCollectSpu);
        ExcelUtil<MemberCollectSpu> util = new ExcelUtil<MemberCollectSpu>(MemberCollectSpu.class);
        util.exportExcel(response, list, "会员收藏的商品数据");
    }

    /**
     * 获取会员收藏的商品详细信息
     */
    @RequiresPermissions("member:memberCollectSpu:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(memberCollectSpuService.selectMemberCollectSpuById(id));
    }

    /**
     * 新增会员收藏的商品
     */
    @RequiresPermissions("member:memberCollectSpu:add")
    @Log(title = "会员收藏的商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MemberCollectSpu memberCollectSpu) {
        return toAjax(memberCollectSpuService.insertMemberCollectSpu(memberCollectSpu));
    }

    /**
     * 修改会员收藏的商品
     */
    @RequiresPermissions("member:memberCollectSpu:edit")
    @Log(title = "会员收藏的商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MemberCollectSpu memberCollectSpu) {
        return toAjax(memberCollectSpuService.updateMemberCollectSpu(memberCollectSpu));
    }

    /**
     * 删除会员收藏的商品
     */
    @RequiresPermissions("member:memberCollectSpu:remove")
    @Log(title = "会员收藏的商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(memberCollectSpuService.deleteMemberCollectSpuByIds(ids));
    }
}
