package com.gulimall.member.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.member.domain.MemberCollectSubject;

/**
 * 会员收藏的专题活动Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface MemberCollectSubjectMapper extends BaseMapper<MemberCollectSubject> {

    /**
     * 查询会员收藏的专题活动列表
     * 
     * @param memberCollectSubject 会员收藏的专题活动
     * @return 会员收藏的专题活动集合
     */
    List<MemberCollectSubject> selectMemberCollectSubjectList(MemberCollectSubject memberCollectSubject);

}
