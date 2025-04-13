package com.yeqian.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

public class CheckCodeUtils {
    private static final int WIDTH = 120;     //宽度
    private static final int HEIGHT = 40;     //高度
    private static final int CODE_LENGTH = 4; //验证码长度
    private static final int LINE_COUNT = 20; //干扰线的条数
    private static final String CODE_STYLE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789";

    public static String getRandomCode(OutputStream os) {
        Random random = new Random();

        //创建图像
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        //设置背景色
        g.setColor(getRandomColor(200, 250));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        //设置字体
        g.setFont(new Font("Fixedsys", Font.BOLD | Font.ITALIC, 28));

        //设置干扰线
        for (int i = 0; i < LINE_COUNT; i++) {
            g.setColor(getRandomColor(160, 200));
            int x1 = random.nextInt(WIDTH);
            int y1 = random.nextInt(HEIGHT);
            int x2 = x1 + random.nextInt(WIDTH / 8);
            int y2 = y1 + random.nextInt(HEIGHT / 8);
            g.drawLine(x1, y1, x2, y2);
        }

        //设置验证码
        StringBuilder checkCode = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++) {
            String code = String.valueOf(CODE_STYLE.charAt(random.nextInt(CODE_STYLE.length())));
            checkCode.append(code);
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            //每个字符之间隔20个像素，距离最左边为15像素，高度为28像素
            g.drawString(code, 20 * i + 15, 28);
        }

        g.dispose();
        //输出图像
        try {
            //调用输出流
            ImageIO.write(image, "JPEG", os);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return checkCode.toString();
    }

    //得到随机颜色
    private static Color getRandomColor(int min, int max) {
        Random random = new Random();
        if (max > 255){
            max = 255;
        }
        if (min > 255){
            min = 255;
        }

        int r = random.nextInt(max - min + 1) + min;
        int g = random.nextInt(max - min + 1) + min;
        int b = random.nextInt(max - min + 1) + min;
        return new Color(r, g, b);
    }
}
