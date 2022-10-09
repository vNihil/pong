import javax.swing.*;
import java.awt.*;

public class pelota {
    private boolean avanzary1, avanzary2;
    private int x, y, vx, vy, w, h;
    public pelota(){
        x = 0;
        y = 20;
        w = 40;
        h = 40;
    }

    public int getX() {
        return x;
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }

    public int getY() {
        return y;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, w, h);
    }
    public void moverPelota(){
        y+= vy;
        x+= vx;
       if(y >= 520){
           vy = -3;
           vx = -5;
       }
       if(y <= 20){
           vx = 5;
           vy = 3;
       }
    }
}
