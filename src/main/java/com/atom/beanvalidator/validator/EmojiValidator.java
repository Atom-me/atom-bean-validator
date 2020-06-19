package com.atom.beanvalidator.validator;


import com.atom.beanvalidator.annotation.NoEmoji;
import com.xxl.emoji.EmojiTool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Atom
 */
public class EmojiValidator implements ConstraintValidator<NoEmoji, String> {

    private Class<?>[] classes;

    @Override
    public void initialize(NoEmoji constraint) {
        this.classes = constraint.target();
    }

    @Override
    public boolean isValid(String content, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(content)) {
            return true;
        }
        return CollectionUtils.isEmpty(EmojiTool.findEmojis(content));
    }

}
