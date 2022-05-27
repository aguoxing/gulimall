package com.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimall.product.domain.AttrEntity;
import com.gulimall.product.domain.AttrGroupRelation;
import com.gulimall.product.mapper.AttrGroupRelationMapper;
import com.gulimall.product.mapper.AttrMapper;
import com.gulimall.product.service.IAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品属性Service业务层处理
 *
 * @author admin
 * @date 2022-02-14
 */
@Service
public class AttrServiceImpl extends ServiceImpl<AttrMapper, AttrEntity> implements IAttrService {
    @Autowired
    private AttrMapper attrMapper;
    @Autowired
    private AttrGroupRelationMapper attrGroupRelationMapper;

    /**
     * 查询商品属性
     *
     * @param attrId 商品属性主键
     * @return 商品属性
     */
    @Override
    public AttrEntity selectAttrByAttrId(Long attrId) {
        return attrMapper.selectById(attrId);
    }

    /**
     * 查询商品属性列表
     *
     * @param attrEntity 商品属性
     * @return 商品属性
     */
    @Override
    public List<AttrEntity> selectAttrList(AttrEntity attrEntity) {
        return attrMapper.selectAttrList(attrEntity);
    }

    /**
     * 新增商品属性
     *
     * @param attrEntity 商品属性
     * @return 结果
     */
    @Override
    public int insertAttr(AttrEntity attrEntity) {
        return attrMapper.insert(attrEntity);
    }

    /**
     * 修改商品属性
     *
     * @param attrEntity 商品属性
     * @return 结果
     */
    @Override
    public int updateAttr(AttrEntity attrEntity) {
        return attrMapper.updateById(attrEntity);
    }

    /**
     * 批量删除商品属性
     *
     * @param attrIds 需要删除的商品属性主键
     * @return 结果
     */
    @Override
    public int deleteAttrByAttrIds(Long[] attrIds) {
        return attrMapper.deleteBatchIds(Arrays.asList(attrIds));
    }

    /**
     * 查询已关联的属性
     *
     * @param attrGroupRelation
     * @return
     */
    @Override
    public List<AttrEntity> selectAttrByAttrGroupId(AttrGroupRelation attrGroupRelation) {
        List<AttrEntity> attrEntityList = new ArrayList<>();
        List<Long> attrIds = attrGroupRelationMapper.selectList(new LambdaQueryWrapper<AttrGroupRelation>()
                        .eq(AttrGroupRelation::getAttrGroupId, attrGroupRelation.getAttrGroupId()))
                .stream().map(AttrGroupRelation::getAttrId).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(attrIds)) {
            attrEntityList = attrMapper.selectBatchIds(attrIds);
        }
        return attrEntityList;
    }

}
