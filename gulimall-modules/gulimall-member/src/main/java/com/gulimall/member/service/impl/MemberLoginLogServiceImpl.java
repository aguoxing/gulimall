package com.gulimall.member.service.impl;

import java.util.Arrays;
import java.util.List;
import com.gulimall.common.core.utils.DateUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.member.mapper.MemberLoginLogMapper;
import com.gulimall.member.domain.MemberLoginLog;
import com.gulimall.member.service.IMemberLoginLogService;

/**
 * 会员登录记录Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class MemberLoginLogServiceImpl extends ServiceImpl<MemberLoginLogMapper, MemberLoginLog> implements IMemberLoginLogService {
    @Autowired
    private MemberLoginLogMapper memberLoginLogMapper;

    /**
     * 查询会员登录记录
     * 
     * @param id 会员登录记录主键
     * @return 会员登录记录
     */
    @Override
    public MemberLoginLog selectMemberLoginLogById(Long id) {
        return memberLoginLogMapper.selectById(id);
    }

    /**
     * 查询会员登录记录列表
     * 
     * @param memberLoginLog 会员登录记录
     * @return 会员登录记录
     */
    @Override
    public List<MemberLoginLog> selectMemberLoginLogList(MemberLoginLog memberLoginLog) {
        return memberLoginLogMapper.selectMemberLoginLogList(memberLoginLog);
    }

    /**
     * 新增会员登录记录
     * 
     * @param memberLoginLog 会员登录记录
     * @return 结果
     */
    @Override
    public int insertMemberLoginLog(MemberLoginLog memberLoginLog) {
        memberLoginLog.setCreateTime(DateUtils.getNowDate());
        return memberLoginLogMapper.insert(memberLoginLog);
    }

    /**
     * 修改会员登录记录
     * 
     * @param memberLoginLog 会员登录记录
     * @return 结果
     */
    @Override
    public int updateMemberLoginLog(MemberLoginLog memberLoginLog) {
        return memberLoginLogMapper.updateById(memberLoginLog);
    }

    /**
     * 批量删除会员登录记录
     * 
     * @param ids 需要删除的会员登录记录主键
     * @return 结果
     */
    @Override
    public int deleteMemberLoginLogByIds(Long[] ids) {
        return memberLoginLogMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
