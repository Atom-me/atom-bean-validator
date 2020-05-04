package com.atom.beanvalidator.web;

import com.atom.beanvalidator.enums.ErrorCode;
import com.atom.beanvalidator.vo.ResultVO;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 统一异常处理
 *
 * @author Atom
 */
@RestControllerAdvice
public class CtrlAdvice {

    @ExceptionHandler
    public ResultVO methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        Map<String, String> collect = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
        return ResultVO.fail(ErrorCode.PARAM_ERR, collect);
    }

    @ExceptionHandler
    public ResultVO constraintViolationExceptionHandler(ConstraintViolationException e) {
        Map<Path, String> collect = e.getConstraintViolations().stream()
                .collect(Collectors.toMap(ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage));
        return ResultVO.fail(ErrorCode.PARAM_ERR, collect);
    }
}
