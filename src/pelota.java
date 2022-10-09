import java.awt.*;

public class pelota {
    private int x, y, vx, vy, w, h;
    public pelota(){
        x = 20;
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
    public Rectangle getBounds(){
        return new Rectangle(x, y, w, h);
    }
    public void moverPelota(){
        if()
    }
}
