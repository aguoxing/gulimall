package com.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimall.product.domain.SpuInfoDesc;

import java.util.List;

/**
 * spu信息介绍Service接口
 *
 * @author admin
 * @date 2022-02-14
 */
public interface ISpuInfoDescService extends IService<SpuInfoDesc> {
    /**
     * 查询spu信息介绍
     *
     * @param spuId spu信息介绍主键
     * @return spu信息介绍
     */
    SpuInfoDesc selectSpuInfoDescBySpuId(Long spuId);

    /**
     * 查询spu信息介绍列表
     *
     * @param spuInfoDesc spu信息介绍
     * @return spu信息介绍集合
     */
    List<SpuInfoDesc> selectSpuInfoDescList(SpuInfoDesc spuInfoDesc);

    /**
     * 新增spu信息介绍
     *
     * @param spuInfoDesc spu信息介绍
     * @return 结果
     */
    int insertSpuInfoDesc(SpuInfoDesc spuInfoDesc);

    /**
     * 修改spu信息介绍
     *
     * @param spuInfoDesc spu信息介绍
     * @return 结果
     */
    int updateSpuInfoDesc(SpuInfoDesc spuInfoDesc);

    /**
     * 批量删除spu信息介绍
     *
     * @param spuIds 需要删除的spu信息介绍主键集合
     * @return 结果
     */
    int deleteSpuInfoDescBySpuIds(Long[] spuIds);

}
