package com.atom.beanvalidator.dto;

import com.atom.beanvalidator.validategroup.ValidateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author Atom
 */
@Data
public class SendMessageDTO {

    /**
     * 业务渠道
     */
    @NotBlank(message = "渠道ID不能为空")
    private String channelId;

    /**
     * 手机号码
     * <p>
     * 由于validator的校验是无序的，每次校验返回的错误信息的顺序都是随机的，
     * 如果我们有对同一个属性的不同注解校验有顺序要求，可以使用分组顺序注解@GroupSequence来实现，
     * 注意分组顺序中，如果不写默认分组，指定顺序分组校验通过后就不会去校验默认分组了。
     * <p>
     * 另外：@GroupSequence 具有短路作用，分组顺序中的第一个注解校验失败后，就会直接返回错误信息，不会继续校验其他注解。
     */
    @NotBlank(groups = ValidateGroup.Sequence.First.class, message = "手机号不能为空")
    @Pattern(regexp = "^(13|14|15|16|17|18|19)[0-9]{9}$", groups = ValidateGroup.Sequence.Second.class, message = "手机号格式不合法")
    private String phoneNumber;

    /**
     * Token
     */
    @NotBlank(message = "token不能为空")
    private String token;
}
