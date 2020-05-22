package com.atom.beanvalidator.dto;

import com.atom.beanvalidator.annotation.EnumValueLimit;
import com.atom.beanvalidator.enums.WeChatAuthEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Atom
 */
@Data
public class TestEnumValueValidatorDTO {
    /**
     * 用户信息类型；
     * userType=baseInfo表示需要获取基本信息；
     * userType=userInfo表示需要获取用户信息；
     * 默认值是baseInfo
     */
    @EnumValueLimit(target = WeChatAuthEnum.class, message = "userType不合法!")
    private String userType;
    /**
     * 重定向的业务地址
     */
    @NotBlank(message = "redirectUrl不能为空")
    private String redirectUrl;
    /**
     * 微信公众号唯一标识；
     */
    @JsonProperty(value = "appid")
    private String appId;
}
