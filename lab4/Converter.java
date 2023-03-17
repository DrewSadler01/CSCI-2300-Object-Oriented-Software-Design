public abstract class Converter{
	protected double from;
	protected double to;
	public void setFrom(double from){
		this.from = from;
	}
	public abstract void convert();
	public double getConversionResult()
	{
		return to;
	}

}
