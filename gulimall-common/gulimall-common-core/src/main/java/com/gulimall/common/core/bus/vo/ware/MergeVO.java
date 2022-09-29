package com.gulimall.common.core.bus.vo.ware;

import lombok.Data;

import java.util.List;

/**
 * @author: admin
 **/

@Data
public class MergeVO {

    /**
     * 采购单ID
     */
    private Long purchaseId;
    /**
     * 采购需求ID
     */
    private List<Long> items;

}
