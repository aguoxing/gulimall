package com.gulimall.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimall.product.domain.SpuInfoDesc;
import com.gulimall.product.mapper.SpuInfoDescMapper;
import com.gulimall.product.service.ISpuInfoDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * spu信息介绍Service业务层处理
 *
 * @author admin
 * @date 2022-02-14
 */
@Service
public class SpuInfoDescServiceImpl extends ServiceImpl<SpuInfoDescMapper, SpuInfoDesc> implements ISpuInfoDescService {
    @Autowired
    private SpuInfoDescMapper spuInfoDescMapper;

    /**
     * 查询spu信息介绍
     *
     * @param spuId spu信息介绍主键
     * @return spu信息介绍
     */
    @Override
    public SpuInfoDesc selectSpuInfoDescBySpuId(Long spuId) {
        return spuInfoDescMapper.selectById(spuId);
    }

    /**
     * 查询spu信息介绍列表
     *
     * @param spuInfoDesc spu信息介绍
     * @return spu信息介绍
     */
    @Override
    public List<SpuInfoDesc> selectSpuInfoDescList(SpuInfoDesc spuInfoDesc) {
        return spuInfoDescMapper.selectSpuInfoDescList(spuInfoDesc);
    }

    /**
     * 新增spu信息介绍
     *
     * @param spuInfoDesc spu信息介绍
     * @return 结果
     */
    @Override
    public int insertSpuInfoDesc(SpuInfoDesc spuInfoDesc) {
        return spuInfoDescMapper.insert(spuInfoDesc);
    }

    /**
     * 修改spu信息介绍
     *
     * @param spuInfoDesc spu信息介绍
     * @return 结果
     */
    @Override
    public int updateSpuInfoDesc(SpuInfoDesc spuInfoDesc) {
        return spuInfoDescMapper.updateById(spuInfoDesc);
    }

    /**
     * 批量删除spu信息介绍
     *
     * @param spuIds 需要删除的spu信息介绍主键
     * @return 结果
     */
    @Override
    public int deleteSpuInfoDescBySpuIds(Long[] spuIds) {
        return spuInfoDescMapper.deleteBatchIds(Arrays.asList(spuIds));
    }

}
