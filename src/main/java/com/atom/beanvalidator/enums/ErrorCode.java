package com.atom.beanvalidator.enums;

import lombok.Getter;

/**
 * @author Atom
 */
public enum ErrorCode {
    /**
     * 参数不正确
     */
    PARAM_ERR("1000", "参数不正确"),

    ;
    @Getter
    private String code;
    @Getter
    private String msg;

    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}

