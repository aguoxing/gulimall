package com.gulimall.product.service.impl;

import java.util.Arrays;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.product.mapper.AttrGroupMapper;
import com.gulimall.product.domain.AttrGroup;
import com.gulimall.product.service.IAttrGroupService;

/**
 * 属性分组Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroup> implements IAttrGroupService {
    @Autowired
    private AttrGroupMapper attrGroupMapper;

    /**
     * 查询属性分组
     * 
     * @param attrGroupId 属性分组主键
     * @return 属性分组
     */
    @Override
    public AttrGroup selectAttrGroupByAttrGroupId(Long attrGroupId) {
        return attrGroupMapper.selectById(attrGroupId);
    }

    /**
     * 查询属性分组列表
     * 
     * @param attrGroup 属性分组
     * @return 属性分组
     */
    @Override
    public List<AttrGroup> selectAttrGroupList(AttrGroup attrGroup) {
        return attrGroupMapper.selectAttrGroupList(attrGroup);
    }

    /**
     * 新增属性分组
     * 
     * @param attrGroup 属性分组
     * @return 结果
     */
    @Override
    public int insertAttrGroup(AttrGroup attrGroup) {
        return attrGroupMapper.insert(attrGroup);
    }

    /**
     * 修改属性分组
     * 
     * @param attrGroup 属性分组
     * @return 结果
     */
    @Override
    public int updateAttrGroup(AttrGroup attrGroup) {
        return attrGroupMapper.updateById(attrGroup);
    }

    /**
     * 批量删除属性分组
     * 
     * @param attrGroupIds 需要删除的属性分组主键
     * @return 结果
     */
    @Override
    public int deleteAttrGroupByAttrGroupIds(Long[] attrGroupIds) {
        return attrGroupMapper.deleteBatchIds(Arrays.asList(attrGroupIds));
    }

}
