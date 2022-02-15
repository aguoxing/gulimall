package com.gulimall.member.service.impl;

import java.util.Arrays;
import java.util.List;
import com.gulimall.common.core.utils.DateUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.member.mapper.MemberCollectSpuMapper;
import com.gulimall.member.domain.MemberCollectSpu;
import com.gulimall.member.service.IMemberCollectSpuService;

/**
 * 会员收藏的商品Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class MemberCollectSpuServiceImpl extends ServiceImpl<MemberCollectSpuMapper, MemberCollectSpu> implements IMemberCollectSpuService {
    @Autowired
    private MemberCollectSpuMapper memberCollectSpuMapper;

    /**
     * 查询会员收藏的商品
     * 
     * @param id 会员收藏的商品主键
     * @return 会员收藏的商品
     */
    @Override
    public MemberCollectSpu selectMemberCollectSpuById(Long id) {
        return memberCollectSpuMapper.selectById(id);
    }

    /**
     * 查询会员收藏的商品列表
     * 
     * @param memberCollectSpu 会员收藏的商品
     * @return 会员收藏的商品
     */
    @Override
    public List<MemberCollectSpu> selectMemberCollectSpuList(MemberCollectSpu memberCollectSpu) {
        return memberCollectSpuMapper.selectMemberCollectSpuList(memberCollectSpu);
    }

    /**
     * 新增会员收藏的商品
     * 
     * @param memberCollectSpu 会员收藏的商品
     * @return 结果
     */
    @Override
    public int insertMemberCollectSpu(MemberCollectSpu memberCollectSpu) {
        memberCollectSpu.setCreateTime(DateUtils.getNowDate());
        return memberCollectSpuMapper.insert(memberCollectSpu);
    }

    /**
     * 修改会员收藏的商品
     * 
     * @param memberCollectSpu 会员收藏的商品
     * @return 结果
     */
    @Override
    public int updateMemberCollectSpu(MemberCollectSpu memberCollectSpu) {
        return memberCollectSpuMapper.updateById(memberCollectSpu);
    }

    /**
     * 批量删除会员收藏的商品
     * 
     * @param ids 需要删除的会员收藏的商品主键
     * @return 结果
     */
    @Override
    public int deleteMemberCollectSpuByIds(Long[] ids) {
        return memberCollectSpuMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
