package com.gulimall.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimall.common.core.utils.DateUtils;
import com.gulimall.product.domain.SpuInfo;
import com.gulimall.product.mapper.SpuInfoMapper;
import com.gulimall.product.service.ISpuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * spu信息Service业务层处理
 *
 * @author admin
 * @date 2022-02-14
 */
@Service
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoMapper, SpuInfo> implements ISpuInfoService {
    @Autowired
    private SpuInfoMapper spuInfoMapper;

    /**
     * 查询spu信息
     *
     * @param id spu信息主键
     * @return spu信息
     */
    @Override
    public SpuInfo selectSpuInfoById(Long id) {
        return spuInfoMapper.selectById(id);
    }

    /**
     * 查询spu信息列表
     *
     * @param spuInfo spu信息
     * @return spu信息
     */
    @Override
    public List<SpuInfo> selectSpuInfoList(SpuInfo spuInfo) {
        return spuInfoMapper.selectSpuInfoList(spuInfo);
    }

    /**
     * 新增spu信息
     *
     * @param spuInfo spu信息
     * @return 结果
     */
    @Override
    public int insertSpuInfo(SpuInfo spuInfo) {
        spuInfo.setCreateTime(DateUtils.getNowDate());
        return spuInfoMapper.insert(spuInfo);
    }

    /**
     * 修改spu信息
     *
     * @param spuInfo spu信息
     * @return 结果
     */
    @Override
    public int updateSpuInfo(SpuInfo spuInfo) {
        spuInfo.setUpdateTime(DateUtils.getNowDate());
        return spuInfoMapper.updateById(spuInfo);
    }

    /**
     * 批量删除spu信息
     *
     * @param ids 需要删除的spu信息主键
     * @return 结果
     */
    @Override
    public int deleteSpuInfoByIds(Long[] ids) {
        return spuInfoMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
