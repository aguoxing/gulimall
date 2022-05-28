package com.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimall.product.domain.AttrGroupRelation;
import com.gulimall.product.domain.dto.AttrGroupRelationDTO;
import com.gulimall.product.mapper.AttrGroupRelationMapper;
import com.gulimall.product.service.IAttrGroupRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 属性&属性分组关联Service业务层处理
 *
 * @author admin
 * @date 2022-02-14
 */
@Service
public class AttrGroupRelationServiceImpl extends ServiceImpl<AttrGroupRelationMapper, AttrGroupRelation> implements IAttrGroupRelationService {
    @Autowired
    private AttrGroupRelationMapper attrGroupRelationMapper;

    /**
     * 查询属性&属性分组关联
     *
     * @param id 属性&属性分组关联主键
     * @return 属性&属性分组关联
     */
    @Override
    public AttrGroupRelation selectAttrGroupRelationById(Long id) {
        return attrGroupRelationMapper.selectById(id);
    }

    /**
     * 查询属性&属性分组关联列表
     *
     * @param attrGroupRelation 属性&属性分组关联
     * @return 属性&属性分组关联
     */
    @Override
    public List<AttrGroupRelation> selectAttrGroupRelationList(AttrGroupRelation attrGroupRelation) {
        return attrGroupRelationMapper.selectAttrGroupRelationList(attrGroupRelation);
    }

    /**
     * 新增属性&属性分组关联
     *
     * @param attrGroupRelationDTO 属性&属性分组关联
     * @return 结果
     */
    @Override
    public int insertAttrGroupRelation(AttrGroupRelationDTO attrGroupRelationDTO) {
        List<Long> attrIds = attrGroupRelationDTO.getAttrIds();
        List<AttrGroupRelation> attrGroupRelations = new ArrayList<>();
        for (Long attrId : attrIds) {
            AttrGroupRelation attrGroupRelation = new AttrGroupRelation();
            attrGroupRelation.setAttrGroupId(attrGroupRelationDTO.getAttrGroupId());
            attrGroupRelation.setAttrId(attrId);
            attrGroupRelations.add(attrGroupRelation);
        }
        return this.saveBatch(attrGroupRelations) ? 1 : 0;
    }

    /**
     * 修改属性&属性分组关联
     *
     * @param attrGroupRelation 属性&属性分组关联
     * @return 结果
     */
    @Override
    public int updateAttrGroupRelation(AttrGroupRelation attrGroupRelation) {
        return attrGroupRelationMapper.updateById(attrGroupRelation);
    }

    /**
     * 批量删除属性&属性分组关联
     *
     * @param ids 需要删除的属性&属性分组关联主键
     * @return 结果
     */
    @Override
    public int deleteAttrGroupRelationByIds(Long[] ids) {
        return attrGroupRelationMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public int delRelationByAttrIds(AttrGroupRelationDTO attrGroupRelationDTO) {
        List<Long> attrIds = attrGroupRelationDTO.getAttrIds();
        List<Long> ids = new ArrayList<>();
        for (Long attrId : attrIds) {
            List<Long> attrGroupRelationIds = attrGroupRelationMapper.selectList(new LambdaQueryWrapper<AttrGroupRelation>()
                    .eq(AttrGroupRelation::getAttrGroupId, attrGroupRelationDTO.getAttrGroupId())
                    .eq(AttrGroupRelation::getAttrId, attrId)
            ).stream().map(AttrGroupRelation::getId).collect(Collectors.toList());
            ids.addAll(attrGroupRelationIds);
        }
        return this.removeByIds(ids) ? 1 : 0;
    }

}
