package com.gulimall.member.service;

import java.util.List;
import com.gulimall.member.domain.Member;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 会员Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface IMemberService extends IService<Member> {
    /**
     * 查询会员
     *
     * @param id 会员主键
     * @return 会员
     */
    Member selectMemberById(Long id);

    /**
     * 查询会员列表
     * 
     * @param member 会员
     * @return 会员集合
     */
    List<Member> selectMemberList(Member member);

    /**
     * 新增会员
     * 
     * @param member 会员
     * @return 结果
     */
    int insertMember(Member member);

    /**
     * 修改会员
     * 
     * @param member 会员
     * @return 结果
     */
    int updateMember(Member member);

    /**
     * 批量删除会员
     * 
     * @param ids 需要删除的会员主键集合
     * @return 结果
     */
    int deleteMemberByIds(Long[] ids);

}
