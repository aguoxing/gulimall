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
 * 会员收藏的专题活动对象 ums_member_collect_subject
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("ums_member_collect_subject")
public class MemberCollectSubject implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** subject_id */
    @Excel(name = "subject_id")
    private Long subjectId;

    /** subject_name */
    @Excel(name = "subject_name")
    private String subjectName;

    /** subject_img */
    @Excel(name = "subject_img")
    private String subjectImg;

    /** 活动url */
    @Excel(name = "活动url")
    private String subjectUrll;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
