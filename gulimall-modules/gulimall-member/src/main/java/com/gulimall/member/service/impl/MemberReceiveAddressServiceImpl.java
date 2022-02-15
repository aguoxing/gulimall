package com.gulimall.member.service.impl;

import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.member.mapper.MemberReceiveAddressMapper;
import com.gulimall.member.domain.MemberReceiveAddress;
import com.gulimall.member.service.IMemberReceiveAddressService;

/**
 * 会员收货地址Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class MemberReceiveAddressServiceImpl extends ServiceImpl<MemberReceiveAddressMapper, MemberReceiveAddress> implements IMemberReceiveAddressService {
    @Autowired
    private MemberReceiveAddressMapper memberReceiveAddressMapper;

    /**
     * 查询会员收货地址
     * 
     * @param id 会员收货地址主键
     * @return 会员收货地址
     */
    @Override
    public MemberReceiveAddress selectMemberReceiveAddressById(Long id) {
        return memberReceiveAddressMapper.selectById(id);
    }

    /**
     * 查询会员收货地址列表
     * 
     * @param memberReceiveAddress 会员收货地址
     * @return 会员收货地址
     */
    @Override
    public List<MemberReceiveAddress> selectMemberReceiveAddressList(MemberReceiveAddress memberReceiveAddress) {
        return memberReceiveAddressMapper.selectMemberReceiveAddressList(memberReceiveAddress);
    }

    /**
     * 新增会员收货地址
     * 
     * @param memberReceiveAddress 会员收货地址
     * @return 结果
     */
    @Override
    public int insertMemberReceiveAddress(MemberReceiveAddress memberReceiveAddress) {
        return memberReceiveAddressMapper.insert(memberReceiveAddress);
    }

    /**
     * 修改会员收货地址
     * 
     * @param memberReceiveAddress 会员收货地址
     * @return 结果
     */
    @Override
    public int updateMemberReceiveAddress(MemberReceiveAddress memberReceiveAddress) {
        return memberReceiveAddressMapper.updateById(memberReceiveAddress);
    }

    /**
     * 批量删除会员收货地址
     * 
     * @param ids 需要删除的会员收货地址主键
     * @return 结果
     */
    @Override
    public int deleteMemberReceiveAddressByIds(Long[] ids) {
        return memberReceiveAddressMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
