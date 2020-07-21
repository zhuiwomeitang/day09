package demo;

import shoot.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;

public class Main extends JPanel {
    public static BufferedImage background;
    public static BufferedImage hero0;
    public static BufferedImage hero1;
    public static BufferedImage hero_ember0;
    public static BufferedImage hero_ember1;
    public static BufferedImage airplane;
    public static BufferedImage airplane_ember0;
    public static BufferedImage airplane_ember1;
    public static BufferedImage airplane_ember2;
    public static BufferedImage airplane_ember3;
    public static BufferedImage bee;
    public static BufferedImage bee_ember0;
    public static BufferedImage bee_ember1;
    public static BufferedImage bee_ember2;
    public static BufferedImage bee_ember3;
    public static BufferedImage bigplane;
    public static BufferedImage bigplane_ember0;
    public static BufferedImage bigplane_ember1;
    public static BufferedImage bigplane_ember2;
    public static BufferedImage bigplane_ember3;
    public static BufferedImage bullet;
    public static BufferedImage pause;
    public static BufferedImage start;
    public static BufferedImage gameover;
    static {
        try {
            background= ImageIO.read(MyPanel.class.getResourceAsStream("img/background.png"));
            hero0= ImageIO.read(MyPanel.class.getResourceAsStream("img/hero0.png"));
            hero1= ImageIO.read(MyPanel.class.getResourceAsStream("img/hero1.png"));
            hero_ember0= ImageIO.read(MyPanel.class.getResourceAsStream("img/hero_ember0.png"));
            hero_ember1= ImageIO.read(MyPanel.class.getResourceAsStream("img/hero_ember1.png"));
            bee= ImageIO.read(MyPanel.class.getResourceAsStream("img/bee.png"));
            bee_ember0= ImageIO.read(MyPanel.class.getResourceAsStream("img/bee_ember0.png"));
            bee_ember1= ImageIO.read(MyPanel.class.getResourceAsStream("img/bee_ember1.png"));
            bee_ember2= ImageIO.read(MyPanel.class.getResourceAsStream("img/bee_ember2.png"));
            bee_ember3= ImageIO.read(MyPanel.class.getResourceAsStream("img/bee_ember3.png"));
            airplane= ImageIO.read(MyPanel.class.getResourceAsStream("img/airplane.png"));
            airplane_ember0= ImageIO.read(MyPanel.class.getResourceAsStream("img/airplane_ember0.png"));
            airplane_ember1= ImageIO.read(MyPanel.class.getResourceAsStream("img/airplane_ember1.png"));
            airplane_ember2= ImageIO.read(MyPanel.class.getResourceAsStream("img/airplane_ember2.png"));
            airplane_ember3= ImageIO.read(MyPanel.class.getResourceAsStream("img/airplane_ember3.png"));
            bigplane= ImageIO.read(MyPanel.class.getResourceAsStream("img/bigplane.png"));
            bigplane_ember0= ImageIO.read(MyPanel.class.getResourceAsStream("img/bigplane_ember0.png"));
            bigplane_ember1= ImageIO.read(MyPanel.class.getResourceAsStream("img/bigplane_ember1.png"));
            bigplane_ember2=ImageIO.read(MyPanel.class.getResourceAsStream("img/bigplane_ember2.png"));
            bigplane_ember3=ImageIO.read(MyPanel.class.getResourceAsStream("img/bigplane_ember3.png"));
            bullet=ImageIO.read(MyPanel.class.getResourceAsStream("img/bullet.png"));
            start=ImageIO.read(MyPanel.class.getResourceAsStream("img/start.png"));
            pause=ImageIO.read(MyPanel.class.getResourceAsStream("img/pause.png"));
            gameover=ImageIO.read(MyPanel.class.getResourceAsStream("img/gameover.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //存放生成的敌机数组flys
    ArrayList<FlylingObject> flys = new ArrayList<>();
    //存放生成子弹的数组zi
    ArrayList<Bullet> zi=new ArrayList<>();
    ArrayList<Ember>burn=new ArrayList<>();
    public final int START=0;
    public final int RUNNING=1;
    public final int PAUSE=2;
    public final int OVER=3;
    public int state=START;

    //Bee b=new Bee();
    //Airplane air=new Airplane();
    //BigPlane bigPlane=new BigPlane(3);

    //生成英雄机
    Hero hero=new Hero(200,500);

    //重写paint()方法
      @Override
      public void paint(Graphics g) {
        super.paint(g);
        Font font=new Font("Microsoft YAHEI UI",5,30);
        g.setFont(font);
        g.drawImage(background, 0, 0,  this);

          if(state==START){
              flys.clear();
              zi.clear();
             paintStart(g);
          }
          if(state==OVER){paintOver(g);}
          if(state==PAUSE){paintExit(g);}
          if(state==RUNNING){
              paintScore(g);
              paintFlyingObject(g);
              paintbullet(g);
             //没确定好的// paintBurn(g);
              g.drawImage(hero.getImg(), hero.getX(), hero.getY(), this);}


//          g.drawImage(bigPlane.getImg(), bigPlane.getX(), bigPlane.getY(), this);
//          g.drawImage(b.getImg(), b.getX(), b.getY(), this);
//          g.drawImage(air.getImg(), air.getX(), air.getY(), this);
//          g.drawImage(bu.getImg(), bu.getX(), bu.getY(), this);

       }

    private int flyingIndex=0;
    private  void createFlyingObject(){
        flyingIndex++;
        if(flyingIndex%15==0) {
            int i = (int) (Math.random() * 20);
            FlylingObject fly;
            if (i == 0) {
                fly = new Bee();
            } else if (i == 1 || i == 2) {
                fly = new BigPlane(3);
            } else {
                fly = new Airplane();
            }
            flys.add(fly);
        }
    }
    private  int index=0;
      private void shootAction(){
        index++;
        if(index%10==0) {
            Bullet[] zidan = hero.shoot();
            for (int i = 0; i < zidan.length; i++) {
                zi.add(zidan[i]);
            }
        }
}




    //产生的敌机绘画方法，让paint()调用，取出数组flys中的每个数组，为每一个取出的敌机绘画
    private void paintFlyingObject(Graphics g){
        for(int i=0;i<flys.size();i++){
            FlylingObject fly=flys.get(i);
            g.drawImage(fly.getImg(), fly.getX(),fly.getY(), this);
        }
    }

    private void paintbullet(Graphics g){

              for (int i = 0; i < zi.size(); i++) {
                  Bullet z = zi.get(i);

                  g.drawImage(z.getImg(), z.getX(), z.getY(), this);
              }


    }
    private void paintScore(Graphics g){
        g.drawString("score:"+ hero.getScore(),20,40);
        g.drawString("life:"+hero.getLife(),20,70);
    }
    private void  paintStart(Graphics g){
          g.drawImage(start,0,0,this);
      }
    private void paintExit(Graphics g){
        g.drawImage(pause,0,0,this);
        state=PAUSE;
    }
    private void paintOver(Graphics g){
          g.drawImage(gameover,0,0,this);
    }
//   没确定好的 private void paintBurn(Graphics g){
//        for (int i = 0; i < zi.size(); i++) {
//           Ember ember = burn.get(i);
//
//            g.drawImage(ember.getImg(), ember.getX(), ember.getY(), this);
//        }
//
//    }
    private  void destory(){
          for(int i=0;i<zi.size();i++){
              for(int j=0;j<flys.size();j++){
                  Bullet z=zi.get(i);
                  FlylingObject fl=flys.get(j);
                  //hero机碰撞敌机
                  if(hero.getX()>=fl.getX()-hero.getWidth()&&hero.getX()<=fl.getX()+fl.getWidth()&&hero.getY()>=fl.getY()-hero.getHeight()&&hero.getY()<=fl.getY()+fl.getHeight()){
                     flys.remove(j);
                     hero.setLife(hero.getLife()-1);
                     System.out.println(hero.getLife());
                  }

                  if(hero.getLife()==0){state=OVER;hero.setLife(3);}
                   //碰撞判断
                  if(fl.getX()<z.getX()&&z.getX()<=fl.getX()+fl.getWidth()&&z.getY()<=fl.getY()+fl.getHeight()){
                      fl.setLife(fl.getLife()-1);
                      if(fl.getLife()==0){
//           没确定好的           Ember ember=new Ember(fl);
//                          burn.add(ember);
                          if(fl instanceof Enemy){
                              Enemy enemy=(Enemy)fl;
                              hero.setScore(hero.getScore()+enemy.getScore());
                          }
                          //奖励判定
                          if(fl instanceof  Award){
                              Award award=(Award)fl;
                              if(award.getAwardType()==0){
                                  hero.setLife(hero.getLife()+1);
                                  System.out.println(hero.getLife());
                              }
                              else{
                                  hero.addfire();
                              }
                          }
                          flys.remove(j);

                      j--;
                      }
                      zi.remove(i);

                      i--;
                      break;
                  }
              }
          }

    }
        private  void flyingObjectStep(){
            for(int i=0;i<flys.size();i++){
             FlylingObject fly=flys.get(i);
            fly.move();
         }
       }
       private void bulletstep(){
          for(int i=0;i<zi.size();i++){
              Bullet bullet=zi.get(i);
              bullet.move();
          }
       }




         public static int WIDTH=400;
         public  static int HEIGHT=650;
         private java.util.Timer timer=new java.util.Timer();
         public void action(){
               timer.schedule(new TimerTask() {            //匿名内部类
                 @Override
                 public void run() {

                     if(state==RUNNING) {
                         createFlyingObject();
                         flyingObjectStep();
                         Out1();
                         shootAction();
                         bulletstep();
                         Out2();
                         destory();

//                     b.move();
//                     air.move();
                         hero.move();
                     }
                     repaint();
                 }
             },3000,30);
            MouseAdapter adapter=new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                      if(state==OVER){
                          state=START;
                      }else{
                        state=RUNNING;}
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    if(state==PAUSE){
                    state=RUNNING;}
                }

                @Override
                public void mouseExited(MouseEvent e) {
                 if(state==RUNNING){
                     state=PAUSE;
                  }

                }

                @Override
                public void mouseMoved(MouseEvent e) {
                   int mouse_x=e.getX();
                   int mouse_y=e.getY();
                    hero.setX(mouse_x-hero.getWidth()/2);
                   hero.setY(mouse_y-hero.getHeight()/2);
                  repaint();
                }
            };
               this.addMouseListener(adapter);
               this.addMouseMotionListener(adapter);
         }
         private void Out1(){
             for(int i=0;i<flys.size();i++){
                 FlylingObject fly=flys.get(i);
               if(fly.getY()>=Main.HEIGHT){
                   flys.remove(i);i--;
               }
             }
         }
         private  void Out2(){
             for(int i=0;i<zi.size();i++){
                 Bullet bullet=zi.get(i);
                 if(bullet.getY()<=0){
                     zi.remove(i);i--;
                 }
             }
         }

    public static void main(String[] args) {
        JFrame window = new JFrame("飞机大战");

        //设置窗口大小
        window.setSize(WIDTH, HEIGHT);
        //设置窗口关闭选项
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口居中
        window.setLocationRelativeTo(null);


        Main p = new Main();

        window.add(p);


        p.action();

        //显示窗口
        window.setVisible(true);
    }
}
