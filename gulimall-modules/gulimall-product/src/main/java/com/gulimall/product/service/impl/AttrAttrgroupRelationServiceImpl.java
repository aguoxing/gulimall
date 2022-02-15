package com.gulimall.product.service.impl;

import java.util.Arrays;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.product.mapper.AttrAttrgroupRelationMapper;
import com.gulimall.product.domain.AttrAttrgroupRelation;
import com.gulimall.product.service.IAttrAttrgroupRelationService;

/**
 * 属性&属性分组关联Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class AttrAttrgroupRelationServiceImpl extends ServiceImpl<AttrAttrgroupRelationMapper, AttrAttrgroupRelation> implements IAttrAttrgroupRelationService {
    @Autowired
    private AttrAttrgroupRelationMapper attrAttrgroupRelationMapper;

    /**
     * 查询属性&属性分组关联
     * 
     * @param id 属性&属性分组关联主键
     * @return 属性&属性分组关联
     */
    @Override
    public AttrAttrgroupRelation selectAttrAttrgroupRelationById(Long id) {
        return attrAttrgroupRelationMapper.selectById(id);
    }

    /**
     * 查询属性&属性分组关联列表
     * 
     * @param attrAttrgroupRelation 属性&属性分组关联
     * @return 属性&属性分组关联
     */
    @Override
    public List<AttrAttrgroupRelation> selectAttrAttrgroupRelationList(AttrAttrgroupRelation attrAttrgroupRelation) {
        return attrAttrgroupRelationMapper.selectAttrAttrgroupRelationList(attrAttrgroupRelation);
    }

    /**
     * 新增属性&属性分组关联
     * 
     * @param attrAttrgroupRelation 属性&属性分组关联
     * @return 结果
     */
    @Override
    public int insertAttrAttrgroupRelation(AttrAttrgroupRelation attrAttrgroupRelation) {
        return attrAttrgroupRelationMapper.insert(attrAttrgroupRelation);
    }

    /**
     * 修改属性&属性分组关联
     * 
     * @param attrAttrgroupRelation 属性&属性分组关联
     * @return 结果
     */
    @Override
    public int updateAttrAttrgroupRelation(AttrAttrgroupRelation attrAttrgroupRelation) {
        return attrAttrgroupRelationMapper.updateById(attrAttrgroupRelation);
    }

    /**
     * 批量删除属性&属性分组关联
     * 
     * @param ids 需要删除的属性&属性分组关联主键
     * @return 结果
     */
    @Override
    public int deleteAttrAttrgroupRelationByIds(Long[] ids) {
        return attrAttrgroupRelationMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
