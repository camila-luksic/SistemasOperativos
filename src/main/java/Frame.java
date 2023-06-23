import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private int x1, y1, x2, y2;


        public Frame() {
            setTitle("SALON DE BAILE");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800, 400);
            setLocationRelativeTo(null);
            x1 = 50;
            y1 = 75;
            x2 = 200;
            y2 = 75;
            Timer timer = new Timer(30, e -> movePairs());
            timer.start();
        }
    public void paint(Graphics g) {
        super.paint(g);



        // Dibujar los cuadros hombre
        for (int i = 0; i < 4; i++) {
            g.drawRect(x1, y1 + (i * 60), 50, 50);
            g.setColor(Color.blue);

        }

        // Dibujar los cuadros mujer
        for (int i = 0; i < 4; i++) {
            g.drawRect(x2, y2 + (i * 60), 50, 50);
            g.setColor(Color.magenta);
        }

    }

    private void movePairs() {
        if (x1 < 100) {
            x1++;
            x2--;
        } else {
            ((Timer) (SwingUtilities.getRootPane(this).getClientProperty("Timer"))).stop();
        }
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Frame cuadrosUnidos = new Frame();
                cuadrosUnidos.setVisible(true);
            }
        });
    }
}

