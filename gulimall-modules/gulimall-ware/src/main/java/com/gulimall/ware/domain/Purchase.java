package com.gulimall.ware.domain;

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
 * 采购信息对象 wms_purchase
 *
 * @author admin
 * @date 2022-02-15
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("wms_purchase")
public class Purchase implements Serializable {
    private static final long serialVersionUID=1L;

    /** 采购单id */
    @TableId(value = "id")
    private Long id;

    /** 采购人id */
    @Excel(name = "采购人id")
    private Long assigneeId;

    /** 采购人名 */
    @Excel(name = "采购人名")
    private String assigneeName;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String phone;

    /** 优先级 */
    @Excel(name = "优先级")
    private Integer priority;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 仓库id */
    @Excel(name = "仓库id")
    private Long wareId;

    /** 总金额 */
    @Excel(name = "总金额")
    private BigDecimal amount;

    /** 创建日期 */
    private Date createTime;

    /** 更新日期 */
    private Date updateTime;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
