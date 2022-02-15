package com.gulimall.ware.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.ware.domain.PurchaseDetail;

/**
 * 采购信息详情Mapper接口
 * 
 * @author admin
 * @date 2022-02-15
 */
public interface PurchaseDetailMapper extends BaseMapper<PurchaseDetail> {

    /**
     * 查询采购信息详情列表
     * 
     * @param purchaseDetail 采购信息详情
     * @return 采购信息详情集合
     */
    List<PurchaseDetail> selectPurchaseDetailList(PurchaseDetail purchaseDetail);

}
