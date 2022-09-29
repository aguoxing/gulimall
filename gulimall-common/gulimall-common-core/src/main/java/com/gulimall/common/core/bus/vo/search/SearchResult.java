package com.gulimall.common.core.bus.vo.search;

import com.gulimall.common.core.bus.to.es.SkuEsModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: admin
 */
@Data
public class SearchResult {

    /**
     * es检索到的所有商品信息
     */
    private List<SkuEsModel> products;

    /**
     * 分页信息
     * 当前页码
     */
    private Integer pageNum;
    /**
     * 总记录数
     */
    private Long total;
    /**
     * 总页码
     */
    private Integer totalPages;
    /**
     * 导航页码[1、2、3、4、5]
     */
    private List<Integer> pageNavs;

    /**
     * 当前查询到的结果所有涉及到的品牌
     */
    private List<BrandVo> brands;
    /**
     * 当前查询到的结果所有涉及到的分类
     */
    private List<CatalogVo> catalogs;
    /**
     * 当前查询到的结果所有涉及到的属性【符合检索条件的，可检索的属性】
     */
    private List<AttrVo> attrs = new ArrayList<>();//


    // ============================以上是要返回的数据====================================

    /**
     * 面包屑导航数据
     */
    private List<NavVo> navs = new ArrayList<>();

    /**
     * 封装筛选条件中的属性id集合【用于面包屑，选择属性后出现在面包屑中，下面的属性栏则隐藏】
     * 该字段是提供前端用的
     */
    private List<Long> attrIds = new ArrayList<>();


    /**
     * 面包屑导航VO
     */
    @Data
    public static class NavVo {
        /**
         * 属性名
         */
        private String navName;
        /**
         * 属性值
         */
        private String navValue;
        /**
         * 回退地址（删除该面包屑筛选条件回退地址）
         */
        private String link;
    }

    @Data
    public static class BrandVo {
        private Long brandId;
        private String brandName;
        private String brandImg;
    }

    @Data
    public static class CatalogVo {
        private Long catalogId;
        private String catalogName;
    }

    @Data
    public static class AttrVo {
        /**
         * 允许检索的 属性Id
         */
        private Long attrId;
        /**
         * 允许检索的 属性名
         */
        private String attrName;
        /**
         * 属性值【多个】
         */
        private List<String> attrValue;
    }
}
