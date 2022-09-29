package com.gulimall.common.core.bus.vo.product;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author: admin
 */
@Data
@ToString
public class SpuItemAttrGroupVO {
    private String groupName;
    private List<Attr> attrs;
}
