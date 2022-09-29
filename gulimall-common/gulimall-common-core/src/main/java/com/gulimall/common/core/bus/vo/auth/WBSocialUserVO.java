package com.gulimall.common.core.bus.vo.auth;

import lombok.Data;

/**
 * @author admin
 * 微博授权结果VO
 * 使用code换取Access Token返回结果
 */
@Data
public class WBSocialUserVO {
    private String access_token;
    private String remind_in;
    private long expires_in;
    private String uid;
    private String isRealName;
}
