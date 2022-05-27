package com.gulimall.product.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author gwoksing
 * @date 2022/5/27 15:14
 */
@Data
public class AttrGroupRelationDTO implements Serializable {
    private Long attrGroupId;
    private List<Long> attrIds;
}
