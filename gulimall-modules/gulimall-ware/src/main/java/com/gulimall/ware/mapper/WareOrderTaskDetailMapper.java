package com.gulimall.ware.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.ware.domain.WareOrderTaskDetail;

/**
 * 库存工作单详情Mapper接口
 * 
 * @author admin
 * @date 2022-02-15
 */
public interface WareOrderTaskDetailMapper extends BaseMapper<WareOrderTaskDetail> {

    /**
     * 查询库存工作单详情列表
     * 
     * @param wareOrderTaskDetail 库存工作单详情
     * @return 库存工作单详情集合
     */
    List<WareOrderTaskDetail> selectWareOrderTaskDetailList(WareOrderTaskDetail wareOrderTaskDetail);

}
