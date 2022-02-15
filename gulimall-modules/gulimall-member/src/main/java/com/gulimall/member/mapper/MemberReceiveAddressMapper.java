package com.gulimall.member.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.member.domain.MemberReceiveAddress;

/**
 * 会员收货地址Mapper接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface MemberReceiveAddressMapper extends BaseMapper<MemberReceiveAddress> {

    /**
     * 查询会员收货地址列表
     * 
     * @param memberReceiveAddress 会员收货地址
     * @return 会员收货地址集合
     */
    List<MemberReceiveAddress> selectMemberReceiveAddressList(MemberReceiveAddress memberReceiveAddress);

}
