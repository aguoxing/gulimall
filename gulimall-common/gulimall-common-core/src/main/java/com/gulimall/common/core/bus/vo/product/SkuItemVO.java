package com.gulimall.common.core.bus.vo.product;

import com.gulimall.common.core.bus.entity.product.SkuImagesEntity;
import com.gulimall.common.core.bus.entity.product.SkuInfoEntity;
import com.gulimall.common.core.bus.entity.product.SpuInfoDescEntity;
import lombok.Data;

import java.util.List;

/**
 * @author: admin
 */
@Data
public class SkuItemVO {
    /**
     * 1、sku基本信息【标题、副标题、价格】pms_sku_info
     * 2、sku图片信息【每个sku_id对应了多个图片】pms_sku_images
     * 3、spu下所有sku销售属性组合【不只是当前sku_id所指定的商品】
     * 4、spu商品介绍【】
     * 5、spu规格与包装【参数信息】
     */

    /**
     * 1、sku基本信息（pms_sku_info）【默认图片、标题、副标题、价格】
     */
    private SkuInfoEntity info;

    /**
     * 是否有货
     */
    private Boolean hasStock = true;

    /**
     * 2、sku图片信息（pms_sku_images）
     */
    private List<SkuImagesEntity> images;

    /**
     * 3、当前sku所属spu下的所有销售属性组合（pms_sku_sale_attr_value）
     */
    private List<SkuItemSaleAttrVO> saleAttr;

    /**
     * 4、spu商品介绍（pms_spu_info_desc）【描述图片】
     */
    private SpuInfoDescEntity desc;

    /**
     * 5、spu规格参数信息（pms_attr）【以组为单位】
     */
    private List<SpuItemAttrGroupVO> groupAttrs;

    /**
     * 6、秒杀商品的优惠信息
     */
    private SeckillSkuVO seckillSku;

}
