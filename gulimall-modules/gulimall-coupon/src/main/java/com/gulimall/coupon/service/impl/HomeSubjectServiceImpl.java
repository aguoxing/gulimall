package com.gulimall.coupon.service.impl;

import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.coupon.mapper.HomeSubjectMapper;
import com.gulimall.coupon.domain.HomeSubject;
import com.gulimall.coupon.service.IHomeSubjectService;

/**
 * 首页专题Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class HomeSubjectServiceImpl extends ServiceImpl<HomeSubjectMapper, HomeSubject> implements IHomeSubjectService {
    @Autowired
    private HomeSubjectMapper homeSubjectMapper;

    /**
     * 查询首页专题
     * 
     * @param id 首页专题主键
     * @return 首页专题
     */
    @Override
    public HomeSubject selectHomeSubjectById(Long id) {
        return homeSubjectMapper.selectById(id);
    }

    /**
     * 查询首页专题列表
     * 
     * @param homeSubject 首页专题
     * @return 首页专题
     */
    @Override
    public List<HomeSubject> selectHomeSubjectList(HomeSubject homeSubject) {
        return homeSubjectMapper.selectHomeSubjectList(homeSubject);
    }

    /**
     * 新增首页专题
     * 
     * @param homeSubject 首页专题
     * @return 结果
     */
    @Override
    public int insertHomeSubject(HomeSubject homeSubject) {
        return homeSubjectMapper.insert(homeSubject);
    }

    /**
     * 修改首页专题
     * 
     * @param homeSubject 首页专题
     * @return 结果
     */
    @Override
    public int updateHomeSubject(HomeSubject homeSubject) {
        return homeSubjectMapper.updateById(homeSubject);
    }

    /**
     * 批量删除首页专题
     * 
     * @param ids 需要删除的首页专题主键
     * @return 结果
     */
    @Override
    public int deleteHomeSubjectByIds(Long[] ids) {
        return homeSubjectMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
