package com.gulimall.ware.service.impl;

import java.util.Arrays;
import java.util.List;
import com.gulimall.common.core.utils.DateUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.ware.mapper.PurchaseMapper;
import com.gulimall.ware.domain.Purchase;
import com.gulimall.ware.service.IPurchaseService;

/**
 * 采购信息Service业务层处理
 * 
 * @author admin
 * @date 2022-02-15
 */
@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements IPurchaseService {
    @Autowired
    private PurchaseMapper purchaseMapper;

    /**
     * 查询采购信息
     * 
     * @param id 采购信息主键
     * @return 采购信息
     */
    @Override
    public Purchase selectPurchaseById(Long id) {
        return purchaseMapper.selectById(id);
    }

    /**
     * 查询采购信息列表
     * 
     * @param purchase 采购信息
     * @return 采购信息
     */
    @Override
    public List<Purchase> selectPurchaseList(Purchase purchase) {
        return purchaseMapper.selectPurchaseList(purchase);
    }

    /**
     * 新增采购信息
     * 
     * @param purchase 采购信息
     * @return 结果
     */
    @Override
    public int insertPurchase(Purchase purchase) {
        purchase.setCreateTime(DateUtils.getNowDate());
        return purchaseMapper.insert(purchase);
    }

    /**
     * 修改采购信息
     * 
     * @param purchase 采购信息
     * @return 结果
     */
    @Override
    public int updatePurchase(Purchase purchase) {
        purchase.setUpdateTime(DateUtils.getNowDate());
        return purchaseMapper.updateById(purchase);
    }

    /**
     * 批量删除采购信息
     * 
     * @param ids 需要删除的采购信息主键
     * @return 结果
     */
    @Override
    public int deletePurchaseByIds(Long[] ids) {
        return purchaseMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
