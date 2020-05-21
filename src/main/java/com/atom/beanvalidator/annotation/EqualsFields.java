package com.atom.beanvalidator.annotation;

import com.atom.beanvalidator.validator.EqualsFieldsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 校验两个属性必须相等
 * baseField = null ,matchField = null 校验通过
 * baseField = "abc" ,matchField = "abc" 校验通过
 * baseField = "" ,  matchField = null 校验不通过
 * baseField = "abc" ,matchField = null 校验不通过
 *
 * @author Atom
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {EqualsFieldsValidator.class})
public @interface EqualsFields {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String baseField();

    String matchField();
}
