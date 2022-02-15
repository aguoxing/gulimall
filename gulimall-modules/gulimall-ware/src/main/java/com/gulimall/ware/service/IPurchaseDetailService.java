package com.gulimall.ware.service;

import java.util.List;
import com.gulimall.ware.domain.PurchaseDetail;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 采购信息详情Service接口
 * 
 * @author admin
 * @date 2022-02-15
 */
public interface IPurchaseDetailService extends IService<PurchaseDetail> {
    /**
     * 查询采购信息详情
     *
     * @param id 采购信息详情主键
     * @return 采购信息详情
     */
    PurchaseDetail selectPurchaseDetailById(Long id);

    /**
     * 查询采购信息详情列表
     * 
     * @param purchaseDetail 采购信息详情
     * @return 采购信息详情集合
     */
    List<PurchaseDetail> selectPurchaseDetailList(PurchaseDetail purchaseDetail);

    /**
     * 新增采购信息详情
     * 
     * @param purchaseDetail 采购信息详情
     * @return 结果
     */
    int insertPurchaseDetail(PurchaseDetail purchaseDetail);

    /**
     * 修改采购信息详情
     * 
     * @param purchaseDetail 采购信息详情
     * @return 结果
     */
    int updatePurchaseDetail(PurchaseDetail purchaseDetail);

    /**
     * 批量删除采购信息详情
     * 
     * @param ids 需要删除的采购信息详情主键集合
     * @return 结果
     */
    int deletePurchaseDetailByIds(Long[] ids);

}
