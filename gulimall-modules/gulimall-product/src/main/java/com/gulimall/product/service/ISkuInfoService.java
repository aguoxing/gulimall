package com.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimall.product.domain.SkuInfo;
import com.gulimall.product.domain.dto.GenSkuDTO;
import com.gulimall.product.domain.vo.SkuInfoVO;
import com.gulimall.product.domain.vo.SkuItemVo;

import java.util.List;

/**
 * sku信息Service接口
 *
 * @author admin
 * @date 2022-02-14
 */
public interface ISkuInfoService extends IService<SkuInfo> {
    /**
     * 查询sku信息
     *
     * @param skuId sku信息主键
     * @return sku信息
     */
    SkuInfo selectSkuInfoBySkuId(Long skuId);

    /**
     * 查询sku信息列表
     *
     * @param skuInfo sku信息
     * @return sku信息集合
     */
    List<SkuInfo> selectSkuInfoList(SkuInfo skuInfo);

    /**
     * 新增sku信息
     *
     * @param skuInfo sku信息
     * @return 结果
     */
    int insertSkuInfo(SkuInfo skuInfo);

    /**
     * 修改sku信息
     *
     * @param skuInfo sku信息
     * @return 结果
     */
    int updateSkuInfo(SkuInfo skuInfo);

    /**
     * 批量删除sku信息
     *
     * @param skuIds 需要删除的sku信息主键集合
     * @return 结果
     */
    int deleteSkuInfoBySkuIds(Long[] skuIds);

    /**
     * 生成sku列表
     *
     * @param genSkuDTO
     * @return
     */
    List<SkuInfoVO> genSkuList(GenSkuDTO genSkuDTO);

    /**
     * 保存
     *
     * @param skuInfoVOList
     * @return
     */
    int saveSkuList(List<SkuInfoVO> skuInfoVOList);

    /**
     * 查询商品详情
     *
     * @param skuId
     * @return
     */
    SkuItemVo item(String skuId);
}
