package com.atom.beanvalidator.dto;

import com.atom.beanvalidator.annotation.FieldListNotAllowAllBlank;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Atom
 */
@FieldListNotAllowAllBlank(fields = {"unionId", "openId"}, message = "unionId和openId不能同时为空")
@Data
public class TestFieldListNotAllowAllBlankDTO {
    /**
     * 渠道ID
     */
    @NotBlank(message = "channelId不能为空")
    private String channelId;
    /**
     * unionId
     */
    private String unionId;

    /**
     * openId
     */
    private String openId;
}
