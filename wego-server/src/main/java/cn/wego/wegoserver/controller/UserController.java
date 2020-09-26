package cn.wego.wegoserver.controller;

import cn.wego.wegoserver.entity.RegisterBody;
import cn.wego.wegoserver.entity.Status;
import cn.wego.wegoserver.entity.Student;
import cn.wego.wegoserver.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 包含注册、登录、修改/查看个人信息功能
 *
 * @author Trey
 * @since 2020/9/25
 */

@RestController
@RequestMapping("/api")
public class UserController {

    @Resource
    UserService service;

    @PostMapping("/register")
    public Status register(@RequestBody RegisterBody registerBody, HttpServletRequest request) {
        return service.register(registerBody,request);
    }
}
