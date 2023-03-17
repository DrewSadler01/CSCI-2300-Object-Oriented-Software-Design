import java.util.Random;
public class Random2D implements Function2D
{
   private double min;
   private double max;
   Random randomGenerator;   
   public Random2D(double min, double max)
   {
      randomGenerator = new Random();
      this.min = min;
      this.max = max;
   }
   public double eval(double x)
   {
	   boolean rndBool=randomGenerator.nextBoolean();
	   double rndDouble=randomGenerator.nextDouble();
	   if(rndBool==true)
	   {
		  // min=(rndDouble)*min;    Why did neither of these statements work?
		   return min*rndDouble;s   
	   }
	   else
	   {
		   //max=(rndDouble)*max;
		   return max*rndDouble;
	   }
   }

}
