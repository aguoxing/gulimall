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
 * 会员登录记录对象 ums_member_login_log
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("ums_member_login_log")
public class MemberLoginLog implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** member_id */
    @Excel(name = "member_id")
    private Long memberId;

    /** 创建时间 */
    private Date createTime;

    /** ip */
    @Excel(name = "ip")
    private String ip;

    /** city */
    @Excel(name = "city")
    private String city;

    /** 登录类型[1-web，2-app] */
    @Excel(name = "登录类型[1-web，2-app]")
    private Integer loginType;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
