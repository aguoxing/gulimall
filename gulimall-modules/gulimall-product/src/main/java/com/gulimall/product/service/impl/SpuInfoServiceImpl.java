package com.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimall.common.core.enums.ProductEnum;
import com.gulimall.common.core.utils.DateUtils;
import com.gulimall.common.core.utils.StringUtils;
import com.gulimall.common.core.utils.bean.BeanUtils;
import com.gulimall.product.domain.ProductAttrValue;
import com.gulimall.product.domain.SpuInfo;
import com.gulimall.product.domain.SpuInfoDesc;
import com.gulimall.product.domain.dto.AttrDTO;
import com.gulimall.product.domain.dto.SaveSkuListDTO;
import com.gulimall.product.domain.vo.Bounds;
import com.gulimall.product.domain.vo.SkuInfoVO;
import com.gulimall.product.mapper.*;
import com.gulimall.product.service.IProductAttrValueService;
import com.gulimall.product.service.ISkuInfoService;
import com.gulimall.product.service.ISpuImagesService;
import com.gulimall.product.service.ISpuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private SkuInfoMapper skuInfoMapper;
    @Autowired
    private ProductAttrValueMapper productAttrValueMapper;
    @Autowired
    private SkuSaleAttrValueMapper skuSaleAttrValueMapper;
    @Autowired
    private SpuInfoDescMapper spuInfoDescMapper;
    @Autowired
    private ISpuImagesService spuImagesService;
    @Autowired
    private IProductAttrValueService productAttrValueService;
    @Autowired
    private ISkuInfoService skuInfoService;


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

    /**
     * 发布商品
     *
     * @param saveSkuListDTO
     * @return
     */
    /// @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveSkuList(SaveSkuListDTO saveSkuListDTO) {
        // 1、保存spu基本信息：pms_spu_info
        SpuInfo spuInfo = new SpuInfo();
        BeanUtils.copyProperties(saveSkuListDTO.getSpuInfoDTO(), spuInfo);
        String spuId = IdWorker.getIdStr();
        spuInfo.setId(spuId);
        spuInfo.setPublishStatus(Integer.valueOf(ProductEnum.SHANGJIA.getCode()));
        spuInfoMapper.insert(spuInfo);

        // 2、保存spu的描述图片：pms_spu_info_desc
        List<String> descriptionList = saveSkuListDTO.getSpuInfoDTO().getDescription();
        SpuInfoDesc spuInfoDesc = new SpuInfoDesc();
        spuInfoDesc.setSpuId(spuId);
        spuInfoDesc.setDescription(String.join(","));
        spuInfoDescMapper.insert(spuInfoDesc);

        // 3、保存spu的图片集：pms_spu_images
        List<String> images = saveSkuListDTO.getSpuInfoDTO().getImages();
        spuImagesService.saveImages(spuId, images);

        // 4、保存spu的规格参数：pms_product_attr_value
        List<AttrDTO> baseAttrs = saveSkuListDTO.getBaseAttrInfoList();
        List<ProductAttrValue> collect = baseAttrs.stream().map(attr -> {
            ProductAttrValue valueEntity = new ProductAttrValue();
            valueEntity.setAttrId(attr.getAttrId());
            valueEntity.setSpuId(spuId);
            valueEntity.setAttrName(attr.getAttrName());
            valueEntity.setAttrValue(StringUtils.join(attr.getAttrValues()));
            valueEntity.setQuickShow(attr.getShowDesc());
            return valueEntity;
        }).collect(Collectors.toList());
        productAttrValueService.saveBatch(collect);

        // 5、保存spu的积分信息：gulimall_sms--->sms_spu_bounds todo
        Bounds bounds = saveSkuListDTO.getSpuInfoDTO().getBounds();

        // 6、保存当前spu对应的所有sku信息
        //   6.1)sku的基本信息：pms_sku_info
        //   6.2)sku的图片信息：pms_sku_images
        //   6.3)sku的销售属性值：pms_sku_sale_attr_value
        //   6.4)sku的打折（买几件打几折）、满减信息（满多少减多少）、会员价格：
        //   sms_sku_ladder\sms_sku_full_reduction\sms_member_price
        List<SkuInfoVO> skuInfoVOList = saveSkuListDTO.getSkuInfoVoList();
        skuInfoService.saveSkuInfo(spuInfo, skuInfoVOList);

    }


}
