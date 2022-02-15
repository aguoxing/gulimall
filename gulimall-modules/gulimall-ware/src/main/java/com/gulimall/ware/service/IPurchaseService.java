package com.gulimall.ware.service;

import java.util.List;
import com.gulimall.ware.domain.Purchase;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 采购信息Service接口
 * 
 * @author admin
 * @date 2022-02-15
 */
public interface IPurchaseService extends IService<Purchase> {
    /**
     * 查询采购信息
     *
     * @param id 采购信息主键
     * @return 采购信息
     */
    Purchase selectPurchaseById(Long id);

    /**
     * 查询采购信息列表
     * 
     * @param purchase 采购信息
     * @return 采购信息集合
     */
    List<Purchase> selectPurchaseList(Purchase purchase);

    /**
     * 新增采购信息
     * 
     * @param purchase 采购信息
     * @return 结果
     */
    int insertPurchase(Purchase purchase);

    /**
     * 修改采购信息
     * 
     * @param purchase 采购信息
     * @return 结果
     */
    int updatePurchase(Purchase purchase);

    /**
     * 批量删除采购信息
     * 
     * @param ids 需要删除的采购信息主键集合
     * @return 结果
     */
    int deletePurchaseByIds(Long[] ids);

}
