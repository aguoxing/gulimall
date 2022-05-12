package com.gulimall.product.web;

import com.gulimall.product.domain.Category;
import com.gulimall.product.domain.vo.Catelog2Vo;
import com.gulimall.product.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author gx
 * @date 2022/2/14 16:04
 */
@Controller
public class IndexController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = {"/", "index.html"})
    private String indexPage(Model model) {
        // 1、查出所有的一级分类
        List<Category> categoryEntities = categoryService.getLevel1CategoryList();
        model.addAttribute("categories", categoryEntities);
        return "index";
    }

    @GetMapping(value = "/index/catalog.json")
    @ResponseBody
    public Map<String, List<Catelog2Vo>> getCatalogJson() {
        return categoryService.getCatalogJson();
    }
}
