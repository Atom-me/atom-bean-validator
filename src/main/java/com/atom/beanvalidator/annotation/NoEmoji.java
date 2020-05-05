package com.atom.beanvalidator.annotation;

import com.atom.beanvalidator.validator.EmojiValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 校验emoji表情,禁止输入emoji表情符号
 *
 * @author Atom
 */
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = EmojiValidator.class)
@Documented
public @interface NoEmoji {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<?>[] target() default {};
}
