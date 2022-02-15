package com.gulimall.product.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.product.domain.AttrAttrgroupRelation;

/**
 * 属性&属性分组关联Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface AttrAttrgroupRelationMapper extends BaseMapper<AttrAttrgroupRelation> {

    /**
     * 查询属性&属性分组关联列表
     * 
     * @param attrAttrgroupRelation 属性&属性分组关联
     * @return 属性&属性分组关联集合
     */
    List<AttrAttrgroupRelation> selectAttrAttrgroupRelationList(AttrAttrgroupRelation attrAttrgroupRelation);

}
