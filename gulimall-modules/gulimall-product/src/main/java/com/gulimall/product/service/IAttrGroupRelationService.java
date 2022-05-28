package com.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimall.product.domain.AttrGroupRelation;
import com.gulimall.product.domain.dto.AttrGroupRelationDTO;

import java.util.List;

/**
 * 属性&属性分组关联Service接口
 *
 * @author admin
 * @date 2022-02-14
 */
public interface IAttrGroupRelationService extends IService<AttrGroupRelation> {
    /**
     * 查询属性&属性分组关联
     *
     * @param id 属性&属性分组关联主键
     * @return 属性&属性分组关联
     */
    AttrGroupRelation selectAttrGroupRelationById(Long id);

    /**
     * 查询属性&属性分组关联列表
     *
     * @param attrGroupRelation 属性&属性分组关联
     * @return 属性&属性分组关联集合
     */
    List<AttrGroupRelation> selectAttrGroupRelationList(AttrGroupRelation attrGroupRelation);

    /**
     * 新增属性&属性分组关联
     *
     * @param attrGroupRelationDTO 属性&属性分组关联
     * @return 结果
     */
    int insertAttrGroupRelation(AttrGroupRelationDTO attrGroupRelationDTO);

    /**
     * 修改属性&属性分组关联
     *
     * @param attrGroupRelation 属性&属性分组关联
     * @return 结果
     */
    int updateAttrGroupRelation(AttrGroupRelation attrGroupRelation);

    /**
     * 批量删除属性&属性分组关联
     *
     * @param ids 需要删除的属性&属性分组关联主键集合
     * @return 结果
     */
    int deleteAttrGroupRelationByIds(Long[] ids);

    int delRelationByAttrIds(AttrGroupRelationDTO attrGroupRelationDTO);

}
