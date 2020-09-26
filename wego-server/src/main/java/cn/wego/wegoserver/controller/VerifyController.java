package cn.wego.wegoserver.controller;

import cn.wego.wegoserver.entity.VerificationCode;
import cn.wego.wegoserver.service.VerifyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证码控制器，处理验证码请求
 *
 * @author Trey
 * @since 2020/9/25
 */

@Controller
@RequestMapping("/api")
public class VerifyController {

    @Resource
    VerifyService service;

    @RequestMapping("/verify")
    public void textVerify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.getTextVerificationCode(request,response);
    }
}
