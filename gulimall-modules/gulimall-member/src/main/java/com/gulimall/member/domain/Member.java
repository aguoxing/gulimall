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
 * 会员对象 ums_member
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("ums_member")
public class Member implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** 会员等级id */
    @Excel(name = "会员等级id")
    private Long levelId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickname;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String mobile;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 头像 */
    @Excel(name = "头像")
    private String header;

    /** 性别 */
    @Excel(name = "性别")
    private Integer gender;

    /** 生日 */
    @Excel(name = "生日" , width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birth;

    /** 所在城市 */
    @Excel(name = "所在城市")
    private String city;

    /** 职业 */
    @Excel(name = "职业")
    private String job;

    /** 个性签名 */
    @Excel(name = "个性签名")
    private String sign;

    /** 用户来源 */
    @Excel(name = "用户来源")
    private Integer sourceType;

    /** 积分 */
    @Excel(name = "积分")
    private Long integration;

    /** 成长值 */
    @Excel(name = "成长值")
    private Long growth;

    /** 启用状态 */
    @Excel(name = "启用状态")
    private Integer status;

    /** 注册时间 */
    private Date createTime;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
