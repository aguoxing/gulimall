package com.gulimall.member.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.member.domain.MemberStatisticsInfo;

/**
 * 会员统计信息Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface MemberStatisticsInfoMapper extends BaseMapper<MemberStatisticsInfo> {

    /**
     * 查询会员统计信息列表
     * 
     * @param memberStatisticsInfo 会员统计信息
     * @return 会员统计信息集合
     */
    List<MemberStatisticsInfo> selectMemberStatisticsInfoList(MemberStatisticsInfo memberStatisticsInfo);

}
