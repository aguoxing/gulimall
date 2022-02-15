package com.gulimall.member.service;

import java.util.List;
import com.gulimall.member.domain.MemberCollectSpu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 会员收藏的商品Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface IMemberCollectSpuService extends IService<MemberCollectSpu> {
    /**
     * 查询会员收藏的商品
     *
     * @param id 会员收藏的商品主键
     * @return 会员收藏的商品
     */
    MemberCollectSpu selectMemberCollectSpuById(Long id);

    /**
     * 查询会员收藏的商品列表
     * 
     * @param memberCollectSpu 会员收藏的商品
     * @return 会员收藏的商品集合
     */
    List<MemberCollectSpu> selectMemberCollectSpuList(MemberCollectSpu memberCollectSpu);

    /**
     * 新增会员收藏的商品
     * 
     * @param memberCollectSpu 会员收藏的商品
     * @return 结果
     */
    int insertMemberCollectSpu(MemberCollectSpu memberCollectSpu);

    /**
     * 修改会员收藏的商品
     * 
     * @param memberCollectSpu 会员收藏的商品
     * @return 结果
     */
    int updateMemberCollectSpu(MemberCollectSpu memberCollectSpu);

    /**
     * 批量删除会员收藏的商品
     * 
     * @param ids 需要删除的会员收藏的商品主键集合
     * @return 结果
     */
    int deleteMemberCollectSpuByIds(Long[] ids);

}
