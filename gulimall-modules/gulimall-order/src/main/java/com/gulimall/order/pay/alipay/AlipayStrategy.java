package com.gulimall.order.pay.alipay;

import com.alipay.api.AlipayApiException;
import com.gulimall.order.domain.dto.PayDTO;
import com.gulimall.order.domain.vo.PayAsyncVO;
import com.gulimall.order.pay.PayStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gwoksing
 * @date 2022/6/2 13:48
 */
@Component
public class AlipayStrategy implements PayStrategy {
    @Autowired
    private AlipayServiceImpl alipayService;

    @Override
    public String pay(PayDTO order) throws Exception {
        return alipayService.pay(order);
    }

    @Override
    public Boolean notify(HttpServletRequest request, PayAsyncVO asyncVo) throws AlipayApiException {
        return null;
    }
}
