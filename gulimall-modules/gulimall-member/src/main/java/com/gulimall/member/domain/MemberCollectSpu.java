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
 * 会员收藏的商品对象 ums_member_collect_spu
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("ums_member_collect_spu")
public class MemberCollectSpu implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** 会员id */
    @Excel(name = "会员id")
    private Long memberId;

    /** spu_id */
    @Excel(name = "spu_id")
    private Long spuId;

    /** spu_name */
    @Excel(name = "spu_name")
    private String spuName;

    /** spu_img */
    @Excel(name = "spu_img")
    private String spuImg;

    /** create_time */
    private Date createTime;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
