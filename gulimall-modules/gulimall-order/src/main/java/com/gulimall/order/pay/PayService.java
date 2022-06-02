package com.gulimall.order.pay;

import com.alipay.api.AlipayApiException;
import com.gulimall.order.domain.dto.PayDTO;
import com.gulimall.order.domain.vo.PayAsyncVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gwoksing
 * @date 2022/6/2 13:55
 */
public interface PayService {

    /**
     * 创建支付
     *
     * @param order
     * @return
     * @throws AlipayApiException
     */
    String pay(PayDTO order) throws AlipayApiException;

    /**
     * 验签
     *
     * @param request
     * @return
     * @throws AlipayApiException
     */
    Boolean verify(HttpServletRequest request) throws AlipayApiException;

    /**
     * 处理支付异步回调
     *
     * @param asyncVo
     */
    void handlePayResult(PayAsyncVO asyncVo);
}
