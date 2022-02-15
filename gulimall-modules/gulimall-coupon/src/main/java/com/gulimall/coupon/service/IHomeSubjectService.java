package com.gulimall.coupon.service;

import java.util.List;
import com.gulimall.coupon.domain.HomeSubject;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 首页专题Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface IHomeSubjectService extends IService<HomeSubject> {
    /**
     * 查询首页专题
     *
     * @param id 首页专题主键
     * @return 首页专题
     */
    HomeSubject selectHomeSubjectById(Long id);

    /**
     * 查询首页专题列表
     * 
     * @param homeSubject 首页专题
     * @return 首页专题集合
     */
    List<HomeSubject> selectHomeSubjectList(HomeSubject homeSubject);

    /**
     * 新增首页专题
     * 
     * @param homeSubject 首页专题
     * @return 结果
     */
    int insertHomeSubject(HomeSubject homeSubject);

    /**
     * 修改首页专题
     * 
     * @param homeSubject 首页专题
     * @return 结果
     */
    int updateHomeSubject(HomeSubject homeSubject);

    /**
     * 批量删除首页专题
     * 
     * @param ids 需要删除的首页专题主键集合
     * @return 结果
     */
    int deleteHomeSubjectByIds(Long[] ids);

}
