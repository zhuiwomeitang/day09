package demo;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MyPanel1 extends JFrame{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //自定义子类的功能
        g.drawString("hi",20,20);
        BufferedImage img=null;
        g.drawImage(img,100,200,20,20,this);
    }

}
