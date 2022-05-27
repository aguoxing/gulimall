package com.gulimall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.product.domain.AttrEntity;
import com.gulimall.product.domain.AttrGroupRelation;

import java.util.List;

/**
 * 属性&属性分组关联Mapper接口
 *
 * @author admin
 * @date 2022-02-14
 */
public interface AttrGroupRelationMapper extends BaseMapper<AttrGroupRelation> {

    /**
     * 查询属性&属性分组关联列表
     *
     * @param attrGroupRelation 属性&属性分组关联
     * @return 属性&属性分组关联集合
     */
    List<AttrGroupRelation> selectAttrGroupRelationList(AttrGroupRelation attrGroupRelation);

}
