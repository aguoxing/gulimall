package com.gulimall.product.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gulimall.common.core.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 商品评价对象 pms_spu_comment
 *
 * @author admin
 * @date 2022-02-14
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("pms_spu_comment")
public class SpuComment implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * sku_id
     */
    @Excel(name = "sku_id")
    private Long skuId;

    /**
     * spu_id
     */
    @Excel(name = "spu_id")
    private Long spuId;

    /**
     * 商品名字
     */
    @Excel(name = "商品名字")
    private String spuName;

    /**
     * 会员昵称
     */
    @Excel(name = "会员昵称")
    private String memberNickName;

    /**
     * 星级
     */
    @Excel(name = "星级")
    private Integer star;

    /**
     * 会员ip
     */
    @Excel(name = "会员ip")
    private String memberIp;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 显示状态[0-不显示，1-显示]
     */
    @Excel(name = "显示状态[0-不显示，1-显示]")
    private Integer showStatus;

    /**
     * 购买时属性组合
     */
    @Excel(name = "购买时属性组合")
    private String spuAttributes;

    /**
     * 点赞数
     */
    @Excel(name = "点赞数")
    private Long likesCount;

    /**
     * 回复数
     */
    @Excel(name = "回复数")
    private Long replyCount;

    /**
     * 评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]
     */
    @Excel(name = "评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]")
    private String resources;

    /**
     * 内容
     */
    @Excel(name = "内容")
    private String content;

    /**
     * 用户头像
     */
    @Excel(name = "用户头像")
    private String memberIcon;

    /**
     * 评论类型[0 - 对商品的直接评论，1 - 对评论的回复]
     */
    @Excel(name = "评论类型[0 - 对商品的直接评论，1 - 对评论的回复]")
    private Integer commentType;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
