import java.util.Calendar;
import java.util.GregorianCalendar;
public class Appointment extends Event
{
	protected int startBuffer;
	protected Calendar times = new GregorianCalendar();
	public Appointment(Contact person, String name) 
	{
		this.contact=person;
		this.descrip=name;
		this.startBuffer=0;
	}
	public void setStartBuffer(int buffer)
	{
		this.startBuffer=buffer;
	}
	public void schedule(GregorianCalendar select)
	{
		if(select != null)
		{
			startTime = new GregorianCalendar(select.get(Calendar.YEAR),select.get(Calendar.MONTH),select.get(Calendar.DAY_OF_MONTH), select.get(Calendar.HOUR_OF_DAY),select.get(Calendar.MINUTE));
			endTime = new GregorianCalendar(select.get(Calendar.YEAR),select.get(Calendar.MONTH),select.get(Calendar.DAY_OF_MONTH), select.get(Calendar.HOUR_OF_DAY),select.get(Calendar.MINUTE));
			startTime.add(startTime.MINUTE, -startBuffer);
			endTime.add(endTime.HOUR_OF_DAY, 1);
		}
		else
		{
			System.out.println("Null");
			startTime=null;
			endTime=null;
		}
	}
}
