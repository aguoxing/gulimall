package com.gulimall.coupon.service.impl;

import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.coupon.mapper.HomeSubjectSpuMapper;
import com.gulimall.coupon.domain.HomeSubjectSpu;
import com.gulimall.coupon.service.IHomeSubjectSpuService;

/**
 * 专题商品Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class HomeSubjectSpuServiceImpl extends ServiceImpl<HomeSubjectSpuMapper, HomeSubjectSpu> implements IHomeSubjectSpuService {
    @Autowired
    private HomeSubjectSpuMapper homeSubjectSpuMapper;

    /**
     * 查询专题商品
     * 
     * @param id 专题商品主键
     * @return 专题商品
     */
    @Override
    public HomeSubjectSpu selectHomeSubjectSpuById(Long id) {
        return homeSubjectSpuMapper.selectById(id);
    }

    /**
     * 查询专题商品列表
     * 
     * @param homeSubjectSpu 专题商品
     * @return 专题商品
     */
    @Override
    public List<HomeSubjectSpu> selectHomeSubjectSpuList(HomeSubjectSpu homeSubjectSpu) {
        return homeSubjectSpuMapper.selectHomeSubjectSpuList(homeSubjectSpu);
    }

    /**
     * 新增专题商品
     * 
     * @param homeSubjectSpu 专题商品
     * @return 结果
     */
    @Override
    public int insertHomeSubjectSpu(HomeSubjectSpu homeSubjectSpu) {
        return homeSubjectSpuMapper.insert(homeSubjectSpu);
    }

    /**
     * 修改专题商品
     * 
     * @param homeSubjectSpu 专题商品
     * @return 结果
     */
    @Override
    public int updateHomeSubjectSpu(HomeSubjectSpu homeSubjectSpu) {
        return homeSubjectSpuMapper.updateById(homeSubjectSpu);
    }

    /**
     * 批量删除专题商品
     * 
     * @param ids 需要删除的专题商品主键
     * @return 结果
     */
    @Override
    public int deleteHomeSubjectSpuByIds(Long[] ids) {
        return homeSubjectSpuMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
