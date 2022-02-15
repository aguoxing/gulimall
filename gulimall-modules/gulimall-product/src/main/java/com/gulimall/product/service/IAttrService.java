package com.gulimall.product.service;

import java.util.List;
import com.gulimall.product.domain.Attr;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 商品属性Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface IAttrService extends IService<Attr> {
    /**
     * 查询商品属性
     *
     * @param attrId 商品属性主键
     * @return 商品属性
     */
    Attr selectAttrByAttrId(Long attrId);

    /**
     * 查询商品属性列表
     * 
     * @param attr 商品属性
     * @return 商品属性集合
     */
    List<Attr> selectAttrList(Attr attr);

    /**
     * 新增商品属性
     * 
     * @param attr 商品属性
     * @return 结果
     */
    int insertAttr(Attr attr);

    /**
     * 修改商品属性
     * 
     * @param attr 商品属性
     * @return 结果
     */
    int updateAttr(Attr attr);

    /**
     * 批量删除商品属性
     * 
     * @param attrIds 需要删除的商品属性主键集合
     * @return 结果
     */
    int deleteAttrByAttrIds(Long[] attrIds);

}
