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
 * 会员等级对象 ums_member_level
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("ums_member_level")
public class MemberLevel implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** 等级名称 */
    @Excel(name = "等级名称")
    private String name;

    /** 等级需要的成长值 */
    @Excel(name = "等级需要的成长值")
    private Long growthPoint;

    /** 是否为默认等级[0-&gt;不是；1-&gt;是] */
    @Excel(name = "是否为默认等级[0-&gt;不是；1-&gt;是]")
    private Integer defaultStatus;

    /** 免运费标准 */
    @Excel(name = "免运费标准")
    private BigDecimal freeFreightPoint;

    /** 每次评价获取的成长值 */
    @Excel(name = "每次评价获取的成长值")
    private Long commentGrowthPoint;

    /** 是否有免邮特权 */
    @Excel(name = "是否有免邮特权")
    private Integer priviledgeFreeFreight;

    /** 是否有会员价格特权 */
    @Excel(name = "是否有会员价格特权")
    private Integer priviledgeMemberPrice;

    /** 是否有生日特权 */
    @Excel(name = "是否有生日特权")
    private Integer priviledgeBirthday;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
