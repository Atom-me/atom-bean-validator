package com.atom.beanvalidator.controller;

import com.atom.beanvalidator.dto.TestFieldListNotAllowAllBlankDTO;
import com.atom.beanvalidator.vo.ResultVO;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Atom
 */
@RestController
@RequestMapping(value = "/fieldListNotAllowAllBlank")
public class FieldListNotAllowAllBlankController {


    /**
     * postman 测试数据
     * <p>
     * {
     * "channelId":"",
     * "openId":"",
     * "unionId":""
     * }
     *
     * @param testFieldListNotAllowAllBlankDTO
     * @return
     */
    @PostMapping(value = "/testFieldListNotAllowAllBlank", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResultVO testFieldListNotAllowAllBlank(@RequestBody @Validated TestFieldListNotAllowAllBlankDTO testFieldListNotAllowAllBlankDTO) {
        return null;
    }
}
