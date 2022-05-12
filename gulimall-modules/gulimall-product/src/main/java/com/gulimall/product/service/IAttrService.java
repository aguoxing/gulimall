package com.gulimall.product.service;

import java.util.List;
import com.gulimall.product.domain.AttrEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 商品属性Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface IAttrService extends IService<AttrEntity> {
    /**
     * 查询商品属性
     *
     * @param attrId 商品属性主键
     * @return 商品属性
     */
    AttrEntity selectAttrByAttrId(Long attrId);

    /**
     * 查询商品属性列表
     * 
     * @param attrEntity 商品属性
     * @return 商品属性集合
     */
    List<AttrEntity> selectAttrList(AttrEntity attrEntity);

    /**
     * 新增商品属性
     * 
     * @param attrEntity 商品属性
     * @return 结果
     */
    int insertAttr(AttrEntity attrEntity);

    /**
     * 修改商品属性
     * 
     * @param attrEntity 商品属性
     * @return 结果
     */
    int updateAttr(AttrEntity attrEntity);

    /**
     * 批量删除商品属性
     * 
     * @param attrIds 需要删除的商品属性主键集合
     * @return 结果
     */
    int deleteAttrByAttrIds(Long[] attrIds);

}
