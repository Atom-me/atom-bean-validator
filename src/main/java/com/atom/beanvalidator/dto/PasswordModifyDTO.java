package com.atom.beanvalidator.dto;

import com.atom.beanvalidator.annotation.EqualsFields;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


/**
 * @author Atom
 */
@Data
@EqualsFields(baseField = "newPassword", matchField = "confirmNewPassword", message = "新密码和确认新密码必须相同！")
public class PasswordModifyDTO {


    @NotBlank(message = "userId 不能为空")
    private String userId;

    @NotBlank(message = "旧密码不能为空")
    private String oldPassword;

    @NotBlank(message = "新密码不能为空")
    @Pattern.List({
            @Pattern(regexp = "^[0-9]{6,15}$", message = "新密码必须为6到15位数字，请重新输入。"),
//            @Pattern(regexp = "([0-9])\\1{5,14}", message = "密码不可为相同数字")
    })
    private String newPassword;

    @NotBlank(message = "确认新密码不能为空")
    private String confirmNewPassword;

    @NotBlank(message = "渠道ID 不能为空")
    private String channelId;


}
