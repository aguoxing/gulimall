package com.gulimall.common.core.bus.vo.product;

import lombok.Data;

/**
 * @author: admin
 */
@Data
public class Attr {

    private Long attrId;
    private String attrName;
    private String attrValue;

    private Integer searchType;
    private Integer valueType;
    private String icon;
    private String valueSelect;
    private Integer attrType;
    private Long enable;
    private Long catelogId;
    private Integer showDesc;
}
