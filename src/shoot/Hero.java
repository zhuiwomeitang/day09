package shoot;

import demo.Main;

import java.awt.image.BufferedImage;

//英雄机
public class Hero extends FlylingObject {
    private int life;
   private int score;


   public  Hero(int x,int y){
    super(x,y,Main.hero0,3);

   }
    private int doublefire=0;
   public void addfire(){
       doublefire+=10;
   }
    public Bullet[] shoot(){
       Bullet[] bullets=null;
         if(doublefire==0){
             bullets=new Bullet[1];
             bullets[0] = new Bullet(this.getX()+this.getWidth()/2, this.getY());
         }else{
             bullets=new Bullet[2];
             bullets[0] = new Bullet(this.getX()+this.getWidth()/4, this.getY());
             bullets[1] = new Bullet(this.getX()+this.getWidth()*3/4, this.getY());
             doublefire--;
         }


       //bullets[1]=new Bullet(this.getX()+40,this.getY());
       return bullets;
   }
//    public int getLife() {
//        return life;
//    }
//
//    public void setLife(int life) {
//        this.life = life;
//    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


private int count=0;
   private BufferedImage herosImg[]=new BufferedImage[]{Main.hero0,Main.hero1};
    @Override
    public void move() {
       count++;
       setImg(herosImg[count%2]);
    }
}
