package com.gulimall.coupon.api.factory;

import com.gulimall.coupon.api.RemoteCouponService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author gwoksing
 * @date 2022/8/30 15:19
 */
@Component
public class RemoteCouponFallbackFactory implements FallbackFactory<RemoteCouponService> {
    @Override
    public RemoteCouponService create(Throwable cause) {
        return null;
    }
}
