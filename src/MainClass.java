import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainClass extends JFrame {

    public MainClass(){
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new component());
        setVisible(true);

    }
    public static void main(String[] args){
        new MainClass();
    }
    private class component extends JPanel implements ActionListener{
        private Timer loop;
        private barra1 b1;
        private barra2 b2;
        private pelota p;
        private int puntos;
        public component(){
            addKeyListener(new eventos());
            setFocusable(true);
            setDoubleBuffered(true);
            loop = new Timer(5, this);
            loop.start();
            b1 = new barra1();
            b2 = new barra2();
            p = new pelota();
            puntos = 0;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            b1.moverBarra();
            b2.moverBarra();
            p.moverPelota();
            repaint();
            if(p.getBounds().intersects(b2.getBounds())){
                p.setVx(-5);
                p.setVy(-3);
                puntos++;
            }
            if(p.getBounds().intersects(b1.getBounds())){
                p.setVx(5);
                p.setVy(3);
                puntos++;
            }
        }
        @Override
        public void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.black);
            g2.fillRect(0,0,800,600);
            g2.setColor(Color.white);
            g2.fillRect(b1.getX(), b1.getY(), b1.getW(),b1.getH());
            g2.fillRect(b2.getX(), b2.getY(), b2.getW(),b2.getH());
            g2.fillOval(p.getX(),p.getY(),p.getW(),p.getH());
            g2.drawString("Puntos: " + String.valueOf(puntos), 700,20);
            Toolkit.getDefaultToolkit().sync();
            g.dispose();
        }
        private class eventos extends KeyAdapter{
            @Override
            public void keyPressed(KeyEvent e) {
                b1.keyPressed(e);
                b2.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                b1.keyReleased(e);
                b2.keyReleased(e);
            }
        }
    }

}
