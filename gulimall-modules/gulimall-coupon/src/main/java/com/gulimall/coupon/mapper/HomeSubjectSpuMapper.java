package com.gulimall.coupon.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.coupon.domain.HomeSubjectSpu;

/**
 * 专题商品Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface HomeSubjectSpuMapper extends BaseMapper<HomeSubjectSpu> {

    /**
     * 查询专题商品列表
     * 
     * @param homeSubjectSpu 专题商品
     * @return 专题商品集合
     */
    List<HomeSubjectSpu> selectHomeSubjectSpuList(HomeSubjectSpu homeSubjectSpu);

}
