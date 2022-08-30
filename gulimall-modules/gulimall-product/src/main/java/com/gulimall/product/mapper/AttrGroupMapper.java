package com.gulimall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.product.domain.AttrGroup;

import java.util.List;

/**
 * 属性分组Mapper接口
 *
 * @author admin
 * @date 2022-02-14
 */
public interface AttrGroupMapper extends BaseMapper<AttrGroup> {

    /**
     * 查询属性分组列表
     *
     * @param attrGroup 属性分组
     * @return 属性分组集合
     */
    List<AttrGroup> selectAttrGroupList(AttrGroup attrGroup);

}
