public class Triangle
{
    double a, b, c;
    public Triangle()
    {
        this.a = 1;
        this.b = 1;
        this.c = 1; 
    }

    public Triangle(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Isosceles triangles have two sides that are equal
     */
    public boolean isIsosceles()
    {
        if (a == b || b == c)
        {
            return true;
        }
        return false;
    }

    /**
     * All three sides of Scalene triangles are different
     */
    public boolean isScalene()
    {
        if (a != b && b != c)
        {
           return true;
        }
        return false;
    }

    /**
     * In Equilateral triangles, all three sides are equal
     */
    public boolean isEquilateral()
    {
        if (a == b && b == c)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Return a human readable version of the triangle: (side1, side2, side3)
     *@Override 
     */
    public String toString()
    {
        String value = "("+a+", "+b+", "+c+")";
        return value;
    }
}

