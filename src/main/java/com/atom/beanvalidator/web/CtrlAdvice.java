package com.atom.beanvalidator.web;

import com.atom.beanvalidator.enums.ErrorCode;
import com.atom.beanvalidator.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 统一异常处理
 *
 * @author Atom
 */
@RestControllerAdvice
@Slf4j
public class CtrlAdvice {

    @ExceptionHandler
    public ResultVO methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {


      /*  //如果同一个属性上有多个校验，在toMap的时候就会报duplicate key exception
        Map<String, String> fieldErrors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage));

        // 解析类上的校验注解的message 使用 getGlobalErrors
        Map<String, String> globalErrors = e.getBindingResult()
                .getGlobalErrors()
                .stream().collect(Collectors.toMap(
                        ObjectError::getObjectName,
                        ObjectError::getDefaultMessage));

        if (CollectionUtils.isEmpty(fieldErrors)) {
            fieldErrors = globalErrors;
        } else {
            fieldErrors.putAll(globalErrors);
        }
*/

        log.error(e.getMessage());

        // 同一个属性有多个注解时，tomap --> toSet
        Map<String, Set<String>> fieldErrors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.groupingBy(
                        FieldError::getField,
                        Collectors.mapping(
                                fieldError -> fieldError.getDefaultMessage(),
                                Collectors.toSet())));


        // 解析类上的校验注解的message 使用 getGlobalErrors
        Map<String, Set<String>> globalErrors = e.getBindingResult()
                .getGlobalErrors()
                .stream().collect(Collectors.groupingBy(
                        ObjectError::getObjectName,
                        Collectors.mapping(
                                objectError -> objectError.getDefaultMessage(),
                                Collectors.toSet())));

        if (CollectionUtils.isEmpty(fieldErrors)) {
            fieldErrors = globalErrors;
        } else {
            fieldErrors.putAll(globalErrors);
        }
        return ResultVO.fail(ErrorCode.PARAM_ERR, fieldErrors);
    }

    @ExceptionHandler
    public ResultVO constraintViolationExceptionHandler(ConstraintViolationException e) {
        Map<Path, String> collect = e.getConstraintViolations().stream()
                .collect(Collectors.toMap(ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage));
        return ResultVO.fail(ErrorCode.PARAM_ERR, collect);
    }
}
