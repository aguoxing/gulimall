package com.gulimall.member.service.impl;

import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.member.mapper.MemberLevelMapper;
import com.gulimall.member.domain.MemberLevel;
import com.gulimall.member.service.IMemberLevelService;

/**
 * 会员等级Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class MemberLevelServiceImpl extends ServiceImpl<MemberLevelMapper, MemberLevel> implements IMemberLevelService {
    @Autowired
    private MemberLevelMapper memberLevelMapper;

    /**
     * 查询会员等级
     * 
     * @param id 会员等级主键
     * @return 会员等级
     */
    @Override
    public MemberLevel selectMemberLevelById(Long id) {
        return memberLevelMapper.selectById(id);
    }

    /**
     * 查询会员等级列表
     * 
     * @param memberLevel 会员等级
     * @return 会员等级
     */
    @Override
    public List<MemberLevel> selectMemberLevelList(MemberLevel memberLevel) {
        return memberLevelMapper.selectMemberLevelList(memberLevel);
    }

    /**
     * 新增会员等级
     * 
     * @param memberLevel 会员等级
     * @return 结果
     */
    @Override
    public int insertMemberLevel(MemberLevel memberLevel) {
        return memberLevelMapper.insert(memberLevel);
    }

    /**
     * 修改会员等级
     * 
     * @param memberLevel 会员等级
     * @return 结果
     */
    @Override
    public int updateMemberLevel(MemberLevel memberLevel) {
        return memberLevelMapper.updateById(memberLevel);
    }

    /**
     * 批量删除会员等级
     * 
     * @param ids 需要删除的会员等级主键
     * @return 结果
     */
    @Override
    public int deleteMemberLevelByIds(Long[] ids) {
        return memberLevelMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
