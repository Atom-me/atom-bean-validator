package com.atom.beanvalidator.controller;

import com.atom.beanvalidator.dto.ReserveDTO;
import com.atom.beanvalidator.vo.ResultVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Atom
 */
@RestController
@RequestMapping(value = "/noEmoji")
public class NoEmojiController {

    /**
     * 添加预约记录
     *
     * @return
     */
    @PostMapping(value = "/reserve")
    public ResultVO reserve(@RequestBody @Validated ReserveDTO reserveDTO) {

        return null;
    }
}
