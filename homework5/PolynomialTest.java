import org.junit.*;
import static org.junit.Assert.*;
public class PolynomialTest
{
	@Test
    public void isPolynomialMax()
    {
		double coef[]={5,-3,1};
		int expon[]={2,1,3};
        Polynomial p = new Polynomial(coef,expon);
        int result = p.getMaxDegree();
        assertEquals("MaxDegree() "+p, 3, result);
    }
    @Test
    public void isBothEmpty()
    {
		double coef[]={0,0,0};
		int expon[]={0,0,0};
        Polynomial p = new Polynomial(coef,expon);
        int result = p.getMaxDegree();
        assertEquals("MaxDegree() "+p, 0, result);
    }
    @Test
    public void isDegreeEmpty()
    {
		double coef[]={0,0,0};
		int expon[]={2,1,3};
        Polynomial p = new Polynomial(coef,expon);
        int result = p.getMaxDegree();
        assertEquals("MaxDegree() "+p, 0, result);
    }
    @Test
    public void isCoefficientReturn()
    {
		double coef[]={5,-3,1};
		int expon[]={2,1,3};
        Polynomial p = new Polynomial(coef,expon);
        double result = p.getCoefficient(2);
        assertEquals("Coefficient() "+p, 5, result, 0.001);
    }
    @Test
    public void isCoefficientDoubleReturn()
    {
		double coef[]={5,-3,1};
		int expon[]={2,2,3};
        Polynomial p = new Polynomial(coef,expon);
        double result = p.getCoefficient(2);
        assertEquals("Coefficient() "+p, 5, result, 0.001);
    }
    @Test
    public void isExponentLess()
    {
		double coef[]={5,-3,1};
		int expon[]={2,1};
        try{
        Polynomial p = new Polynomial(coef,expon);
        double result = p.getCoefficient(2);
        assertEquals("Coefficient() "+p, 5, result, 0.001);
		}
		catch(Exception e){
			System.out.println("Lengths of Coefficient isnt equal to Exponents length");
		}
    }
    @Test
    public void isCoefficientLess()
    {
		double coef[]={5,-3};
		int expon[]={2,1,3};
        try{
        Polynomial p = new Polynomial(coef,expon);
        double result = p.getCoefficient(2);
        assertEquals("Coefficient() "+p, 5, result, 0.001);
		}
		catch(Exception e){
			System.out.println("Lengths of Exponents isnt equal to Coefficient length");
		}
    }
	@Test
    public void isEvalSum()
    {
		double coef[]={5,-3,1};
		int expon[]={2,1,3};
        Polynomial p = new Polynomial(coef,expon);
        double result = p.eval(2);
        assertEquals("Coefficient() "+p, 22, result, 0.001);
    }
    @Test
    public void isCoefficientDegree()
    {
		double coef[]={5,-3,1};
		int expon[]={2,1,3};
        Polynomial p = new Polynomial(coef,expon);
        boolean test =false;
        double result = p.getCoefficient(6);
        if(result==0)
        {
			test=true;
		}
		else{
			test=false;
		}
        assertTrue("Coefficient() "+p, test);
    }


}
