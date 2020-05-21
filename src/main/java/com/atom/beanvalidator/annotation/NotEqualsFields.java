package com.atom.beanvalidator.annotation;

import com.atom.beanvalidator.validator.NotEqualsFieldsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 校验两个属性不能相等
 * baseField = null ,matchField = null 校验通过
 * baseField = "" ,  matchField = "" 校验通过
 * baseField = "abc" ,matchField = null 校验通过
 * baseField = "abc" ,matchField = "abc" 校验不通过
 *
 * @author Atom
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {NotEqualsFieldsValidator.class})
public @interface NotEqualsFields {

    String message() default "";

    String baseField();

    String matchField();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
