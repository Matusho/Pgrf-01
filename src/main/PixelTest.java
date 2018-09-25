package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class PixelTest {

    private JFrame window;//hlavni okno
    private JPanel panel;//panel do ktereho umistuju BufferedImage
    private BufferedImage img;//Objekt do ktereho kreslim

    public PixelTest() {
        //zalkladni vytvoreni okna
        window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(800, 600);

        panel = new JPanel();//inicializace panelu
        window.add(panel);//umisteni panelu do okna


        //inicializace imgae, nastaveni sirky a vysky, nastaveni typu- pro nas
        img = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);

        window.setVisible(true);
        //drawPixel(100, 50, Color.GREEN.getRGB());

        panel.addMouseListener(new MouseAdapter() {//nastaveni udalosti na kliknuti
            @Override
            public void mouseClicked(MouseEvent e) {
                drawPixel(e.getX(), e.getY(), Color.GREEN.getRGB());
            }
        });
    }

    private void drawPixel(int x, int y, int color) {
        img.setRGB(x, y, color);//nastaveni pixelu
        panel.getGraphics().drawImage(img, 0, 0, null);//
    }

    public static void main(String[] args) {
        new PixelTest();
    }
}
