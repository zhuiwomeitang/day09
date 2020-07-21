package shoot;

import java.awt.image.BufferedImage;

public class Ember {
private BufferedImage[]images;
private int index;
private  BufferedImage img;
private  int interval=10;private  int i;
private  int x;

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

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

    private int y;
public Ember(FlylingObject flying){
    images=flying.ember;
    img=flying.getImg();
    x=flying.getX();
    y=flying.getY();
    i=0;index=0;
}
    public boolean burnDown() {
        i++;
        if (i % interval == 0) {
            if (index == images.length) {
                return true;
            }
            img = images[index++];
        }
        return false;
    }
}
