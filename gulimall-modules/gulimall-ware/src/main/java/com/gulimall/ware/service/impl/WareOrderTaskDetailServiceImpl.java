package com.gulimall.ware.service.impl;

import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.ware.mapper.WareOrderTaskDetailMapper;
import com.gulimall.ware.domain.WareOrderTaskDetail;
import com.gulimall.ware.service.IWareOrderTaskDetailService;

/**
 * 库存工作单详情Service业务层处理
 * 
 * @author admin
 * @date 2022-02-15
 */
@Service
public class WareOrderTaskDetailServiceImpl extends ServiceImpl<WareOrderTaskDetailMapper, WareOrderTaskDetail> implements IWareOrderTaskDetailService {
    @Autowired
    private WareOrderTaskDetailMapper wareOrderTaskDetailMapper;

    /**
     * 查询库存工作单详情
     * 
     * @param id 库存工作单详情主键
     * @return 库存工作单详情
     */
    @Override
    public WareOrderTaskDetail selectWareOrderTaskDetailById(Long id) {
        return wareOrderTaskDetailMapper.selectById(id);
    }

    /**
     * 查询库存工作单详情列表
     * 
     * @param wareOrderTaskDetail 库存工作单详情
     * @return 库存工作单详情
     */
    @Override
    public List<WareOrderTaskDetail> selectWareOrderTaskDetailList(WareOrderTaskDetail wareOrderTaskDetail) {
        return wareOrderTaskDetailMapper.selectWareOrderTaskDetailList(wareOrderTaskDetail);
    }

    /**
     * 新增库存工作单详情
     * 
     * @param wareOrderTaskDetail 库存工作单详情
     * @return 结果
     */
    @Override
    public int insertWareOrderTaskDetail(WareOrderTaskDetail wareOrderTaskDetail) {
        return wareOrderTaskDetailMapper.insert(wareOrderTaskDetail);
    }

    /**
     * 修改库存工作单详情
     * 
     * @param wareOrderTaskDetail 库存工作单详情
     * @return 结果
     */
    @Override
    public int updateWareOrderTaskDetail(WareOrderTaskDetail wareOrderTaskDetail) {
        return wareOrderTaskDetailMapper.updateById(wareOrderTaskDetail);
    }

    /**
     * 批量删除库存工作单详情
     * 
     * @param ids 需要删除的库存工作单详情主键
     * @return 结果
     */
    @Override
    public int deleteWareOrderTaskDetailByIds(Long[] ids) {
        return wareOrderTaskDetailMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
