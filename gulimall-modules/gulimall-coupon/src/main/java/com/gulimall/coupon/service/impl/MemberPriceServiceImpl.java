package com.gulimall.coupon.service.impl;

import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.coupon.mapper.MemberPriceMapper;
import com.gulimall.coupon.domain.MemberPrice;
import com.gulimall.coupon.service.IMemberPriceService;

/**
 * 商品会员价格Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class MemberPriceServiceImpl extends ServiceImpl<MemberPriceMapper, MemberPrice> implements IMemberPriceService {
    @Autowired
    private MemberPriceMapper memberPriceMapper;

    /**
     * 查询商品会员价格
     * 
     * @param id 商品会员价格主键
     * @return 商品会员价格
     */
    @Override
    public MemberPrice selectMemberPriceById(Long id) {
        return memberPriceMapper.selectById(id);
    }

    /**
     * 查询商品会员价格列表
     * 
     * @param memberPrice 商品会员价格
     * @return 商品会员价格
     */
    @Override
    public List<MemberPrice> selectMemberPriceList(MemberPrice memberPrice) {
        return memberPriceMapper.selectMemberPriceList(memberPrice);
    }

    /**
     * 新增商品会员价格
     * 
     * @param memberPrice 商品会员价格
     * @return 结果
     */
    @Override
    public int insertMemberPrice(MemberPrice memberPrice) {
        return memberPriceMapper.insert(memberPrice);
    }

    /**
     * 修改商品会员价格
     * 
     * @param memberPrice 商品会员价格
     * @return 结果
     */
    @Override
    public int updateMemberPrice(MemberPrice memberPrice) {
        return memberPriceMapper.updateById(memberPrice);
    }

    /**
     * 批量删除商品会员价格
     * 
     * @param ids 需要删除的商品会员价格主键
     * @return 结果
     */
    @Override
    public int deleteMemberPriceByIds(Long[] ids) {
        return memberPriceMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
