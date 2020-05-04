package com.atom.beanvalidator.controller;

import com.atom.beanvalidator.dto.TestEnumValueValidatorDTO;
import com.atom.beanvalidator.vo.ResultVO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Atom
 */
@RestController
@Validated
@RequestMapping("/enumValue")
public class EnumValueController {


    /**
     * POST man  测试数据
     * <p>
     * {
     * "userType":"ddd",
     * "redirectUrl":""
     * }
     *
     * @param testEnumValueValidatorDTO
     * @return
     */
    @PostMapping(value = "/testEnumValueValidator", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ResultVO> testEnumValueValidator(@RequestBody @Validated TestEnumValueValidatorDTO testEnumValueValidatorDTO) {
        return null;
    }
}
