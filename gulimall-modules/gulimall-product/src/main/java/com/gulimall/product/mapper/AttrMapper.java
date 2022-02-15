package com.gulimall.product.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.product.domain.Attr;

/**
 * 商品属性Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface AttrMapper extends BaseMapper<Attr> {

    /**
     * 查询商品属性列表
     * 
     * @param attr 商品属性
     * @return 商品属性集合
     */
    List<Attr> selectAttrList(Attr attr);

}
