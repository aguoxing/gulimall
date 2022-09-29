package com.gulimall.common.core.bus.vo.ware;

import lombok.Data;

/**
 * @author: admin
 **/

@Data
public class PurchaseItemDoneVO {

    /**
     * 采购需求ID
     */
    private Long itemId;

    /**
     * 采购状态
     */
    private Integer status;

    /**
     * 原因
     */
    private String reason;

}
