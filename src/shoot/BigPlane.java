package shoot;

import demo.Main;

import java.awt.image.BufferedImage;
import java.util.Random;

//大型敌机
public class BigPlane extends  FlylingObject implements Enemy,Award {
    private int blood;private int speed=5;
    private  int score=10;private int awardType;

    public void setAwardType() {

    }


    public int getAwardType() {
        awardType =(int)(Math.random()*2);
        return awardType;
    }


    public int getScore() {
        return score;
    }


 public BigPlane(int blood){
    super((int)(Math.random()*(400-Main.bigplane.getWidth())), -Main.bigplane.getHeight(), Main.bigplane,3);

}

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    @Override
    public void move() {
     if(this.getY()<Main.HEIGHT+Main.bigplane.getHeight()){
         this.setY(this.getY()+speed);

     }

    }
}
