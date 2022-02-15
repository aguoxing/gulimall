package com.gulimall.member.service;

import java.util.List;
import com.gulimall.member.domain.MemberReceiveAddress;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 会员收货地址Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface IMemberReceiveAddressService extends IService<MemberReceiveAddress> {
    /**
     * 查询会员收货地址
     *
     * @param id 会员收货地址主键
     * @return 会员收货地址
     */
    MemberReceiveAddress selectMemberReceiveAddressById(Long id);

    /**
     * 查询会员收货地址列表
     * 
     * @param memberReceiveAddress 会员收货地址
     * @return 会员收货地址集合
     */
    List<MemberReceiveAddress> selectMemberReceiveAddressList(MemberReceiveAddress memberReceiveAddress);

    /**
     * 新增会员收货地址
     * 
     * @param memberReceiveAddress 会员收货地址
     * @return 结果
     */
    int insertMemberReceiveAddress(MemberReceiveAddress memberReceiveAddress);

    /**
     * 修改会员收货地址
     * 
     * @param memberReceiveAddress 会员收货地址
     * @return 结果
     */
    int updateMemberReceiveAddress(MemberReceiveAddress memberReceiveAddress);

    /**
     * 批量删除会员收货地址
     * 
     * @param ids 需要删除的会员收货地址主键集合
     * @return 结果
     */
    int deleteMemberReceiveAddressByIds(Long[] ids);

}
