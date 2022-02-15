package com.gulimall.coupon.service;

import java.util.List;
import com.gulimall.coupon.domain.SpuBounds;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 商品spu积分设置Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface ISpuBoundsService extends IService<SpuBounds> {
    /**
     * 查询商品spu积分设置
     *
     * @param id 商品spu积分设置主键
     * @return 商品spu积分设置
     */
    SpuBounds selectSpuBoundsById(Long id);

    /**
     * 查询商品spu积分设置列表
     * 
     * @param spuBounds 商品spu积分设置
     * @return 商品spu积分设置集合
     */
    List<SpuBounds> selectSpuBoundsList(SpuBounds spuBounds);

    /**
     * 新增商品spu积分设置
     * 
     * @param spuBounds 商品spu积分设置
     * @return 结果
     */
    int insertSpuBounds(SpuBounds spuBounds);

    /**
     * 修改商品spu积分设置
     * 
     * @param spuBounds 商品spu积分设置
     * @return 结果
     */
    int updateSpuBounds(SpuBounds spuBounds);

    /**
     * 批量删除商品spu积分设置
     * 
     * @param ids 需要删除的商品spu积分设置主键集合
     * @return 结果
     */
    int deleteSpuBoundsByIds(Long[] ids);

}
