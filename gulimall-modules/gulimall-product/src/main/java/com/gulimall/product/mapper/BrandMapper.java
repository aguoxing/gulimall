package com.gulimall.product.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.product.domain.Brand;

/**
 * 品牌Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface BrandMapper extends BaseMapper<Brand> {

    /**
     * 查询品牌列表
     * 
     * @param brand 品牌
     * @return 品牌集合
     */
    List<Brand> selectBrandList(Brand brand);

}
