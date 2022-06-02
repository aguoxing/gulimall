package com.gulimall.order.pay.wechatpay;

import com.alipay.api.AlipayApiException;
import com.gulimall.order.domain.dto.PayDTO;
import com.gulimall.order.domain.vo.PayAsyncVO;
import com.gulimall.order.pay.PayService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gwoksing
 * @date 2022/6/2 16:26
 */
@Service
public class WeChatPayServiceImpl implements PayService {
    @Override
    public String pay(PayDTO order) throws AlipayApiException {
        return null;
    }

    @Override
    public Boolean verify(HttpServletRequest request) throws AlipayApiException {
        return null;
    }

    @Override
    public void handlePayResult(PayAsyncVO asyncVo) {

    }
}
