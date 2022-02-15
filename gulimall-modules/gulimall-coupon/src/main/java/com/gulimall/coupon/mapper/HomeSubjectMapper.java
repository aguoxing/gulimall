package com.gulimall.coupon.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.coupon.domain.HomeSubject;

/**
 * 首页专题Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface HomeSubjectMapper extends BaseMapper<HomeSubject> {

    /**
     * 查询首页专题列表
     * 
     * @param homeSubject 首页专题
     * @return 首页专题集合
     */
    List<HomeSubject> selectHomeSubjectList(HomeSubject homeSubject);

}
