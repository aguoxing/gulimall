package com.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimall.product.domain.SpuInfo;

import java.util.List;

/**
 * spu信息Service接口
 *
 * @author admin
 * @date 2022-02-14
 */
public interface ISpuInfoService extends IService<SpuInfo> {
    /**
     * 查询spu信息
     *
     * @param id spu信息主键
     * @return spu信息
     */
    SpuInfo selectSpuInfoById(Long id);

    /**
     * 查询spu信息列表
     *
     * @param spuInfo spu信息
     * @return spu信息集合
     */
    List<SpuInfo> selectSpuInfoList(SpuInfo spuInfo);

    /**
     * 新增spu信息
     *
     * @param spuInfo spu信息
     * @return 结果
     */
    int insertSpuInfo(SpuInfo spuInfo);

    /**
     * 修改spu信息
     *
     * @param spuInfo spu信息
     * @return 结果
     */
    int updateSpuInfo(SpuInfo spuInfo);

    /**
     * 批量删除spu信息
     *
     * @param ids 需要删除的spu信息主键集合
     * @return 结果
     */
    int deleteSpuInfoByIds(Long[] ids);

}
