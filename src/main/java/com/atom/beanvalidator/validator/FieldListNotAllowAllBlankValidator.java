package com.atom.beanvalidator.validator;

import com.atom.beanvalidator.annotation.FieldListNotAllowAllBlank;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

/**
 * @author Atom
 */
@Slf4j
public class FieldListNotAllowAllBlankValidator implements ConstraintValidator<FieldListNotAllowAllBlank, Object> {

    private List<String> fieldList;

    @Override
    public void initialize(FieldListNotAllowAllBlank constraintAnnotation) {
        fieldList = Arrays.asList(constraintAnnotation.fields());
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        List<Object> fieldValueList = Lists.newArrayList();
        fieldList.forEach(field -> {
            try {
                String propertyValue = BeanUtils.getProperty(value, field);
                fieldValueList.add(propertyValue);
            } catch (Exception e) {
                log.warn("invoke FieldListIsAllNullValidator method failure.");
                e.printStackTrace();
            }
        });

        return fieldValueListIsAllBlank(fieldValueList);
    }

    private boolean fieldValueListIsAllBlank(List<Object> fieldValueList) {
        for (Object fieldValue : fieldValueList) {
            if (StringUtils.isNotBlank((CharSequence) fieldValue)) {
                return true;
            }
        }
        return false;
    }
}
