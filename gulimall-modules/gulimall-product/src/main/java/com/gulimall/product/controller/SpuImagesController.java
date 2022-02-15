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
import com.gulimall.product.domain.SpuImages;
import com.gulimall.product.service.ISpuImagesService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * spu图片Controller
 *
 * @author admin
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/spuImages")
public class SpuImagesController extends BaseController {
    @Autowired
    private ISpuImagesService spuImagesService;

    /**
     * 查询spu图片列表
     */
    @RequiresPermissions("product:spuImages:list")
    @GetMapping("/list")
    public TableDataInfo list(SpuImages spuImages) {
        startPage();
        List<SpuImages> list = spuImagesService.selectSpuImagesList(spuImages);
        return getDataTable(list);
    }

    /**
     * 导出spu图片列表
     */
    @RequiresPermissions("product:spuImages:export")
    @Log(title = "spu图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SpuImages spuImages) {
        List<SpuImages> list = spuImagesService.selectSpuImagesList(spuImages);
        ExcelUtil<SpuImages> util = new ExcelUtil<SpuImages>(SpuImages.class);
        util.exportExcel(response, list, "spu图片数据");
    }

    /**
     * 获取spu图片详细信息
     */
    @RequiresPermissions("product:spuImages:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(spuImagesService.selectSpuImagesById(id));
    }

    /**
     * 新增spu图片
     */
    @RequiresPermissions("product:spuImages:add")
    @Log(title = "spu图片", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SpuImages spuImages) {
        return toAjax(spuImagesService.insertSpuImages(spuImages));
    }

    /**
     * 修改spu图片
     */
    @RequiresPermissions("product:spuImages:edit")
    @Log(title = "spu图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SpuImages spuImages) {
        return toAjax(spuImagesService.updateSpuImages(spuImages));
    }

    /**
     * 删除spu图片
     */
    @RequiresPermissions("product:spuImages:remove")
    @Log(title = "spu图片", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(spuImagesService.deleteSpuImagesByIds(ids));
    }
}
