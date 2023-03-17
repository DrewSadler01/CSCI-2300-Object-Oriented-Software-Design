import org.junit.*;
import static org.junit.Assert.*;

public class TriangleTest
{
    @Test
    public void isEquilateralExpectTrue()
    {
        Triangle t = new Triangle(10,10,10);
        boolean result = t.isEquilateral();
        assertEquals("isEquilateral() "+t, true, result);
    }
    @Test
    public void isIsoselesExpectFalse()
    {
        Triangle t = new Triangle(0,0,5);
        boolean result = t.isIsosceles();
		assertEquals("isIsosceles() "+t, false, result);
    }
}
