import java.lang.Math;
public class Polynomial implements Function2D
{
	private double []coefficients;
	private int []exponents;
	public Polynomial(double []coefficients, int []exponents)
	{
		this.coefficients=coefficients;
		this.exponents=exponents;
		if(coefficients.length!=exponents.length)
		{
			throw new IllegalArgumentException("Not every Coefficient has matching Exponent");
		}
	}
	public double getCoefficient(int degree)
	{
		double temp=0;
		for(int a=0;a<coefficients.length;a++)
		{
			if(exponents[a]==degree)
			{
				return coefficients[a];
			}
		}
		return 0;
	}
	public int getMaxDegree()
	{
		int temp=0;
		for(int b=0;b<exponents.length;b++)
		{
			if(coefficients[b]==0){
				break;
			}
			else if(exponents[b]>temp)
			{
				temp=exponents[b];
			}
		}
		return temp;
	}
	public double eval(double x)
	{
		double sum=0;
		for(int c=0;c<exponents.length;c++)
		{
			sum=sum+(coefficients[c]*Math.pow(x,exponents[c]));
		}
		return sum;
	}
}
