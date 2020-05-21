package com.atom.beanvalidator.dto;

import com.atom.beanvalidator.annotation.EqualsFields;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Atom
 */
@Data
@EqualsFields(baseField = "password", matchField = "confirmedPassword", message = "密码和确认密码必须一致")
public class UserSignUpFormDTO {

    @NotBlank(message = "请输入用户名")
    private String userName;
//    @NotBlank(message = "请输入密码")
    private String password;
//    @NotBlank(message = "请输入确认密码")
    private String confirmedPassword;

}
