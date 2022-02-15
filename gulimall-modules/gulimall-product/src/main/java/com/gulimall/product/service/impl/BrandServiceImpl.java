package com.gulimall.product.service.impl;

import java.util.Arrays;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.product.mapper.BrandMapper;
import com.gulimall.product.domain.Brand;
import com.gulimall.product.service.IBrandService;

/**
 * 品牌Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {
    @Autowired
    private BrandMapper brandMapper;

    /**
     * 查询品牌
     * 
     * @param brandId 品牌主键
     * @return 品牌
     */
    @Override
    public Brand selectBrandByBrandId(Long brandId) {
        return brandMapper.selectById(brandId);
    }

    /**
     * 查询品牌列表
     * 
     * @param brand 品牌
     * @return 品牌
     */
    @Override
    public List<Brand> selectBrandList(Brand brand) {
        return brandMapper.selectBrandList(brand);
    }

    /**
     * 新增品牌
     * 
     * @param brand 品牌
     * @return 结果
     */
    @Override
    public int insertBrand(Brand brand) {
        return brandMapper.insert(brand);
    }

    /**
     * 修改品牌
     * 
     * @param brand 品牌
     * @return 结果
     */
    @Override
    public int updateBrand(Brand brand) {
        return brandMapper.updateById(brand);
    }

    /**
     * 批量删除品牌
     * 
     * @param brandIds 需要删除的品牌主键
     * @return 结果
     */
    @Override
    public int deleteBrandByBrandIds(Long[] brandIds) {
        return brandMapper.deleteBatchIds(Arrays.asList(brandIds));
    }

}
