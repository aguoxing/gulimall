package com.gulimall.ware.service.impl;

import java.util.Arrays;
import java.util.List;
import com.gulimall.common.core.utils.DateUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.ware.mapper.WareOrderTaskMapper;
import com.gulimall.ware.domain.WareOrderTask;
import com.gulimall.ware.service.IWareOrderTaskService;

/**
 * 库存工作单Service业务层处理
 * 
 * @author admin
 * @date 2022-02-15
 */
@Service
public class WareOrderTaskServiceImpl extends ServiceImpl<WareOrderTaskMapper, WareOrderTask> implements IWareOrderTaskService {
    @Autowired
    private WareOrderTaskMapper wareOrderTaskMapper;

    /**
     * 查询库存工作单
     * 
     * @param id 库存工作单主键
     * @return 库存工作单
     */
    @Override
    public WareOrderTask selectWareOrderTaskById(Long id) {
        return wareOrderTaskMapper.selectById(id);
    }

    /**
     * 查询库存工作单列表
     * 
     * @param wareOrderTask 库存工作单
     * @return 库存工作单
     */
    @Override
    public List<WareOrderTask> selectWareOrderTaskList(WareOrderTask wareOrderTask) {
        return wareOrderTaskMapper.selectWareOrderTaskList(wareOrderTask);
    }

    /**
     * 新增库存工作单
     * 
     * @param wareOrderTask 库存工作单
     * @return 结果
     */
    @Override
    public int insertWareOrderTask(WareOrderTask wareOrderTask) {
        wareOrderTask.setCreateTime(DateUtils.getNowDate());
        return wareOrderTaskMapper.insert(wareOrderTask);
    }

    /**
     * 修改库存工作单
     * 
     * @param wareOrderTask 库存工作单
     * @return 结果
     */
    @Override
    public int updateWareOrderTask(WareOrderTask wareOrderTask) {
        return wareOrderTaskMapper.updateById(wareOrderTask);
    }

    /**
     * 批量删除库存工作单
     * 
     * @param ids 需要删除的库存工作单主键
     * @return 结果
     */
    @Override
    public int deleteWareOrderTaskByIds(Long[] ids) {
        return wareOrderTaskMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
