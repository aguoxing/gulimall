package com.gulimall.order.pay.wechatpay;

import com.alipay.api.AlipayApiException;
import com.gulimall.order.domain.dto.PayDTO;
import com.gulimall.order.domain.vo.PayAsyncVO;
import com.gulimall.order.pay.PayStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gwoksing
 * @date 2022/6/2 16:25
 */
@Component
public class WeChatPayStrategy implements PayStrategy {
    @Override
    public String pay(PayDTO order) throws Exception {
        return null;
    }

    @Override
    public Boolean notify(HttpServletRequest request, PayAsyncVO asyncVo) throws AlipayApiException {
        return null;
    }
}
