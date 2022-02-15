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
 * 首页专题对象 sms_home_subject
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sms_home_subject")
public class HomeSubject implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** 专题名字 */
    @Excel(name = "专题名字")
    private String name;

    /** 专题标题 */
    @Excel(name = "专题标题")
    private String title;

    /** 专题副标题 */
    @Excel(name = "专题副标题")
    private String subTitle;

    /** 显示状态 */
    @Excel(name = "显示状态")
    private Integer status;

    /** 详情连接 */
    @Excel(name = "详情连接")
    private String url;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 专题图片地址 */
    @Excel(name = "专题图片地址")
    private String img;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
