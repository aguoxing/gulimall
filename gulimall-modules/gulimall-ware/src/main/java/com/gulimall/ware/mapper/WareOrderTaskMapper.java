package com.gulimall.ware.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.ware.domain.WareOrderTask;

/**
 * 库存工作单Mapper接口
 * 
 * @author admin
 * @date 2022-02-15
 */
public interface WareOrderTaskMapper extends BaseMapper<WareOrderTask> {

    /**
     * 查询库存工作单列表
     * 
     * @param wareOrderTask 库存工作单
     * @return 库存工作单集合
     */
    List<WareOrderTask> selectWareOrderTaskList(WareOrderTask wareOrderTask);

}
