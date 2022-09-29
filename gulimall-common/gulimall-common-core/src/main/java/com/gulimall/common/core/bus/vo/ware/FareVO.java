package com.gulimall.common.core.bus.vo.ware;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: admin
 **/

@Data
public class FareVO {
    private MemberAddressVO address;
    private BigDecimal fare;
}


