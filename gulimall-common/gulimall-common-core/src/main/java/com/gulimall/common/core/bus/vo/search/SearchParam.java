package com.gulimall.common.core.bus.vo.search;

import lombok.Data;

import java.util.List;

/**
 * 封装页面所有可能传递过来的查询条件
 * 三种点击搜索的方式
 * 1、点击搜索：keyword   【skuTitle】
 * 2、点击分类：传catalog3Id【catalogld】
 * 3、选择筛选条件
 * 1、全文检索: keyword【skuTitle】
 * 2、排序: saleCount_asc【销量】、hotScore_asc【综合排序：热度评分】、skuPrice_asc【价格】
 * 3、过滤: hasStock、skuPrice区间、brandld、catalog3ld、attrs
 * 4、聚合: attrs
 * attrs=2_5寸 传参格式，所以直接for循环split("_")就可以得到attrId与attrValue
 * attrs=1_白色:蓝色       然后值split(":")得到各项值attrValue
 */
@Data
public class SearchParam {

    /**
     * 页面传递过来的全文匹配关键字
     */
    private String keyword;
    /**
     * 三级分类的id
     */
    private Long catalog3Id;
    /**
     * 排序：sort=saleCount_asc  sort=hotScore_asc  sort=skuPrice_asc
     */
    private String sort;
    /**
     * 过滤条件：
     * hasStock=0/1【有货】
     * skuPrice=0_500/500_/_500【价格区间】
     * brandld=1
     * attrs=1_白色:蓝色&attrs=2_2寸:5寸【属性可多选，值也可多选】
     */
    /**
     * 是否只显示有货，默认显示所有，null == 1会NullPoint异常  0/1
     */
    private Integer hasStock;
    /**
     * 是否只显示有货
     */
    private String skuPrice;
    /**
     * 品牌id，可多选
     */
    private List<Long> brandId;
    /**
     * 三级分类id+属性值
     */
    private List<String> attrs;
    /**
     * 页码
     */
    private Integer pageNum = 1;

    /**
     * 原生的所有查询条件（来自url的请求参数），用于构建面包屑
     */
    private String _queryString;
}
