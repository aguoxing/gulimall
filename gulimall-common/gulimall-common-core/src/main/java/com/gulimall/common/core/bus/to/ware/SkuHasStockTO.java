package com.gulimall.common.core.bus.to.ware;

import lombok.Data;

/**
 * @author admin
 */
@Data
public class SkuHasStockTO {
    private Long skuId;
    private Boolean hasStock;
}
