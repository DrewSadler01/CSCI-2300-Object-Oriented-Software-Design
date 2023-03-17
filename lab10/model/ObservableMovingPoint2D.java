package model;
import java.util.ArrayList;

public class ObservableMovingPoint2D extends MovingPoint2D
{
   protected ArrayList<PointObserver> observers;

   public ObservableMovingPoint2D()
   {
      super();
      observers = new ArrayList<PointObserver>();
   }

   public ObservableMovingPoint2D(int x, int y)
   {
      super(x,y);
      observers = new ArrayList<PointObserver>();
   }

   public void notifyObservers()
   {
      // TODO: implement this method
      // Call update method on all PointObserver objects
      // in the observers ArrayList
      for(PointObserver pointObserver: observers)
      {
         pointObserver.update(super.x,super.y);
      }
   }

   public void addObserver(PointObserver o)
   {
      // TODO: implement this method
      // Add the PointObserver o to the observers ArrayList
      observers.add(o);
   }

   @Override
   public void moveVertically(int length)
   {
      super.moveVertically(length);
      notifyObservers();
   }

   @Override
   public void moveHorizontally(int length)
   {
      // TODO: implement this method
      super.moveHorizontally(length);
      notifyObservers();
   }
}
