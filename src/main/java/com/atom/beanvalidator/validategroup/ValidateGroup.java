package com.atom.beanvalidator.validategroup;

import javax.validation.groups.Default;

/**
 * 校验分组
 *
 * @author Atom
 */
public interface ValidateGroup {

    interface AddGroup {
    }

    interface UpdateGroup extends Default {
    }
}
