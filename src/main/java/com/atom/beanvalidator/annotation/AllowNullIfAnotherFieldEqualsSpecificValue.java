package com.atom.beanvalidator.annotation;

import com.atom.beanvalidator.validator.AllowNullIfAnotherFieldEqualsSpecificValueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 如果另一个字段（anotherFieldName）的值等于指定的值（specificValue），
 * 则当前字段（dependOnField）可为空
 *
 * @author Atom
 */
@Target(ElementType.TYPE)
@Documented
@Retention(RUNTIME)
@Constraint(validatedBy = {AllowNullIfAnotherFieldEqualsSpecificValueValidator.class})
public @interface AllowNullIfAnotherFieldEqualsSpecificValue {

    String message() default "";

    /**
     * 指定字段名
     *
     * @return
     */
    String anotherFieldName();

    /**
     * 指定值
     *
     * @return
     */
    String specificValue();

    /**
     * 依赖字段
     *
     * @return
     */
    String dependOnField();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
