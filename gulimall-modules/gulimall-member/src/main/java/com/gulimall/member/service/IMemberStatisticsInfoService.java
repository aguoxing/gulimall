package com.gulimall.member.service;

import java.util.List;
import com.gulimall.member.domain.MemberStatisticsInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 会员统计信息Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface IMemberStatisticsInfoService extends IService<MemberStatisticsInfo> {
    /**
     * 查询会员统计信息
     *
     * @param id 会员统计信息主键
     * @return 会员统计信息
     */
    MemberStatisticsInfo selectMemberStatisticsInfoById(Long id);

    /**
     * 查询会员统计信息列表
     * 
     * @param memberStatisticsInfo 会员统计信息
     * @return 会员统计信息集合
     */
    List<MemberStatisticsInfo> selectMemberStatisticsInfoList(MemberStatisticsInfo memberStatisticsInfo);

    /**
     * 新增会员统计信息
     * 
     * @param memberStatisticsInfo 会员统计信息
     * @return 结果
     */
    int insertMemberStatisticsInfo(MemberStatisticsInfo memberStatisticsInfo);

    /**
     * 修改会员统计信息
     * 
     * @param memberStatisticsInfo 会员统计信息
     * @return 结果
     */
    int updateMemberStatisticsInfo(MemberStatisticsInfo memberStatisticsInfo);

    /**
     * 批量删除会员统计信息
     * 
     * @param ids 需要删除的会员统计信息主键集合
     * @return 结果
     */
    int deleteMemberStatisticsInfoByIds(Long[] ids);

}
