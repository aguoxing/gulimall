package com.gulimall.order.controller;

import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.order.domain.dto.PayDTO;
import com.gulimall.order.pay.PayContextService;
import com.gulimall.order.pay.alipay.AlipayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gwoksing
 * @date 2022/6/2 14:14
 */
@Controller
public class WebPayController extends BaseController {

    @Autowired
    private PayContextService payContextService;
    @Autowired
    private AlipayServiceImpl alipayService;

    @ResponseBody
    @GetMapping("/pc/pay")
    public String pcPay(PayDTO order) throws Exception {
//        return payContextService.pay(PayType.getByCode(PayType.ALI_PAY.getCode()), order);
        return alipayService.pay(order);
    }

}
