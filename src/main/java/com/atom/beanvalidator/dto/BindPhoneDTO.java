package com.atom.beanvalidator.dto;

import com.atom.beanvalidator.annotation.NotEqualsFields;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Atom
 */
@Data
@NotEqualsFields(baseField = "masterMobile", matchField = "spouseMobile", message = "主户籍手机号和配偶户籍手机号不能相同")
public class BindPhoneDTO {
    @NotNull(message = "userId不能为空！")
    private Long userId;
    private String masterMobile;
    private String spouseMobile;
}
