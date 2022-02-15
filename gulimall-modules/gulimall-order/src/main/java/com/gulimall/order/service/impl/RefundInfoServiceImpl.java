package com.gulimall.order.service.impl;

import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.order.mapper.RefundInfoMapper;
import com.gulimall.order.domain.RefundInfo;
import com.gulimall.order.service.IRefundInfoService;

/**
 * 退款信息Service业务层处理
 * 
 * @author admin
 * @date 2022-02-15
 */
@Service
public class RefundInfoServiceImpl extends ServiceImpl<RefundInfoMapper, RefundInfo> implements IRefundInfoService {
    @Autowired
    private RefundInfoMapper refundInfoMapper;

    /**
     * 查询退款信息
     * 
     * @param id 退款信息主键
     * @return 退款信息
     */
    @Override
    public RefundInfo selectRefundInfoById(Long id) {
        return refundInfoMapper.selectById(id);
    }

    /**
     * 查询退款信息列表
     * 
     * @param refundInfo 退款信息
     * @return 退款信息
     */
    @Override
    public List<RefundInfo> selectRefundInfoList(RefundInfo refundInfo) {
        return refundInfoMapper.selectRefundInfoList(refundInfo);
    }

    /**
     * 新增退款信息
     * 
     * @param refundInfo 退款信息
     * @return 结果
     */
    @Override
    public int insertRefundInfo(RefundInfo refundInfo) {
        return refundInfoMapper.insert(refundInfo);
    }

    /**
     * 修改退款信息
     * 
     * @param refundInfo 退款信息
     * @return 结果
     */
    @Override
    public int updateRefundInfo(RefundInfo refundInfo) {
        return refundInfoMapper.updateById(refundInfo);
    }

    /**
     * 批量删除退款信息
     * 
     * @param ids 需要删除的退款信息主键
     * @return 结果
     */
    @Override
    public int deleteRefundInfoByIds(Long[] ids) {
        return refundInfoMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
