public class Driver
{
   public static void main(String []args)
   {
      Point2D stationaryPoint = new Point2D(1,10);
      System.out.println(stationaryPoint);

      MovingPoint2D movingPoint = new MovingPoint2D(0,0);
      movingPoint.moveVertically(10);
      movingPoint.moveHorizontally(-10);
      System.out.println(movingPoint);
   }
}
