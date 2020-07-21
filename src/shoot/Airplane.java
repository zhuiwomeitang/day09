package shoot;

import demo.Main;

import java.awt.image.BufferedImage;

//小型敌机
public class Airplane extends FlylingObject implements Enemy {
    private int speed=3;private int score=1;

    BufferedImage burn[]=new BufferedImage[]{Main.airplane_ember0,Main.airplane_ember1,Main.airplane_ember2,Main.airplane_ember3};
    @Override
    public void setEmber() {
        this.ember = burn;
    }


    public int getScore() {
        return score;
    }





   public Airplane(){
        super((int)(Math.random()*(400-Main.airplane.getWidth())), -Main.airplane.getHeight(), Main.airplane,1);
    }
    @Override
   public void move() {

            this.setY(this.getY()+speed);



    }
}
