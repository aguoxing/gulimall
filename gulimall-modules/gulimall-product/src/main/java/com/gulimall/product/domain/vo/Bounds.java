package com.gulimall.product.domain.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author gwoksing
 * @date 2022/5/11 8:44
 */
@Data
public class Bounds {

    private BigDecimal buyBounds;
    private BigDecimal growBounds;

}