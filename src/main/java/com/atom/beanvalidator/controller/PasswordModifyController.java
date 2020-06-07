package com.atom.beanvalidator.controller;

import com.atom.beanvalidator.dto.PasswordModifyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 修改密码场景，新密码必须和确认新密码相同
 *
 * @author Atom
 */
@RestController
public class PasswordModifyController {

    @PostMapping(value = "/pwdModify")
    ResponseEntity<String> pwdModify(@RequestBody @Validated PasswordModifyDTO passwordModifyDTO) {
        return ResponseEntity.ok("validate passed ...");
    }
}
