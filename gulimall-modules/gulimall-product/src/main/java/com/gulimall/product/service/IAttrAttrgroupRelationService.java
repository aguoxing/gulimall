package com.gulimall.product.service;

import java.util.List;
import com.gulimall.product.domain.AttrAttrgroupRelation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 属性&属性分组关联Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface IAttrAttrgroupRelationService extends IService<AttrAttrgroupRelation> {
    /**
     * 查询属性&属性分组关联
     *
     * @param id 属性&属性分组关联主键
     * @return 属性&属性分组关联
     */
    AttrAttrgroupRelation selectAttrAttrgroupRelationById(Long id);

    /**
     * 查询属性&属性分组关联列表
     * 
     * @param attrAttrgroupRelation 属性&属性分组关联
     * @return 属性&属性分组关联集合
     */
    List<AttrAttrgroupRelation> selectAttrAttrgroupRelationList(AttrAttrgroupRelation attrAttrgroupRelation);

    /**
     * 新增属性&属性分组关联
     * 
     * @param attrAttrgroupRelation 属性&属性分组关联
     * @return 结果
     */
    int insertAttrAttrgroupRelation(AttrAttrgroupRelation attrAttrgroupRelation);

    /**
     * 修改属性&属性分组关联
     * 
     * @param attrAttrgroupRelation 属性&属性分组关联
     * @return 结果
     */
    int updateAttrAttrgroupRelation(AttrAttrgroupRelation attrAttrgroupRelation);

    /**
     * 批量删除属性&属性分组关联
     * 
     * @param ids 需要删除的属性&属性分组关联主键集合
     * @return 结果
     */
    int deleteAttrAttrgroupRelationByIds(Long[] ids);

}
