package com.gulimall.coupon.service.impl;

import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.coupon.mapper.HomeAdvMapper;
import com.gulimall.coupon.domain.HomeAdv;
import com.gulimall.coupon.service.IHomeAdvService;

/**
 * 首页轮播广告Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class HomeAdvServiceImpl extends ServiceImpl<HomeAdvMapper, HomeAdv> implements IHomeAdvService {
    @Autowired
    private HomeAdvMapper homeAdvMapper;

    /**
     * 查询首页轮播广告
     * 
     * @param id 首页轮播广告主键
     * @return 首页轮播广告
     */
    @Override
    public HomeAdv selectHomeAdvById(Long id) {
        return homeAdvMapper.selectById(id);
    }

    /**
     * 查询首页轮播广告列表
     * 
     * @param homeAdv 首页轮播广告
     * @return 首页轮播广告
     */
    @Override
    public List<HomeAdv> selectHomeAdvList(HomeAdv homeAdv) {
        return homeAdvMapper.selectHomeAdvList(homeAdv);
    }

    /**
     * 新增首页轮播广告
     * 
     * @param homeAdv 首页轮播广告
     * @return 结果
     */
    @Override
    public int insertHomeAdv(HomeAdv homeAdv) {
        return homeAdvMapper.insert(homeAdv);
    }

    /**
     * 修改首页轮播广告
     * 
     * @param homeAdv 首页轮播广告
     * @return 结果
     */
    @Override
    public int updateHomeAdv(HomeAdv homeAdv) {
        return homeAdvMapper.updateById(homeAdv);
    }

    /**
     * 批量删除首页轮播广告
     * 
     * @param ids 需要删除的首页轮播广告主键
     * @return 结果
     */
    @Override
    public int deleteHomeAdvByIds(Long[] ids) {
        return homeAdvMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
