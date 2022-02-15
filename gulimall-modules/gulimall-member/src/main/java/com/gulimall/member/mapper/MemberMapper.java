package com.gulimall.member.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.member.domain.Member;

/**
 * 会员Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface MemberMapper extends BaseMapper<Member> {

    /**
     * 查询会员列表
     * 
     * @param member 会员
     * @return 会员集合
     */
    List<Member> selectMemberList(Member member);

}
