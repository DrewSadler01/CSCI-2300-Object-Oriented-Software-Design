import java.io.IOException;
public class Driver
{
	public static void main(String []args)
	{
		Random2D r = new Random2D(-6,0);
		Constant2D c = new Constant2D(5);
		double []coeff = {1};
		int []exponent = {2};
		Polynomial p = new Polynomial(coeff, exponent);
		Plot2D myPlot = new Plot2D();
		try
		{
			myPlot.plot(p);
			myPlot.plot(c);
			myPlot.plot(r);
			myPlot.saveImage("functions2D.png");
		}
		catch(Exception e)
		{
			System.out.println("IOEception thrown");
		}
		myPlot.close();
	}
}
