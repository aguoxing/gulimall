package com.gulimall.product.domain.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gwoksing
 * @date 2022/5/11 8:44
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AttrRespVo extends AttrVo {
    /**
     * "catelogName": "手机/数码/手机", //所属分类名字
     * "groupName": "主体", //所属分组名字
     */
    private String catelogName;
    private String groupName;

    private Long[] catelogPath;
}
