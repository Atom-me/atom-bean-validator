package com.atom.beanvalidator.annotation;


import com.atom.beanvalidator.validator.FieldListNotAllowAllBlankValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 校验对象指定多个属性不能同时为空（多个属性至少有一个不为空）
 *
 * @author Atom
 */
@Target({TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {FieldListNotAllowAllBlankValidator.class})
public @interface FieldListNotAllowAllBlank {

    String message() default "";

    String[] fields();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
