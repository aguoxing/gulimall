package com.gulimall.order.pay.alipay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.gulimall.order.domain.AlipayConfig;
import com.gulimall.order.domain.dto.PayDTO;
import com.gulimall.order.domain.vo.PayAsyncVO;
import com.gulimall.order.mapper.AlipayConfigMapper;
import com.gulimall.order.pay.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gwoksing
 * @date 2022/6/2 13:56
 */
@Service
public class AlipayServiceImpl implements PayService {
    @Autowired
    private AlipayConfigMapper alipayConfigMapper;

    @Override
    public String pay(PayDTO order) throws AlipayApiException {
        AlipayConfig alipayConfig = alipayConfigMapper.selectById("1");

        AlipayClient alipayClient = new DefaultAlipayClient(
                alipayConfig.getGatewayUrl(),
                alipayConfig.getAppId(),
                alipayConfig.getPrivateKey(),
                alipayConfig.getFormat(),
                alipayConfig.getCharset(),
                alipayConfig.getPublicKey(),
                alipayConfig.getSignType()
        );
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setNotifyUrl(alipayConfig.getNotifyUrl());
        request.setReturnUrl(alipayConfig.getReturnUrl());
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", order.getOut_trade_no());
        bizContent.put("total_amount", order.getTotal_amount());
        bizContent.put("subject", order.getSubject());
        bizContent.put("product_code", order.getProduct_code());
        //bizContent.put("time_expire", "2022-08-01 22:00:00");

        //// 商品明细信息，按需传入
        //JSONArray goodsDetail = new JSONArray();
        //JSONObject goods1 = new JSONObject();
        //goods1.put("goods_id", "goodsNo1");
        //goods1.put("goods_name", "子商品1");
        //goods1.put("quantity", 1);
        //goods1.put("price", 0.01);
        //goodsDetail.add(goods1);
        //bizContent.put("goods_detail", goodsDetail);

        //// 扩展信息，按需传入
        //JSONObject extendParams = new JSONObject();
        //extendParams.put("sys_service_provider_id", "2088511833207846");
        //bizContent.put("extend_params", extendParams);

        request.setBizContent(bizContent.toString());
        AlipayTradePagePayResponse response = alipayClient.pageExecute(request);
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return response.getBody();
    }

    @Override
    public Boolean verify(HttpServletRequest request) throws AlipayApiException {
        return null;
    }

    @Override
    public void handlePayResult(PayAsyncVO asyncVo) {

    }

}
