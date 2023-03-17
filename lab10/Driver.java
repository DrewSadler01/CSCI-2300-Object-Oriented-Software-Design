import java.io.IOException;
import javax.swing.*;

import model.*;
import controller.*;
import view.*;

public class Driver
{
   public static void main(String []args)
   {
      ObservableMovingPoint2D point = new ObservableMovingPoint2D(); 
      PointController controller = new PointController(point);
      JFrame window = new JFrame("Moving Car");
      try
      {
         MovableImage img = new MovableImage("view/RedCar.png", 500, 500);
         point.addObserver(img);
         window.add(img);
      }
      catch (IOException e)
      {
         System.out.println(e.getMessage());
      }

      window.addKeyListener(controller);
      window.pack();
      window.setVisible(true);
   }
}
