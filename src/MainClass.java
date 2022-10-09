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
        public component(){
            addKeyListener(new eventos());
            setFocusable(true);
            setDoubleBuffered(true);
            loop = new Timer(5, this);
            loop.start();
            b1 = new barra1();
            b2 = new barra2();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            b1.moverBarra();
            b2.moverBarra();
            repaint();
        }
        @Override
        public void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.black);
            g2.fillRect(0,0,800,600);
            g2.setColor(Color.white);
            g2.fillRect(b1.getX(), b1.getY(), b1.getW(),b1.getH());
            g2.fillRect(b2.getX(), b2.getY(), b2.getW(),b2.getH());
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
