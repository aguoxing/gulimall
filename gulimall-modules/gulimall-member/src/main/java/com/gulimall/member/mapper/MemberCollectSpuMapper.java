package com.gulimall.member.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.member.domain.MemberCollectSpu;

/**
 * 会员收藏的商品Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface MemberCollectSpuMapper extends BaseMapper<MemberCollectSpu> {

    /**
     * 查询会员收藏的商品列表
     * 
     * @param memberCollectSpu 会员收藏的商品
     * @return 会员收藏的商品集合
     */
    List<MemberCollectSpu> selectMemberCollectSpuList(MemberCollectSpu memberCollectSpu);

}
