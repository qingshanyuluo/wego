package cn.wego.wegoserver.service;

import cn.wego.wegoserver.dao.UserMapper;
import cn.wego.wegoserver.entity.RegisterBody;
import cn.wego.wegoserver.entity.Status;
import cn.wego.wegoserver.entity.Student;
import cn.wego.wegoserver.entity.VerificationCode;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户管理service
 *
 * @author Trey
 * @since 2020/9/25
 */

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public Status register(RegisterBody registerBody, HttpServletRequest request) {
        //将请求体封装成student对象和验证码
        Student student =
                new Student(registerBody.getName(),registerBody.getPassword(),registerBody.getClazz(),
                        registerBody.getStudent_id(),registerBody.getQq_number(),registerBody.getEmail(),
                        registerBody.getSelf_introduction());
        String userVerificationCode = registerBody.getVerification_code();

        HttpSession session = request.getSession();
        String verificationCode = (String) session.getAttribute(VerificationCode.sessionKey);

        //判断验证码是否输入正确
        if (!userVerificationCode.equals(verificationCode)) {
            return new Status(500,"验证码输入错误！");
        }

        //返回状态信息
        try {
            userMapper.register(student);
            session.removeAttribute(VerificationCode.sessionKey);
            return new Status(200, "注册成功！您的面试序号是" + userMapper.getId(student.getStudentId()));
        } catch (DuplicateKeyException e) {
            return new Status(500, "注册失败！请检查您的学号或邮箱是否已经被注册。");
        }
    }
}
