package com.gulimall.common.core.enums;

/**
 * @author gwoksing
 * @date 2022/6/1 8:48
 */
public enum ProductEnum {
    SHANGJIA("1", "上架"),
    XIAJIA("0", "下架"),

    ;

    private final String code;
    private final String info;

    ProductEnum(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
