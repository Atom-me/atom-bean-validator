package com.atom.beanvalidator.dto;

import com.atom.beanvalidator.validategroup.ValidateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @author Atom
 */
@Data
public class Employee {

    /**
     * 员工ID 使用分组校验的方式实现
     * 在新增的时候ID必须为空
     * 在更新的时候ID不能为空
     */
    @Null(groups = ValidateGroup.AddGroup.class)
    @NotNull(groups = ValidateGroup.UpdateGroup.class)
    private Integer id;
    /**
     * 员工姓名
     */
    @NotBlank
    private String name;
}
