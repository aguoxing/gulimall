package com.gulimall.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimall.product.domain.SkuInfo;
import com.gulimall.product.domain.vo.SkuItemVo;
import com.gulimall.product.mapper.SkuInfoMapper;
import com.gulimall.product.service.ISkuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * sku信息Service业务层处理
 *
 * @author admin
 * @date 2022-02-14
 */
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo> implements ISkuInfoService {
    @Autowired
    private SkuInfoMapper skuInfoMapper;

    /**
     * 查询sku信息
     *
     * @param skuId sku信息主键
     * @return sku信息
     */
    @Override
    public SkuInfo selectSkuInfoBySkuId(Long skuId) {
        return skuInfoMapper.selectById(skuId);
    }

    /**
     * 查询sku信息列表
     *
     * @param skuInfo sku信息
     * @return sku信息
     */
    @Override
    public List<SkuInfo> selectSkuInfoList(SkuInfo skuInfo) {
        return skuInfoMapper.selectSkuInfoList(skuInfo);
    }

    /**
     * 新增sku信息
     *
     * @param skuInfo sku信息
     * @return 结果
     */
    @Override
    public int insertSkuInfo(SkuInfo skuInfo) {
        return skuInfoMapper.insert(skuInfo);
    }

    /**
     * 修改sku信息
     *
     * @param skuInfo sku信息
     * @return 结果
     */
    @Override
    public int updateSkuInfo(SkuInfo skuInfo) {
        return skuInfoMapper.updateById(skuInfo);
    }

    /**
     * 批量删除sku信息
     *
     * @param skuIds 需要删除的sku信息主键
     * @return 结果
     */
    @Override
    public int deleteSkuInfoBySkuIds(Long[] skuIds) {
        return skuInfoMapper.deleteBatchIds(Arrays.asList(skuIds));
    }

    /**
     * 查询商品详情
     *
     * @param skuId
     * @return
     */
    @Override
    public SkuItemVo item(Long skuId) {
        // todo
        return null;
    }

}
