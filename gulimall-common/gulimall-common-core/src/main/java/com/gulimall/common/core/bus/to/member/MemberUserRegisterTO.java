package com.gulimall.common.core.bus.to.member;

import lombok.Data;

/**
 * @author admin
 * 会员注册VO
 */
@Data
public class MemberUserRegisterTO {
    private String userName;
    private String password;
    private String phone;
}
