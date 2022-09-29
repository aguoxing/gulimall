package com.gulimall.common.core.bus.to.member;

import lombok.Data;

/**
 * @author admin
 * 登录VO
 */
@Data
public class MemberUserLoginTO {
    private String loginacct;
    private String password;
}
