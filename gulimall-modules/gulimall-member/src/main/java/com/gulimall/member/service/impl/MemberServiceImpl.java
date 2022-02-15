package com.gulimall.member.service.impl;

import java.util.Arrays;
import java.util.List;
import com.gulimall.common.core.utils.DateUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.member.mapper.MemberMapper;
import com.gulimall.member.domain.Member;
import com.gulimall.member.service.IMemberService;

/**
 * 会员Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {
    @Autowired
    private MemberMapper memberMapper;

    /**
     * 查询会员
     * 
     * @param id 会员主键
     * @return 会员
     */
    @Override
    public Member selectMemberById(Long id) {
        return memberMapper.selectById(id);
    }

    /**
     * 查询会员列表
     * 
     * @param member 会员
     * @return 会员
     */
    @Override
    public List<Member> selectMemberList(Member member) {
        return memberMapper.selectMemberList(member);
    }

    /**
     * 新增会员
     * 
     * @param member 会员
     * @return 结果
     */
    @Override
    public int insertMember(Member member) {
        member.setCreateTime(DateUtils.getNowDate());
        return memberMapper.insert(member);
    }

    /**
     * 修改会员
     * 
     * @param member 会员
     * @return 结果
     */
    @Override
    public int updateMember(Member member) {
        return memberMapper.updateById(member);
    }

    /**
     * 批量删除会员
     * 
     * @param ids 需要删除的会员主键
     * @return 结果
     */
    @Override
    public int deleteMemberByIds(Long[] ids) {
        return memberMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
