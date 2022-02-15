package com.gulimall.member.service.impl;

import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.member.mapper.MemberCollectSubjectMapper;
import com.gulimall.member.domain.MemberCollectSubject;
import com.gulimall.member.service.IMemberCollectSubjectService;

/**
 * 会员收藏的专题活动Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class MemberCollectSubjectServiceImpl extends ServiceImpl<MemberCollectSubjectMapper, MemberCollectSubject> implements IMemberCollectSubjectService {
    @Autowired
    private MemberCollectSubjectMapper memberCollectSubjectMapper;

    /**
     * 查询会员收藏的专题活动
     * 
     * @param id 会员收藏的专题活动主键
     * @return 会员收藏的专题活动
     */
    @Override
    public MemberCollectSubject selectMemberCollectSubjectById(Long id) {
        return memberCollectSubjectMapper.selectById(id);
    }

    /**
     * 查询会员收藏的专题活动列表
     * 
     * @param memberCollectSubject 会员收藏的专题活动
     * @return 会员收藏的专题活动
     */
    @Override
    public List<MemberCollectSubject> selectMemberCollectSubjectList(MemberCollectSubject memberCollectSubject) {
        return memberCollectSubjectMapper.selectMemberCollectSubjectList(memberCollectSubject);
    }

    /**
     * 新增会员收藏的专题活动
     * 
     * @param memberCollectSubject 会员收藏的专题活动
     * @return 结果
     */
    @Override
    public int insertMemberCollectSubject(MemberCollectSubject memberCollectSubject) {
        return memberCollectSubjectMapper.insert(memberCollectSubject);
    }

    /**
     * 修改会员收藏的专题活动
     * 
     * @param memberCollectSubject 会员收藏的专题活动
     * @return 结果
     */
    @Override
    public int updateMemberCollectSubject(MemberCollectSubject memberCollectSubject) {
        return memberCollectSubjectMapper.updateById(memberCollectSubject);
    }

    /**
     * 批量删除会员收藏的专题活动
     * 
     * @param ids 需要删除的会员收藏的专题活动主键
     * @return 结果
     */
    @Override
    public int deleteMemberCollectSubjectByIds(Long[] ids) {
        return memberCollectSubjectMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
