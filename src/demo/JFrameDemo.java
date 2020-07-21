package demo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class JFrameDemo {

    public static void main(String[] args) {
        //有参构造方法窗口
        JFrame window = new JFrame("飞机大战");

        MyPanel p = new MyPanel();
        window.add(p);

        //设置窗口大小
        window.setSize(400, 650);
        //设置窗口关闭选项
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口居中
        window.setLocationRelativeTo(null);
        //

        //显示窗口
        window.setVisible(true);
    }
    }

      class MyPanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            //自定义子类的功能
            Font font = new Font("Microsoft YAHEI UI", 2, 20);
            g.setFont(font);
            g.drawString("score", 20, 50);
            Color color = new Color(41, 23, 91);
            g.setColor(color);


            BufferedImage img = null;
            try {
                img= ImageIO.read(MyPanel.class.getResourceAsStream("img/background.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(img, 0, 0,  this);
        }
    }



