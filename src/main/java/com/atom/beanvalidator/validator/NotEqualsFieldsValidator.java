package com.atom.beanvalidator.validator;

import com.atom.beanvalidator.annotation.NotEqualsFields;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 * 校验两个属性不能相等
 * baseField = null ,matchField = null 校验通过
 * baseField = "" ,  matchField = "" 校验通过
 * baseField = "abc" ,matchField = null 校验通过
 * baseField = "abc" ,matchField = "abc" 校验不通过
 *
 * @author Atom
 */
@Slf4j
public class NotEqualsFieldsValidator implements ConstraintValidator<NotEqualsFields, Object> {

    private String baseField;
    private String matchField;

    @Override
    public void initialize(NotEqualsFields constraintAnnotation) {
        baseField = constraintAnnotation.baseField();
        matchField = constraintAnnotation.matchField();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        try {
            Object baseFieldValue = getFieldValue(object, baseField);
            Object matchFieldValue = getFieldValue(object, matchField);

            if (Objects.isNull(baseFieldValue) && Objects.isNull(matchFieldValue)) {
                return true;
            }

            if (baseFieldValue instanceof String && matchFieldValue instanceof String) {
                return StringUtils.isAllBlank((String) baseFieldValue, (String) matchFieldValue)
                        || !StringUtils.equals((String) baseFieldValue, (String) matchFieldValue);
            }

            return !Objects.equals(baseFieldValue, matchFieldValue);
        } catch (Exception e) {
            log.error("NotEqualsFields get field value error {}.", e);
            return false;
        }
    }

    private Object getFieldValue(Object object, String field) throws NoSuchFieldException, IllegalAccessException {
        Class<?> objClass = object.getClass();
        Field declaredField = objClass.getDeclaredField(field);
        declaredField.setAccessible(true);
        return declaredField.get(object);

    }
}
