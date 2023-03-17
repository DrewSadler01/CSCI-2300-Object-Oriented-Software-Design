
public class Circle2D
{
	private Point2D center;
	private double radius;
	
	public Circle2D()
	{
		center = new Point2D();
 	}
	public Circle2D(Point2D c,double r)
	{
		this.center = new Point2D(c.getX(),c.getY());
		this.radius = (r);
	} 
	public String toString()
	{
		String val="Circle with radius "+radius+" centered at "+center.toString();
        return val;	
	}

}
