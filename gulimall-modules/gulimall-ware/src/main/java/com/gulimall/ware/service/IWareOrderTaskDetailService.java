package com.gulimall.ware.service;

import java.util.List;
import com.gulimall.ware.domain.WareOrderTaskDetail;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 库存工作单详情Service接口
 * 
 * @author admin
 * @date 2022-02-15
 */
public interface IWareOrderTaskDetailService extends IService<WareOrderTaskDetail> {
    /**
     * 查询库存工作单详情
     *
     * @param id 库存工作单详情主键
     * @return 库存工作单详情
     */
    WareOrderTaskDetail selectWareOrderTaskDetailById(Long id);

    /**
     * 查询库存工作单详情列表
     * 
     * @param wareOrderTaskDetail 库存工作单详情
     * @return 库存工作单详情集合
     */
    List<WareOrderTaskDetail> selectWareOrderTaskDetailList(WareOrderTaskDetail wareOrderTaskDetail);

    /**
     * 新增库存工作单详情
     * 
     * @param wareOrderTaskDetail 库存工作单详情
     * @return 结果
     */
    int insertWareOrderTaskDetail(WareOrderTaskDetail wareOrderTaskDetail);

    /**
     * 修改库存工作单详情
     * 
     * @param wareOrderTaskDetail 库存工作单详情
     * @return 结果
     */
    int updateWareOrderTaskDetail(WareOrderTaskDetail wareOrderTaskDetail);

    /**
     * 批量删除库存工作单详情
     * 
     * @param ids 需要删除的库存工作单详情主键集合
     * @return 结果
     */
    int deleteWareOrderTaskDetailByIds(Long[] ids);

}
