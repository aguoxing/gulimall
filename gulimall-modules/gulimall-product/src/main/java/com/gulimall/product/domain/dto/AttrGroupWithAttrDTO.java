package com.gulimall.product.domain.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author gwoksing
 * @date 2022/5/31 11:23
 */
@Data
@ToString
public class AttrGroupWithAttrDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 组名
     */
    private String attrGroupName;

    /**
     * 所属分类
     */
    private String categoryId;

    /**
     * 排序
     */
    private Long sort;

    /**
     * 描述
     */
    private String description;

    private List<AttrDTO> baseAttrInfoList;

    private List<AttrDTO> saleAttrInfoList;
}
