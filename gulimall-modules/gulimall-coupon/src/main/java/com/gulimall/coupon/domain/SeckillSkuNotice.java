package com.gulimall.coupon.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gulimall.common.core.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 秒杀商品通知订阅对象 sms_seckill_sku_notice
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sms_seckill_sku_notice")
public class SeckillSkuNotice implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** member_id */
    @Excel(name = "member_id")
    private Long memberId;

    /** sku_id */
    @Excel(name = "sku_id")
    private String skuId;

    /** 活动场次id */
    @Excel(name = "活动场次id")
    private Long sessionId;

    /** 订阅时间 */
    @Excel(name = "订阅时间" , width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date subcribeTime;

    /** 发送时间 */
    @Excel(name = "发送时间" , width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendTime;

    /** 通知方式[0-短信，1-邮件] */
    @Excel(name = "通知方式[0-短信，1-邮件]")
    private Integer noticeType;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
