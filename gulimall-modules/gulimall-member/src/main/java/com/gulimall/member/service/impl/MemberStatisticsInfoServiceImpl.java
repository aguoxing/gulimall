package com.gulimall.member.service.impl;

import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.member.mapper.MemberStatisticsInfoMapper;
import com.gulimall.member.domain.MemberStatisticsInfo;
import com.gulimall.member.service.IMemberStatisticsInfoService;

/**
 * 会员统计信息Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class MemberStatisticsInfoServiceImpl extends ServiceImpl<MemberStatisticsInfoMapper, MemberStatisticsInfo> implements IMemberStatisticsInfoService {
    @Autowired
    private MemberStatisticsInfoMapper memberStatisticsInfoMapper;

    /**
     * 查询会员统计信息
     * 
     * @param id 会员统计信息主键
     * @return 会员统计信息
     */
    @Override
    public MemberStatisticsInfo selectMemberStatisticsInfoById(Long id) {
        return memberStatisticsInfoMapper.selectById(id);
    }

    /**
     * 查询会员统计信息列表
     * 
     * @param memberStatisticsInfo 会员统计信息
     * @return 会员统计信息
     */
    @Override
    public List<MemberStatisticsInfo> selectMemberStatisticsInfoList(MemberStatisticsInfo memberStatisticsInfo) {
        return memberStatisticsInfoMapper.selectMemberStatisticsInfoList(memberStatisticsInfo);
    }

    /**
     * 新增会员统计信息
     * 
     * @param memberStatisticsInfo 会员统计信息
     * @return 结果
     */
    @Override
    public int insertMemberStatisticsInfo(MemberStatisticsInfo memberStatisticsInfo) {
        return memberStatisticsInfoMapper.insert(memberStatisticsInfo);
    }

    /**
     * 修改会员统计信息
     * 
     * @param memberStatisticsInfo 会员统计信息
     * @return 结果
     */
    @Override
    public int updateMemberStatisticsInfo(MemberStatisticsInfo memberStatisticsInfo) {
        return memberStatisticsInfoMapper.updateById(memberStatisticsInfo);
    }

    /**
     * 批量删除会员统计信息
     * 
     * @param ids 需要删除的会员统计信息主键
     * @return 结果
     */
    @Override
    public int deleteMemberStatisticsInfoByIds(Long[] ids) {
        return memberStatisticsInfoMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
