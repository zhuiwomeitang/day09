package shoot;

import demo.Main;

import java.awt.image.BufferedImage;

//子弹
public class Bullet extends FlylingObject {
    private int speed=3;




    public Bullet(int x, int y){
        super(x, y,Main.bullet,1);

    }
    @Override
    public void move() {
         this.setY(this.getY()-speed);
    }
}
