package controller;
import model.MovingPoint2D;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class PointController implements KeyListener
{
   protected MovingPoint2D point;

   public PointController(MovingPoint2D point)
   {
      this.point = point;
   }

   @Override
   public void keyPressed(KeyEvent e)
   {
      System.out.println("Key is pressed");

      if (e.getKeyCode() == KeyEvent.VK_RIGHT)
      {
         System.out.println("Moving right");
         point.moveHorizontally(5);
      }
      else if (e.getKeyCode() == KeyEvent.VK_LEFT)
      {
         System.out.println("Moving left");
         point.moveHorizontally(-5);
      }
      else if (e.getKeyCode() == KeyEvent.VK_UP)
      {
         System.out.println("Moving up");
         point.moveVertically(5);
      }
      else if (e.getKeyCode() == KeyEvent.VK_DOWN)
      {
         System.out.println("Moving down");
         point.moveVertically(-5);
      }

   }

   @Override
   public void keyReleased(KeyEvent e)
   {
      // we don't care about this
   }

   @Override
   public void keyTyped(KeyEvent e)
   {
      // we don't care about this
   }


}
