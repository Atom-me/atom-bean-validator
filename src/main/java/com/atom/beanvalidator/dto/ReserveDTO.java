package com.atom.beanvalidator.dto;

import com.atom.beanvalidator.annotation.NoEmoji;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


/**
 * 添加预约记录请求对象
 *
 * @author Atom
 */
@Data
public class ReserveDTO {
    /**
     * 预约时间
     */
    private String reserveTime;

    /**
     * 预约地点
     */
    @Length(max = 100, message = "预约地点最多100字！")
    @NoEmoji(message = "禁止输入表情符号")
    private String reservePlace;

    /**
     * 跟进记录
     */
    @Length(max = 30, message = "跟进记录最多30字！")
    @NoEmoji(message = "禁止输入表情符号")
    private String followRecord;

    /**
     * 流程类型(4:云店流程 1:门店流程) 默认是云店流程
     */
    private Integer currentFlowType;

    /**
     * 接待方式（1：上门；2：到店）
     */
    private Integer receptionType;
}
