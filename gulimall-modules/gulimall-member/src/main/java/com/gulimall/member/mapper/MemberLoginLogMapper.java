package com.gulimall.member.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.member.domain.MemberLoginLog;

/**
 * 会员登录记录Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface MemberLoginLogMapper extends BaseMapper<MemberLoginLog> {

    /**
     * 查询会员登录记录列表
     * 
     * @param memberLoginLog 会员登录记录
     * @return 会员登录记录集合
     */
    List<MemberLoginLog> selectMemberLoginLogList(MemberLoginLog memberLoginLog);

}
