package cn.wego.wegoserver.entity;

import lombok.Data;

/**
 * 注册信息请求体
 *
 * @author Trey
 * @since 2020/9/25
 */

@Data
public class RegisterBody {
    private String name;
    private String password;
    private String clazz;
    private String student_id;
    private String qq_number;
    private String email;
    private String self_introduction;
    private String verification_code;
}
