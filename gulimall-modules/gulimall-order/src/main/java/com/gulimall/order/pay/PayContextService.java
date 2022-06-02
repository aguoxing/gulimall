package com.gulimall.order.pay;

import com.alipay.api.AlipayApiException;
import com.gulimall.common.core.SpringUtils2;
import com.gulimall.common.core.constant.PaymentConstants.PayType;
import com.gulimall.order.domain.dto.PayDTO;
import com.gulimall.order.domain.vo.PayAsyncVO;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gwoksing
 * @date 2022/6/2 13:38
 */
@Component
public class PayContextService {
    /**
     * 创建支付
     *
     * @param payType        策略类型
     * @param order          订单数据
     * @return
     */
    public String pay(PayType payType, PayDTO order) throws Exception {
        // 获取实际策略对象
        PayStrategy payStrategy = SpringUtils2.getBean(payType.getStrategyBeanId(), PayStrategy.class);
        // 执行具体策略
        return payStrategy.pay(order);
    }

    /**
     * 处理回调
     *
     * @param payType 策略类型
     * @param request 请求
     * @param asyncVo 回参VO
     * @return
     */
    public Boolean notify(PayType payType, HttpServletRequest request, PayAsyncVO asyncVo) throws AlipayApiException {
        // 获取实际策略对象
        PayStrategy payStrategy = SpringUtils2.getBean(payType.getStrategyBeanId(), PayStrategy.class);
        // 执行具体策略
        return payStrategy.notify(request, asyncVo);
    }
}
