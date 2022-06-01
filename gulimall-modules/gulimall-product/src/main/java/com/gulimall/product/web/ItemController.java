package com.gulimall.product.web;

import com.gulimall.product.domain.vo.SkuItemVo;
import com.gulimall.product.service.ISkuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.ExecutionException;

/**
 * @author gx
 * @date 2022/2/14 16:05
 */
@Controller
public class ItemController {
    @Autowired
    private ISkuInfoService skuInfoService;

    /**
     * 展示当前sku的详情
     *
     * @param skuId
     * @return
     */
    @GetMapping("/{skuId}.html")
    public String skuItem(@PathVariable("skuId") String skuId, Model model) throws ExecutionException, InterruptedException {

        System.out.println("准备查询" + skuId + "详情");

        SkuItemVo vos = skuInfoService.item(skuId);

        model.addAttribute("item", vos);

        return "item";
    }
}
