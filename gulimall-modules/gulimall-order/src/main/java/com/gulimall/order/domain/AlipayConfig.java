package com.gulimall.order.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gulimall.common.core.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 支付宝配置类对象 oms_alipay_config
 *
 * @author admin
 * @date 2022-06-02
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("oms_alipay_config")
public class AlipayConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "config_id")
    private String configId;

    /**
     * 商户号
     */
    @Excel(name = "商户号")
    private String sysServiceProviderId;

    /**
     * 应用ID
     */
    @Excel(name = "应用ID")
    private String appId;

    /**
     * 编码
     */
    @Excel(name = "编码")
    private String charset;

    /**
     * 类型 固定格式json
     */
    @Excel(name = "类型 固定格式json")
    private String format;

    /**
     * 网关地址
     */
    @Excel(name = "网关地址")
    private String gatewayUrl;

    /**
     * 异步回调
     */
    @Excel(name = "异步回调")
    private String notifyUrl;

    /**
     * 私钥
     */
    @Excel(name = "私钥")
    private String privateKey;

    /**
     * 公钥
     */
    @Excel(name = "公钥")
    private String publicKey;

    /**
     * 回调地址
     */
    @Excel(name = "回调地址")
    private String returnUrl;

    /**
     * 签名方式
     */
    @Excel(name = "签名方式")
    private String signType;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
