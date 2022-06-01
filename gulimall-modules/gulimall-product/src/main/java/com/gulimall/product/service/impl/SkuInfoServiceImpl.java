package com.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimall.common.core.enums.ProductEnum;
import com.gulimall.common.core.utils.bean.BeanUtils;
import com.gulimall.product.domain.ProductAttrValue;
import com.gulimall.product.domain.SkuInfo;
import com.gulimall.product.domain.SkuSaleAttrValue;
import com.gulimall.product.domain.SpuInfo;
import com.gulimall.product.domain.dto.AttrDTO;
import com.gulimall.product.domain.dto.AttrGroupWithAttrDTO;
import com.gulimall.product.domain.dto.GenSkuDTO;
import com.gulimall.product.domain.vo.SkuInfoVO;
import com.gulimall.product.domain.vo.SkuItemVo;
import com.gulimall.product.mapper.ProductAttrValueMapper;
import com.gulimall.product.mapper.SkuInfoMapper;
import com.gulimall.product.mapper.SkuSaleAttrValueMapper;
import com.gulimall.product.mapper.SpuInfoMapper;
import com.gulimall.product.service.ISkuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

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
    @Autowired
    private SpuInfoMapper spuInfoMapper;
    @Autowired
    private ProductAttrValueMapper productAttrValueMapper;
    @Autowired
    private SkuSaleAttrValueMapper skuSaleAttrValueMapper;

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
     * 生成sku列表
     *
     * @param genSkuDTO
     * @return
     */
    @Override
    public List<SkuInfoVO> genSkuList(GenSkuDTO genSkuDTO) {
        List<SkuInfoVO> skuInfoVOList = new ArrayList<>();
        List<AttrGroupWithAttrDTO> attrGroupWithAttrVoList = genSkuDTO.getAttrGroupWithAttrDtoList();
        Map<String, List<String>> map = new HashMap<>();
        List<AttrDTO> attrInfoDTOList = new ArrayList<>();
        for (AttrGroupWithAttrDTO attrGroupWithAttrVo : attrGroupWithAttrVoList) {
            attrInfoDTOList.addAll(attrGroupWithAttrVo.getSaleAttrInfoList());
        }

        for (AttrDTO attrInfoDTO : attrInfoDTOList) {
            if (attrInfoDTO.getAttrValues().size() > 0) {
                map.put(attrInfoDTO.getAttrId(), attrInfoDTO.getAttrValues());
            }
        }

        List<String> list = descartes(new ArrayList<>(map.values()));
        for (String s : list) {
            List<String> tmp = Arrays.asList(s.split(","));
            SkuInfoVO skuInfoVO = new SkuInfoVO();
            List<SkuSaleAttrValue> skuSaleAttrValueList = new ArrayList<>();
            for (int i = 0; i < tmp.size(); i++) {
                SkuSaleAttrValue skuSaleAttrValue = new SkuSaleAttrValue();
                skuSaleAttrValue.setAttrId(attrInfoDTOList.get(i).getAttrId());
                skuSaleAttrValue.setAttrName(attrInfoDTOList.get(i).getAttrName());
                skuSaleAttrValue.setAttrValue(tmp.get(i));
                skuSaleAttrValueList.add(skuSaleAttrValue);
            }
            skuInfoVO.setSkuSaleAttrValueList(skuSaleAttrValueList);
            skuInfoVOList.add(skuInfoVO);
        }
        return skuInfoVOList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveSkuList(List<SkuInfoVO> skuInfoVOList) {
        for (SkuInfoVO skuInfoVO : skuInfoVOList) {
            String skuId = IdWorker.getIdStr();
            SkuInfo skuInfo = new SkuInfo();
            BeanUtils.copyProperties(skuInfoVO, skuInfo);
            skuInfo.setSkuId(skuId);
            for (SkuSaleAttrValue skuSaleAttrValue : skuInfoVO.getSkuSaleAttrValueList()) {
                skuSaleAttrValue.setId(IdWorker.getIdStr());
                skuSaleAttrValue.setSkuId(skuId);
                skuSaleAttrValueMapper.insert(skuSaleAttrValue);
            }
            skuInfoMapper.insert(skuInfo);
        }
        if (skuInfoVOList.size() > 0) {
            for (AttrDTO attrInfoDTO : skuInfoVOList.get(0).getBaseAttrInfoList()) {
                ProductAttrValue spuAttrValue = new ProductAttrValue();
                BeanUtils.copyProperties(attrInfoDTO, spuAttrValue);
                spuAttrValue.setId(IdWorker.getIdStr());
                spuAttrValue.setSpuId(skuInfoVOList.get(0).getSpuId());
                productAttrValueMapper.insert(spuAttrValue);
            }
            SpuInfo spuInfo = spuInfoMapper.selectById(skuInfoVOList.get(0).getSpuId());
            spuInfo.setPublishStatus(Integer.valueOf(ProductEnum.SHANGJIA.getCode()));
            spuInfoMapper.updateById(spuInfo);
        }
        return 1;
    }

    public static List<String> descartes(List<List<String>> lists) {
        List<String> tempList = new ArrayList<>();
        for (List<String> list : lists) {
            if (tempList.isEmpty()) {
                tempList = list;
            } else {
                tempList = tempList.stream().flatMap(item -> list.stream().map(item2 -> item + "," + item2)).collect(Collectors.toList());
            }
        }
        return tempList;
    }

    /**
     * 查询商品详情
     *
     * @param skuId
     * @return
     */
    @Override
    public SkuItemVo item(String skuId) {
        // todo
        return null;
    }

}
