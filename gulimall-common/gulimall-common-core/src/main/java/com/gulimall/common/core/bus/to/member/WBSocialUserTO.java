package com.gulimall.common.core.bus.to.member;

import lombok.Data;

/**
 * @author admin
 * 微博社交登录TO
 */
@Data
public class WBSocialUserTO {
    // 微博
    private String accessToken;
    private String remindIn;
    private long expiresIn;
    private String uid;
    private String isRealName;

}
