package com.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimall.product.domain.Brand;

import java.util.List;

/**
 * 品牌Service接口
 *
 * @author admin
 * @date 2022-02-14
 */
public interface IBrandService extends IService<Brand> {
    /**
     * 查询品牌
     *
     * @param brandId 品牌主键
     * @return 品牌
     */
    Brand selectBrandByBrandId(Long brandId);

    /**
     * 查询品牌列表
     *
     * @param brand 品牌
     * @return 品牌集合
     */
    List<Brand> selectBrandList(Brand brand);

    /**
     * 新增品牌
     *
     * @param brand 品牌
     * @return 结果
     */
    int insertBrand(Brand brand);

    /**
     * 修改品牌
     *
     * @param brand 品牌
     * @return 结果
     */
    int updateBrand(Brand brand);

    /**
     * 批量删除品牌
     *
     * @param brandIds 需要删除的品牌主键集合
     * @return 结果
     */
    int deleteBrandByBrandIds(Long[] brandIds);

}
