package com.gulimall.common.core.bus.vo.product;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: admin
 */
@Data
public class MemberPrice {

    private Long id;
    private String name;
    private BigDecimal price;

}
