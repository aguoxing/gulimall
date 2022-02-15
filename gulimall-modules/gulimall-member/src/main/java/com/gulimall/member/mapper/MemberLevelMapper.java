package com.gulimall.member.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.member.domain.MemberLevel;

/**
 * 会员等级Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface MemberLevelMapper extends BaseMapper<MemberLevel> {

    /**
     * 查询会员等级列表
     * 
     * @param memberLevel 会员等级
     * @return 会员等级集合
     */
    List<MemberLevel> selectMemberLevelList(MemberLevel memberLevel);

}
