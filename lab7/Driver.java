import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Container;
import java.awt.Graphics2D;

public class Driver
{

    public static void main(String []args)
    {
        Prototype blackJackPrototype = new Prototype(400);
        JFrame frame = blackJackPrototype.getFrame();
        BufferedImage img = new BufferedImage(
        frame.getWidth(), 
        frame.getHeight(), 
        BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = img.createGraphics();
        frame.printAll(g2d);
        g2d.dispose();

        try
        {
           ImageIO.write(img, "png", new File("BlackJackPrototype.png"));
        }
        catch(IOException e)
        {
           System.out.println("Could not write image");
        }

        //frame.setVisible(false);
        //frame.dispose();
    }
}
