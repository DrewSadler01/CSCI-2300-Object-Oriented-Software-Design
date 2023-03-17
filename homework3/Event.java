import java.util.Calendar;
import java.util.GregorianCalendar;
public abstract class Event
{
	protected Calendar startTime;
	protected Calendar endTime;     
	protected String descrip;
	protected Contact contact;
	public Event()
	{
 
	}
	public String toString()
	{
		String output = descrip;
		String startStr, endStr;
		
		if(startTime==null)
		{
			output+=" Not Scheduled";
		}	
		else
		{
			startStr=" Start "+startTime.get(Calendar.YEAR)+"/"+startTime.get(Calendar.MONTH)+"/"+startTime.get(Calendar.DAY_OF_MONTH)+" "+startTime.get(Calendar.HOUR_OF_DAY)+":"+startTime.get(Calendar.MINUTE);
			endStr=" Start "+endTime.get(Calendar.YEAR)+"/"+endTime.get(Calendar.MONTH)+"/"+endTime.get(Calendar.DAY_OF_MONTH)+" "+endTime.get(Calendar.HOUR_OF_DAY)+":"+endTime.get(Calendar.MINUTE);
			output=output+startStr+endStr;
		}
		return output;
	}
	public boolean overlaps(Event e)
	{
		Event first, second;
		boolean overlap_found = true;
		if (this.startTime.compareTo(e.startTime) < 0)
		{
			first = this;
			second = e;
		}
		else
		{
			first = e;
			second = this;
		}
		if (first.endTime.compareTo(second.startTime) <= 0)
		{
			overlap_found = false;
		}
		return overlap_found;
	}
	public abstract void schedule(GregorianCalendar day);
	public int grabDay(GregorianCalendar data)
	{
		return data.get(Calendar.DAY_OF_MONTH);
	}
}
