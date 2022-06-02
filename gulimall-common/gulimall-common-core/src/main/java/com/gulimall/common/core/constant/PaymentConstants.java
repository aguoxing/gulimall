package com.gulimall.common.core.constant;

/**
 * @author gwoksing
 * @date 2022/6/2 15:12
 */
public class PaymentConstants {
    public enum PayType {
        PAYPAL(101, "paypalStrategy"),
        PAYPAL_HK(102, "paypalHKStrategy"),
        PAYPAL_GLOB(103, "paypalGlobalStrategy"),
        ALI_PAY(201, "aliPayStrategy"),
        ALI_PAY_HK(202, "aliPayHKStrategy"),
        ALI_PAY_GLOB(203, "aliPayGlobalStrategy"),
        WECHAT_PAY(301, "weChatPayStrategy"),
        WECHAT_PAY_HK(302, "weChatPayHKStrategy"),
        WECHAT_PAY_GLOB(303, "weChatPayGlobalStrategy"),
        BANK(401, "bankPayStrategy"),
        FACE_PAY(501, "bankPayStrategy"),
        ;

        private Integer code;
        private String strategyBeanId;

        PayType(int code, String strategyBeanId) {
            this.code = code;
            this.strategyBeanId = strategyBeanId;
        }

        public static PayType getByCode(Integer code) {
            for (PayType em : values()) {
                if (em.getCode().equals(code)) {
                    return em;
                }
            }
            return null;
        }

        public static boolean isValid(Integer code) {
            if (code == null) {
                return false;
            }
            for (PayType type : values()) {
                if (type.code.equals(code)) {
                    return true;
                }
            }
            return false;
        }

        public Integer getCode() {
            return this.code;
        }

        public String getStrategyBeanId() {
            return this.strategyBeanId;
        }

    }
}
