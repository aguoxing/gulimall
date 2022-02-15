package com.gulimall.member.service;

import java.util.List;
import com.gulimall.member.domain.MemberLoginLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 会员登录记录Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface IMemberLoginLogService extends IService<MemberLoginLog> {
    /**
     * 查询会员登录记录
     *
     * @param id 会员登录记录主键
     * @return 会员登录记录
     */
    MemberLoginLog selectMemberLoginLogById(Long id);

    /**
     * 查询会员登录记录列表
     * 
     * @param memberLoginLog 会员登录记录
     * @return 会员登录记录集合
     */
    List<MemberLoginLog> selectMemberLoginLogList(MemberLoginLog memberLoginLog);

    /**
     * 新增会员登录记录
     * 
     * @param memberLoginLog 会员登录记录
     * @return 结果
     */
    int insertMemberLoginLog(MemberLoginLog memberLoginLog);

    /**
     * 修改会员登录记录
     * 
     * @param memberLoginLog 会员登录记录
     * @return 结果
     */
    int updateMemberLoginLog(MemberLoginLog memberLoginLog);

    /**
     * 批量删除会员登录记录
     * 
     * @param ids 需要删除的会员登录记录主键集合
     * @return 结果
     */
    int deleteMemberLoginLogByIds(Long[] ids);

}
