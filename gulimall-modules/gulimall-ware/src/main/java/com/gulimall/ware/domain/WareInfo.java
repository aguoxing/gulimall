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
 * 仓库信息对象 wms_ware_info
 *
 * @author admin
 * @date 2022-02-15
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("wms_ware_info")
public class WareInfo implements Serializable {
    private static final long serialVersionUID=1L;

    /** id */
    @TableId(value = "id")
    private Long id;

    /** 仓库名 */
    @Excel(name = "仓库名")
    private String name;

    /** 仓库地址 */
    @Excel(name = "仓库地址")
    private String address;

    /** 区域编码 */
    @Excel(name = "区域编码")
    private String areacode;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
