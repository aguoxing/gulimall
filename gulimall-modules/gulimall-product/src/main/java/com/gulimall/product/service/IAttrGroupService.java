package com.gulimall.product.service;

import java.util.List;
import com.gulimall.product.domain.AttrGroup;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 属性分组Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface IAttrGroupService extends IService<AttrGroup> {
    /**
     * 查询属性分组
     *
     * @param attrGroupId 属性分组主键
     * @return 属性分组
     */
    AttrGroup selectAttrGroupByAttrGroupId(Long attrGroupId);

    /**
     * 查询属性分组列表
     * 
     * @param attrGroup 属性分组
     * @return 属性分组集合
     */
    List<AttrGroup> selectAttrGroupList(AttrGroup attrGroup);

    /**
     * 新增属性分组
     * 
     * @param attrGroup 属性分组
     * @return 结果
     */
    int insertAttrGroup(AttrGroup attrGroup);

    /**
     * 修改属性分组
     * 
     * @param attrGroup 属性分组
     * @return 结果
     */
    int updateAttrGroup(AttrGroup attrGroup);

    /**
     * 批量删除属性分组
     * 
     * @param attrGroupIds 需要删除的属性分组主键集合
     * @return 结果
     */
    int deleteAttrGroupByAttrGroupIds(Long[] attrGroupIds);

}
