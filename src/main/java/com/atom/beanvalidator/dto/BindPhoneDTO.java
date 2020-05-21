package com.atom.beanvalidator.dto;

import com.atom.beanvalidator.annotation.NotEqualsFields;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author Atom
 */
@Data
@NotEqualsFields(baseField = "masterMobile", matchField = "spouseMobile", message = "主户籍手机号和配偶户籍手机号不能相同")
public class BindPhoneDTO {
    @NotNull(message = "userId不能为空！")
    private Long userId;
    @Pattern(regexp = "^(13|14|15|16|17|18|19)[0-9]{9}$", message = "手机号格式不正确")
    private String masterMobile;
    private String spouseMobile;
}
