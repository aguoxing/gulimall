package com.gulimall.order.pay;

import com.alipay.api.AlipayApiException;
import com.gulimall.order.domain.dto.PayDTO;
import com.gulimall.order.domain.vo.PayAsyncVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gwoksing
 * @date 2022/6/2 13:43
 */
public interface PayStrategy {

    /**
     * 创建交易付款
     *
     * @param order
     * @return
     * @throws Exception
     */
    String pay(PayDTO order) throws Exception;

    /**
     * 处理回调
     *
     * @param request
     * @param asyncVo
     * @return
     * @throws AlipayApiException
     */
    Boolean notify(HttpServletRequest request, PayAsyncVO asyncVo) throws AlipayApiException;
}
