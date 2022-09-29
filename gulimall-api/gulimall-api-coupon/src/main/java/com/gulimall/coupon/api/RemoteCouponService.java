package com.gulimall.coupon.api;

import com.gulimall.common.core.constant.ServiceNameConstants;
import com.gulimall.coupon.api.factory.RemoteCouponFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 文件服务
 *
 * @author ruoyi
 */
@FeignClient(contextId = "RemoteCouponService", value = ServiceNameConstants.FILE_SERVICE, fallbackFactory = RemoteCouponFallbackFactory.class)
public interface RemoteCouponService {

}
