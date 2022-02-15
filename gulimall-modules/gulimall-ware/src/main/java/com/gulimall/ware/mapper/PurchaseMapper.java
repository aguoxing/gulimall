package com.gulimall.ware.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.ware.domain.Purchase;

/**
 * 采购信息Mapper接口
 * 
 * @author admin
 * @date 2022-02-15
 */
public interface PurchaseMapper extends BaseMapper<Purchase> {

    /**
     * 查询采购信息列表
     * 
     * @param purchase 采购信息
     * @return 采购信息集合
     */
    List<Purchase> selectPurchaseList(Purchase purchase);

}
