package com.gulimall.coupon.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.coupon.domain.HomeAdv;

/**
 * 首页轮播广告Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface HomeAdvMapper extends BaseMapper<HomeAdv> {

    /**
     * 查询首页轮播广告列表
     * 
     * @param homeAdv 首页轮播广告
     * @return 首页轮播广告集合
     */
    List<HomeAdv> selectHomeAdvList(HomeAdv homeAdv);

}
