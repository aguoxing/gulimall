package com.gulimall.product.controller;

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
import com.gulimall.product.domain.CommentReplay;
import com.gulimall.product.service.ICommentReplayService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 商品评价回复关系Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/replay")
public class CommentReplayController extends BaseController {
    @Autowired
    private ICommentReplayService commentReplayService;

    /**
     * 查询商品评价回复关系列表
     */
    @RequiresPermissions("product:replay:list")
    @GetMapping("/list")
    public TableDataInfo list(CommentReplay commentReplay) {
        startPage();
        List<CommentReplay> list = commentReplayService.selectCommentReplayList(commentReplay);
        return getDataTable(list);
    }

    /**
     * 导出商品评价回复关系列表
     */
    @RequiresPermissions("product:replay:export")
    @Log(title = "商品评价回复关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CommentReplay commentReplay) {
        List<CommentReplay> list = commentReplayService.selectCommentReplayList(commentReplay);
        ExcelUtil<CommentReplay> util = new ExcelUtil<CommentReplay>(CommentReplay.class);
        util.exportExcel(response, list, "商品评价回复关系数据");
    }

    /**
     * 获取商品评价回复关系详细信息
     */
    @RequiresPermissions("product:replay:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(commentReplayService.selectCommentReplayById(id));
    }

    /**
     * 新增商品评价回复关系
     */
    @RequiresPermissions("product:replay:add")
    @Log(title = "商品评价回复关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CommentReplay commentReplay) {
        return toAjax(commentReplayService.insertCommentReplay(commentReplay));
    }

    /**
     * 修改商品评价回复关系
     */
    @RequiresPermissions("product:replay:edit")
    @Log(title = "商品评价回复关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CommentReplay commentReplay) {
        return toAjax(commentReplayService.updateCommentReplay(commentReplay));
    }

    /**
     * 删除商品评价回复关系
     */
    @RequiresPermissions("product:replay:remove")
    @Log(title = "商品评价回复关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(commentReplayService.deleteCommentReplayByIds(ids));
    }
}
