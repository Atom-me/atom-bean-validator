package com.atom.beanvalidator.enums;

import lombok.Getter;

/**
 * 仅作微信SSO登录入参校验使用
 * 不要新增和修改
 *
 * @author Atom
 */
public enum WeChatAuthEnum {

    /**
     * 需要获取基本信息
     */
    BASEINFO("baseInfo", "snsapi_base", "需要获取基本信息"),
    /**
     * 需要获取用户信息
     */
    USERINFO("baseInfo", "snsapi_userinfo", "需要获取用户信息"),
    ;

    @Getter
    private String type;
    /**
     * 对应微信网页授权scope
     */
    @Getter
    private String scope;
    @Getter
    private String desc;

    WeChatAuthEnum(String type, String scope, String desc) {
        this.type = type;
        this.scope = scope;
        this.desc = desc;
    }
}
