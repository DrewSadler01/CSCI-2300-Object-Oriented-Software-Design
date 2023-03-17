/*
 * Example of using MovableShape
 */

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class CarAnimation
{

   public static void main(String []args)
   {
      JFrame mainFrame = new JFrame();
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainFrame.setSize(600, 600);
      MovingIcon car;

      try
      {
         car = new MovingIcon("./RedCar.png", 600, 600);
      }
      catch (IOException e)
      {
         System.out.println(e.getMessage());
         return;
      }

      JLabel label = new JLabel(car);
      mainFrame.add(label);
      mainFrame.setVisible(true);
      
      ActionListener listener = new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            label.repaint();
            car.move();
         }
      };


      final int DELAY = 10;
      Timer t = new Timer(DELAY, listener);
      t.start();
   }
}
