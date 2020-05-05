package com.atom.beanvalidator.validategroup;

import javax.validation.GroupSequence;
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


    /**
     * the sequence validator for one field
     */
    @GroupSequence({Sequence.First.class, Sequence.Second.class, Default.class})
    interface Sequence {
        interface First {
        }

        interface Second {
        }
    }

}
