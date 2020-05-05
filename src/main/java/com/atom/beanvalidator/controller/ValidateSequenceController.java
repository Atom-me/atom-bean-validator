package com.atom.beanvalidator.controller;

import com.atom.beanvalidator.dto.SendMessageDTO;
import com.atom.beanvalidator.validategroup.ValidateGroup;
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
@RequestMapping(value = "/validateSequence")
public class ValidateSequenceController {

    /**
     * 发送短信验证码
     *
     * @param sendMessageDTO
     * @return
     * @throws Exception
     */
    @PostMapping(path = "/sendMessageCode", produces = MediaType.APPLICATION_JSON_VALUE)
    ResultVO sendMessageCode(@RequestBody @Validated(ValidateGroup.Sequence.class) SendMessageDTO sendMessageDTO) throws Exception {
        return null;
    }
}
