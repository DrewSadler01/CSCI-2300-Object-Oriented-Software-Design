import java.util.Calendar;
import java.util.GregorianCalendar;
public class Meeting extends Event
{
	protected int endBuffer;
	protected Calendar times = new GregorianCalendar();
	public Meeting(Contact person, String names)
	{
		this.contact=person;
		this.descrip=names;
	}
	public void setEndBuffer(int buffer)
	{
		this.endBuffer=buffer;
		//times.add(Calendar.MINUTE, +endBuffer);
	}
	public void schedule(GregorianCalendar select)
	{
		if(select != null)
		{
			startTime = new GregorianCalendar(select.get(Calendar.YEAR),select.get(Calendar.MONTH),select.get(Calendar.DAY_OF_MONTH), select.get(Calendar.HOUR_OF_DAY),select.get(Calendar.MINUTE));
			endTime = new GregorianCalendar(select.get(Calendar.YEAR),select.get(Calendar.MONTH),select.get(Calendar.DAY_OF_MONTH), select.get(Calendar.HOUR_OF_DAY),select.get(Calendar.MINUTE));
			endTime.add(endTime.MINUTE,+endBuffer);
			endTime.add(endTime.HOUR_OF_DAY, 1);
		}
		else if(select == null)
		{
			System.out.println("Null");
			startTime=null;
			endTime=null;
		}
	}
	
}
