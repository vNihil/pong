import java.awt.*;
import java.awt.event.KeyEvent;

public class barra2 {
    private int x,y,w,h, vy;
    public barra2(){
        x = 720;
        y =300;
        w = 20;
        h = 80;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }
    public Rectangle getBounds(){
        return new Rectangle(x, y, w, h);
    }
    public void moverBarra(){
        if(y >= 10 && y <= 480){
            y+=vy;
        }
        if(y <=10 && vy > 0){
            y+=vy;
        }
        if(y >=480 && vy < 0){
            y+=vy;
        }
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP){
            vy = -3;
        }
        if(key == KeyEvent.VK_DOWN){
            vy = 3;
        }
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP){
            vy = 0;
        }
        if(key == KeyEvent.VK_DOWN){
            vy = 0;
        }
    }

}
