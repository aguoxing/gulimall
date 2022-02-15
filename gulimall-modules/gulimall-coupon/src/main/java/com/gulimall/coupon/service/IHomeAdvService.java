package com.gulimall.coupon.service;

import java.util.List;
import com.gulimall.coupon.domain.HomeAdv;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 首页轮播广告Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface IHomeAdvService extends IService<HomeAdv> {
    /**
     * 查询首页轮播广告
     *
     * @param id 首页轮播广告主键
     * @return 首页轮播广告
     */
    HomeAdv selectHomeAdvById(Long id);

    /**
     * 查询首页轮播广告列表
     * 
     * @param homeAdv 首页轮播广告
     * @return 首页轮播广告集合
     */
    List<HomeAdv> selectHomeAdvList(HomeAdv homeAdv);

    /**
     * 新增首页轮播广告
     * 
     * @param homeAdv 首页轮播广告
     * @return 结果
     */
    int insertHomeAdv(HomeAdv homeAdv);

    /**
     * 修改首页轮播广告
     * 
     * @param homeAdv 首页轮播广告
     * @return 结果
     */
    int updateHomeAdv(HomeAdv homeAdv);

    /**
     * 批量删除首页轮播广告
     * 
     * @param ids 需要删除的首页轮播广告主键集合
     * @return 结果
     */
    int deleteHomeAdvByIds(Long[] ids);

}
