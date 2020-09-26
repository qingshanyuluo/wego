package cn.wego.wegoserver.service;

import cn.wego.wegoserver.entity.VerificationCode;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 获取验证码业务层
 *
 * @author Trey
 * @since 2020/9/25
 */

@Service
public class VerifyService {

    public void getTextVerificationCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        //获取验证码对象
        VerificationCode verificationCode = new VerificationCode();
        //从验证码实体类中获取图片和验证码字符串
        BufferedImage image = verificationCode.getRandomCodeImage();
        String sessionKey = VerificationCode.sessionKey;
        String randomStr = verificationCode.getRandomStr();

        //将验证码存入session对象
        if (!"".equals(session.getAttribute(sessionKey))){
            session.removeAttribute(sessionKey);
        }
        session.setAttribute(sessionKey,randomStr);
        //输出图片
        ImageIO.write(image, "png", response.getOutputStream());
    }

}
