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
import com.gulimall.product.domain.SpuComment;
import com.gulimall.product.service.ISpuCommentService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 商品评价Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/spuComment")
public class SpuCommentController extends BaseController {
    @Autowired
    private ISpuCommentService spuCommentService;

    /**
     * 查询商品评价列表
     */
    @RequiresPermissions("product:spuComment:list")
    @GetMapping("/list")
    public TableDataInfo list(SpuComment spuComment) {
        startPage();
        List<SpuComment> list = spuCommentService.selectSpuCommentList(spuComment);
        return getDataTable(list);
    }

    /**
     * 导出商品评价列表
     */
    @RequiresPermissions("product:spuComment:export")
    @Log(title = "商品评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SpuComment spuComment) {
        List<SpuComment> list = spuCommentService.selectSpuCommentList(spuComment);
        ExcelUtil<SpuComment> util = new ExcelUtil<SpuComment>(SpuComment.class);
        util.exportExcel(response, list, "商品评价数据");
    }

    /**
     * 获取商品评价详细信息
     */
    @RequiresPermissions("product:spuComment:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(spuCommentService.selectSpuCommentById(id));
    }

    /**
     * 新增商品评价
     */
    @RequiresPermissions("product:spuComment:add")
    @Log(title = "商品评价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SpuComment spuComment) {
        return toAjax(spuCommentService.insertSpuComment(spuComment));
    }

    /**
     * 修改商品评价
     */
    @RequiresPermissions("product:spuComment:edit")
    @Log(title = "商品评价", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SpuComment spuComment) {
        return toAjax(spuCommentService.updateSpuComment(spuComment));
    }

    /**
     * 删除商品评价
     */
    @RequiresPermissions("product:spuComment:remove")
    @Log(title = "商品评价", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(spuCommentService.deleteSpuCommentByIds(ids));
    }
}
