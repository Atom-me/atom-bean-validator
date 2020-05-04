package com.atom.beanvalidator.validator;


import com.atom.beanvalidator.annotation.EnumValue;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 校验对象属性值只能为执行枚举内的值
 *
 * @author Atom
 */
public class EnumValueValidator implements ConstraintValidator<EnumValue, String> {

    Class<?>[] classes;

    @Override
    public void initialize(EnumValue constraint) {
        this.classes = constraint.target();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        for (Class<?> cls : classes) {
            if (cls.isEnum()) {
                // get enum all instances
                Object[] enumConstants = cls.getEnumConstants();
                try {
                    Method method = cls.getMethod("name");
                    for (Object constant : enumConstants) {
                        Object code = method.invoke(constant, null);
                        if (code.toString().toLowerCase().equalsIgnoreCase(value)) {
                            return true;
                        }
                    }
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

}
