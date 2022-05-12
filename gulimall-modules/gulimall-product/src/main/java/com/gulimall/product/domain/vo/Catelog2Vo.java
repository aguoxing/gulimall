package com.gulimall.product.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author gwoksing
 * @date 2022/5/11 8:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catelog2Vo {

    /**
     * 一级父分类的id
     */
    private String catalog1Id;

    /**
     * 三级子分类
     */
    private List<Category3Vo> catalog3List;

    private String id;

    private String name;

    /**
     * 三级分类vo
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Category3Vo {
        /**
         * 父分类、二级分类id
         */
        private String catalog2Id;

        private String id;

        private String name;
    }

}
