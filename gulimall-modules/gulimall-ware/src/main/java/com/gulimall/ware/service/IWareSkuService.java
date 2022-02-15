package com.gulimall.ware.service;

import java.util.List;
import com.gulimall.ware.domain.WareSku;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 商品库存Service接口
 * 
 * @author admin
 * @date 2022-02-15
 */
public interface IWareSkuService extends IService<WareSku> {
    /**
     * 查询商品库存
     *
     * @param id 商品库存主键
     * @return 商品库存
     */
    WareSku selectWareSkuById(Long id);

    /**
     * 查询商品库存列表
     * 
     * @param wareSku 商品库存
     * @return 商品库存集合
     */
    List<WareSku> selectWareSkuList(WareSku wareSku);

    /**
     * 新增商品库存
     * 
     * @param wareSku 商品库存
     * @return 结果
     */
    int insertWareSku(WareSku wareSku);

    /**
     * 修改商品库存
     * 
     * @param wareSku 商品库存
     * @return 结果
     */
    int updateWareSku(WareSku wareSku);

    /**
     * 批量删除商品库存
     * 
     * @param ids 需要删除的商品库存主键集合
     * @return 结果
     */
    int deleteWareSkuByIds(Long[] ids);

}
