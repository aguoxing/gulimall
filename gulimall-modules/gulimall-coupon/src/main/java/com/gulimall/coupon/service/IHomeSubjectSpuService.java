package com.gulimall.coupon.service;

import java.util.List;
import com.gulimall.coupon.domain.HomeSubjectSpu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 专题商品Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface IHomeSubjectSpuService extends IService<HomeSubjectSpu> {
    /**
     * 查询专题商品
     *
     * @param id 专题商品主键
     * @return 专题商品
     */
    HomeSubjectSpu selectHomeSubjectSpuById(Long id);

    /**
     * 查询专题商品列表
     * 
     * @param homeSubjectSpu 专题商品
     * @return 专题商品集合
     */
    List<HomeSubjectSpu> selectHomeSubjectSpuList(HomeSubjectSpu homeSubjectSpu);

    /**
     * 新增专题商品
     * 
     * @param homeSubjectSpu 专题商品
     * @return 结果
     */
    int insertHomeSubjectSpu(HomeSubjectSpu homeSubjectSpu);

    /**
     * 修改专题商品
     * 
     * @param homeSubjectSpu 专题商品
     * @return 结果
     */
    int updateHomeSubjectSpu(HomeSubjectSpu homeSubjectSpu);

    /**
     * 批量删除专题商品
     * 
     * @param ids 需要删除的专题商品主键集合
     * @return 结果
     */
    int deleteHomeSubjectSpuByIds(Long[] ids);

}
