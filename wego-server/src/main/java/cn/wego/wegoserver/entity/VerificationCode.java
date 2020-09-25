package cn.wego.wegoserver.entity;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 验证码实体类
 *
 * @author Trey
 * @since 2020/9/25
 */

public class VerificationCode {

    private final Random random = new Random();
    private final int width = 160;// 宽
    private final int height = 40;// 高

    private final String randomString = "0123456789abcdefghijklmnopqrstuvwxyz";

    public final static String sessionKey = "randomKey";
    private final Font font = new Font("Times New Roman", Font.PLAIN, 40);

    private String randomStr;

    public String getRandomStr() {
        return randomStr;
    }

    /*
     *  获取颜色
     */
    private Color getRandomColor(int fc, int bc) {

        fc = Math.min(fc, 255);
        bc = Math.min(bc, 255);

        int r = fc + random.nextInt(bc - fc - 16);
        int g = fc + random.nextInt(bc - fc - 14);
        int b = fc + random.nextInt(bc - fc - 12);

        return new Color(r, g, b);
    }

    /*
     *  绘制干扰线
     */
    private void drawLine(Graphics g) {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(20);
        int yl = random.nextInt(10);
        g.drawLine(x, y, x + xl, y + yl);
    }

    /*
     *  获取随机字符
     */
    private void setRandomString(int num) {
        num = num > 0 ? num : randomString.length();
        this.randomStr = String.valueOf(randomString.charAt(random.nextInt(num)));
    }

    /*
     *  绘制字符串
     */
    private String drawString(Graphics g, String randomStr, int i) {
        g.setFont(font);
        g.setColor(getRandomColor(108, 190));
        setRandomString(random.nextInt(randomString.length()));
        randomStr += this.randomStr;
        g.translate(random.nextInt(3), random.nextInt(6));
        g.drawString(this.randomStr, 40 * i + 10, 25);
        return randomStr;
    }

    /*
     *  生成随机图片
     */
    public BufferedImage getRandomCodeImage() {
        // BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        g.fillRect(0, 0, width, height);
        g.setColor(getRandomColor(105, 189));
        g.setFont(font);

        // 绘制干扰线
        // 干扰线数量
        int lineSize = 30;
        for (int i = 0; i < lineSize; i++) {
            drawLine(g);
        }

        //随机产生字符的个数
        String random_string = "";
        int stringNum = 4;
        for (int i = 0; i < stringNum; i++) {
            random_string = drawString(g, random_string, i);
        }
        this.randomStr = random_string;
        g.dispose();
        return image;
    }
}
