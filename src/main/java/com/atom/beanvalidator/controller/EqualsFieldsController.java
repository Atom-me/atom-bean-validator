package com.atom.beanvalidator.controller;

import com.atom.beanvalidator.dto.UserSignUpFormDTO;
import com.atom.beanvalidator.vo.ResultVO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Atom
 */
@RestController
public class EqualsFieldsController {

    @PostMapping("/signUp")
    public ResponseEntity<ResultVO> signUp(@RequestBody @Validated UserSignUpFormDTO userSignUpFormDTO) {
        return null;
    }
}
