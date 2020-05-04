package com.atom.beanvalidator.vo;

import com.atom.beanvalidator.enums.ErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 统一返回对象.
 * null 对象不返回
 *
 * @author Atom
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ResultVO {
    private Boolean success;
    private String code;
    private String msg;
    private Object data;


    public Boolean isSuccess() {
        return success;
    }

    public static ResultVO success() {
        ResultVO result = new ResultVO();
        result.setSuccess(true);
        return result;
    }

    public static ResultVO success(Object data) {
        ResultVO result = new ResultVO();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static ResultVO fail(ErrorCode paramErr) {
        ResultVO result = new ResultVO();
        result.setSuccess(false);
        result.setCode(paramErr.getCode());
        result.setMsg(paramErr.getMsg());
        return result;
    }

    public static ResultVO fail(ErrorCode paramErr, Object data) {
        ResultVO result = new ResultVO();
        result.setCode(paramErr.getCode());
        result.setMsg(paramErr.getMsg());
        result.setData(data);
        return result;
    }
}
