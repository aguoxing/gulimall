package com.gulimall.common.core.bus.to.ware;

import com.gulimall.common.core.bus.vo.order.OrderItemVO;
import lombok.Data;

import java.util.List;

/**
 * @author admin
 * 锁定库存传输对象
 **/

@Data
public class WareSkuLockTO {
    private String orderSn;

    /**
     * 需要锁住的所有库存信息
     **/
    private List<OrderItemVO> locks;

}
