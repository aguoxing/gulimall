package com.gulimall.common.core.bus.vo.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author: admin
 * 2级分类VO
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Catalog2VO implements Serializable {
    private static final long serialVersionUID = -1L;

    /**
     * 1级父分类ID
     */
    private String catalog1Id;
    /**
     * 3级子分类集合
     */
    private List<Catalog3Vo> catalog3List;
    /**
     * 2级分类ID
     */
    private String id;
    /**
     * 2级分类name
     */
    private String name;

    /**
     * 三级分类Vo
     */
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Catalog3Vo implements Serializable {
        private static final long serialVersionUID = -1L;

        /**
         * 2级父分类ID
         */
        private String catalog2Id;
        /**
         * 3级分类ID
         */
        private String id;
        /**
         * 3级分类name
         */
        private String name;
    }
}
