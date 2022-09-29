package com.gulimall.common.core.bus.vo.ware;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author: admin
 **/

@Data
public class PurchaseDoneVO {

    @NotNull(message = "id不允许为空")
    private Long id;// 采购单ID

    private List<PurchaseItemDoneVO> items;// 采购需求

}
