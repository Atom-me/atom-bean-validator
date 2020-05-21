package com.atom.beanvalidator.controller;

import com.atom.beanvalidator.dto.BindPhoneDTO;
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
public class NotEqualsFieldsController {

    @PostMapping("/bindPhone")
    public ResponseEntity<ResultVO> bindPhone(@RequestBody @Validated BindPhoneDTO bindPhoneDTO) {
        return null;
    }
}
