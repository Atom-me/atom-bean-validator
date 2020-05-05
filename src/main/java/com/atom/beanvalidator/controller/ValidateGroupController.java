package com.atom.beanvalidator.controller;

import com.atom.beanvalidator.dto.EmployeeDTO;
import com.atom.beanvalidator.validategroup.ValidateGroup;
import com.atom.beanvalidator.vo.ResultVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.groups.Default;

/**
 * 使用validation的group属性可以实现分组校验
 * <p>
 * 比如在新增员工的时候我们要求前端不能传递ID属性，但是在更新员工的时候员工ID必须不能为空。
 * <p>
 * 我们在同一个接口有不同版本的时候，对同一个请求对象的属性具有不同的校验规则，
 * 比如：我们用户名密码登录的时候v1版本接口不需要sessionId作校验，但是在V2版本sessionId不能为空
 * <p>
 * 分组校验的是我们要注意,如果我们指定了分组，就只会对指定分组作校验，如果也同时需要校验，没有指定分组的属性，需要加上默认分组，即：Default.class
 *
 * @author Atom
 */
@RestController
@RequestMapping(value = "validateGroup")
public class ValidateGroupController {

    /**
     * 新增员工操作
     * 由于 ValidateGroup.AddGroup.class 没有继承 默认分组 Default.class
     * 所以，这里必须加上 默认分组Default.class才会校验Employee的name属性
     *
     * @param employeeDTO
     * @return
     */
    @PostMapping("/addOperation")
    public ResultVO addOperation(@RequestBody @Validated({ValidateGroup.AddGroup.class, Default.class}) EmployeeDTO employeeDTO) {
        return ResultVO.success();
    }

    /**
     * 更新员工操作
     * 由于 ValidateGroup.UpdateGroup.class 继承了 默认分组 Default.class
     * 所以，这里不需要加上 默认分组Default.class就会校验Employee的name属性
     *
     * @param employeeDTO
     * @return
     */
    @PostMapping("/updateOperation")
    public ResultVO updateOperation(@RequestBody @Validated(ValidateGroup.UpdateGroup.class) EmployeeDTO employeeDTO) {
        return ResultVO.success();
    }
}
