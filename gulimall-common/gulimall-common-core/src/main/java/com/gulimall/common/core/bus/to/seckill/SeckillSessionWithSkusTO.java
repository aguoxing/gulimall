package com.gulimall.common.core.bus.to.seckill;

import com.gulimall.common.core.bus.vo.product.SeckillSkuVO;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author admin
 * 秒杀场次信息
 **/

@Data
public class SeckillSessionWithSkusTO {

    private Long id;
    /**
     * 场次名称
     */
    private String name;
    /**
     * 每日开始时间
     */
    private Date startTime;
    /**
     * 每日结束时间
     */
    private Date endTime;
    /**
     * 启用状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;

    private List<SeckillSkuVO> relationSkus;

}
