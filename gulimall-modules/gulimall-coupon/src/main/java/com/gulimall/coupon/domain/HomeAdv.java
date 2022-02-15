package com.gulimall.coupon.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import com.gulimall.common.core.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

/**
 * 首页轮播广告对象 sms_home_adv
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sms_home_adv")
public class HomeAdv implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** 名字 */
    @Excel(name = "名字")
    private String name;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String pic;

    /** 开始时间 */
    @Excel(name = "开始时间" , width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /** 结束时间 */
    @Excel(name = "结束时间" , width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 点击数 */
    @Excel(name = "点击数")
    private Long clickCount;

    /** 广告详情连接地址 */
    @Excel(name = "广告详情连接地址")
    private String url;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 发布者 */
    @Excel(name = "发布者")
    private Long publisherId;

    /** 审核者 */
    @Excel(name = "审核者")
    private Long authId;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
