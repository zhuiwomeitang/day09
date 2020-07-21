package shoot;

import java.awt.image.BufferedImage;

public abstract class FlylingObject {
    private int x;
    private int y;
    private  int width;
    private int height;
    private BufferedImage img;

    public BufferedImage[] getEmber() {
        return ember;
    }

    public void setEmber() {
        this.ember = ember;
    }

    public BufferedImage[] ember;





    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    private int life;
    protected FlylingObject(){

    }
    protected FlylingObject(int x,int y,BufferedImage img,int life){
        this.img=img;
        this.width=img.getWidth();
        this.height=img.getHeight();
        this.x=x;
        this.y=y;
        this.life=life;
    }
    public abstract void move();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }
}
