package com.atom.beanvalidator.validator;

import com.atom.beanvalidator.annotation.NotAllowNullIfAnotherFieldEqualsSpecificValue;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;

import static org.apache.commons.beanutils.BeanUtils.getProperty;

/**
 * 如果另一个字段（anotherFieldName）的值等于指定的值（specificFieldValue），
 * 则当前字段（dependOnField）不可为空
 *
 * @author Atom
 */
@Slf4j
public class NotAllowNullIfAnotherFieldEqualsSpecificValueValidator implements ConstraintValidator<NotAllowNullIfAnotherFieldEqualsSpecificValue, Object> {

    private String anotherFieldName;

    private String specificValue;

    private String dependOnField;

    @Override
    public void initialize(NotAllowNullIfAnotherFieldEqualsSpecificValue constraintAnnotation) {
        this.anotherFieldName = constraintAnnotation.anotherFieldName();
        this.specificValue = constraintAnnotation.specificValue();
        this.dependOnField = constraintAnnotation.dependOnField();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        try {
            String anotherFieldRequestValue = getProperty(obj, anotherFieldName);
            String dependOnFieldRequestValue = getProperty(obj, dependOnField);
            if (!StringUtils.equals(anotherFieldRequestValue, specificValue)) {
                return true;
            }
            return StringUtils.isNotBlank(dependOnFieldRequestValue);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            log.error("BeanUtils get property from obj error.");
        }
        return false;
    }
}
