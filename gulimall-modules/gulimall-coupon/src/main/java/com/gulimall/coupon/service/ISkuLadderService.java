package com.gulimall.coupon.service;

import java.util.List;
import com.gulimall.coupon.domain.SkuLadder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 商品阶梯价格Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface ISkuLadderService extends IService<SkuLadder> {
    /**
     * 查询商品阶梯价格
     *
     * @param id 商品阶梯价格主键
     * @return 商品阶梯价格
     */
    SkuLadder selectSkuLadderById(Long id);

    /**
     * 查询商品阶梯价格列表
     * 
     * @param skuLadder 商品阶梯价格
     * @return 商品阶梯价格集合
     */
    List<SkuLadder> selectSkuLadderList(SkuLadder skuLadder);

    /**
     * 新增商品阶梯价格
     * 
     * @param skuLadder 商品阶梯价格
     * @return 结果
     */
    int insertSkuLadder(SkuLadder skuLadder);

    /**
     * 修改商品阶梯价格
     * 
     * @param skuLadder 商品阶梯价格
     * @return 结果
     */
    int updateSkuLadder(SkuLadder skuLadder);

    /**
     * 批量删除商品阶梯价格
     * 
     * @param ids 需要删除的商品阶梯价格主键集合
     * @return 结果
     */
    int deleteSkuLadderByIds(Long[] ids);

}
