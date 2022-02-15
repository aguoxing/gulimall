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
 * 专题商品对象 sms_home_subject_spu
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sms_home_subject_spu")
public class HomeSubjectSpu implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** 专题名字 */
    @Excel(name = "专题名字")
    private String name;

    /** 专题id */
    @Excel(name = "专题id")
    private Long subjectId;

    /** spu_id */
    @Excel(name = "spu_id")
    private Long spuId;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
