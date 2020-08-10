package com.atom.beanvalidator.dto;

import com.atom.beanvalidator.annotation.AllowNullIfAnotherFieldEqualsSpecificValue;
import com.atom.beanvalidator.annotation.EqualsFields;
import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * * 场景,"initFOAPWD" 表示初始化FOA账户的密码，不需要校验旧密码
 * 即当 scene = "initFOAPWD" 的时候 不校验 oldPassword 是否为空
 *
 * @author Atom
 */
@Data
@AllowNullIfAnotherFieldEqualsSpecificValue(anotherFieldName = "scene", specificValue = "initFOAPWD", dependOnField = "oldPassword", message = "旧密码不能为空")
@EqualsFields(baseField = "newPassword", matchField = "confirmNewPassword", message = "新密码和确认新密码必须相同！")
public class PasswordModifyV1DTO {


    @NotBlank(message = "userId 不能为空")
    private String userId;

    /**
     * 旧密码
     */
    private String oldPassword;

    @NotBlank(message = "新密码不能为空")
    private String newPassword;

    @NotBlank(message = "确认新密码不能为空")
    private String confirmNewPassword;

    /**
     * 场景,"initFOAPWD" 表示初始化FOA账户的密码，不需要校验旧密码
     */
    private String scene;


}
