package com.gulimall.ware.service;

import java.util.List;
import com.gulimall.ware.domain.WareOrderTask;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 库存工作单Service接口
 * 
 * @author admin
 * @date 2022-02-15
 */
public interface IWareOrderTaskService extends IService<WareOrderTask> {
    /**
     * 查询库存工作单
     *
     * @param id 库存工作单主键
     * @return 库存工作单
     */
    WareOrderTask selectWareOrderTaskById(Long id);

    /**
     * 查询库存工作单列表
     * 
     * @param wareOrderTask 库存工作单
     * @return 库存工作单集合
     */
    List<WareOrderTask> selectWareOrderTaskList(WareOrderTask wareOrderTask);

    /**
     * 新增库存工作单
     * 
     * @param wareOrderTask 库存工作单
     * @return 结果
     */
    int insertWareOrderTask(WareOrderTask wareOrderTask);

    /**
     * 修改库存工作单
     * 
     * @param wareOrderTask 库存工作单
     * @return 结果
     */
    int updateWareOrderTask(WareOrderTask wareOrderTask);

    /**
     * 批量删除库存工作单
     * 
     * @param ids 需要删除的库存工作单主键集合
     * @return 结果
     */
    int deleteWareOrderTaskByIds(Long[] ids);

}
