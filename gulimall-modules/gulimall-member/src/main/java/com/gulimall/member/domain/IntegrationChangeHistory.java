package com.gulimall.member.domain;

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
 * 积分变化历史记录对象 ums_integration_change_history
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("ums_integration_change_history")
public class IntegrationChangeHistory implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** member_id */
    @Excel(name = "member_id")
    private Long memberId;

    /** create_time */
    private Date createTime;

    /** 变化的值 */
    @Excel(name = "变化的值")
    private Long changeCount;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 来源[0-&gt;购物；1-&gt;管理员修改;2-&gt;活动] */
    @Excel(name = "来源[0-&gt;购物；1-&gt;管理员修改;2-&gt;活动]")
    private Integer sourceTyoe;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
