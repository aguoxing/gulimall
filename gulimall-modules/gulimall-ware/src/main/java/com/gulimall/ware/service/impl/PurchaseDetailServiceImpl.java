package com.gulimall.ware.service.impl;

import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.ware.mapper.PurchaseDetailMapper;
import com.gulimall.ware.domain.PurchaseDetail;
import com.gulimall.ware.service.IPurchaseDetailService;

/**
 * 采购信息详情Service业务层处理
 * 
 * @author admin
 * @date 2022-02-15
 */
@Service
public class PurchaseDetailServiceImpl extends ServiceImpl<PurchaseDetailMapper, PurchaseDetail> implements IPurchaseDetailService {
    @Autowired
    private PurchaseDetailMapper purchaseDetailMapper;

    /**
     * 查询采购信息详情
     * 
     * @param id 采购信息详情主键
     * @return 采购信息详情
     */
    @Override
    public PurchaseDetail selectPurchaseDetailById(Long id) {
        return purchaseDetailMapper.selectById(id);
    }

    /**
     * 查询采购信息详情列表
     * 
     * @param purchaseDetail 采购信息详情
     * @return 采购信息详情
     */
    @Override
    public List<PurchaseDetail> selectPurchaseDetailList(PurchaseDetail purchaseDetail) {
        return purchaseDetailMapper.selectPurchaseDetailList(purchaseDetail);
    }

    /**
     * 新增采购信息详情
     * 
     * @param purchaseDetail 采购信息详情
     * @return 结果
     */
    @Override
    public int insertPurchaseDetail(PurchaseDetail purchaseDetail) {
        return purchaseDetailMapper.insert(purchaseDetail);
    }

    /**
     * 修改采购信息详情
     * 
     * @param purchaseDetail 采购信息详情
     * @return 结果
     */
    @Override
    public int updatePurchaseDetail(PurchaseDetail purchaseDetail) {
        return purchaseDetailMapper.updateById(purchaseDetail);
    }

    /**
     * 批量删除采购信息详情
     * 
     * @param ids 需要删除的采购信息详情主键
     * @return 结果
     */
    @Override
    public int deletePurchaseDetailByIds(Long[] ids) {
        return purchaseDetailMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
