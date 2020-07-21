package shoot;

import demo.Main;

import java.awt.image.BufferedImage;

//奖励蜜蜂
public class Bee extends FlylingObject implements Enemy,Award {
    public Bee(){
        super((int)(Math.random()*400),-Main.bee.getHeight(),Main.bee,1);
    }
    private  int xspeed=5;
    private int yspeed=5;

    @Override
    public int getAwardType() {
        awardType =(int)(Math.random()*2);
        return awardType;
    }



    private int awardType;

    @Override
    public int getScore() {
        return score;
    }

    private int score=5;

    @Override
    public void move() {
            if(getX()<0){
                xspeed=5;
            }
            if(this.getX()+Main.bee.getWidth()>Main.WIDTH){
                xspeed=-5;
            }
            this.setX(this.getX()+xspeed);
            this.setY(this.getY()+yspeed);
    }
}
