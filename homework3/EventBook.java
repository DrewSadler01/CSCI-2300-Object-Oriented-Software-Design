import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class EventBook
{
	protected ArrayList<Event> Books = new ArrayList<Event>(); 
	public boolean addEvent(Event set,GregorianCalendar library)
	{
		set.schedule(library);
		for(int a=0;a<Books.size();a++)
		{
			if(Books.get(a).overlaps(set))
			{
				set.schedule(null);
				return false;
			}
		}
		Books.add(set);
		return true;
	}
	public ArrayList<Event> getEventsForDate(GregorianCalendar schedule)
	{
		ArrayList<Event> temp = new ArrayList<Event>();
		for(int b=0;b<Books.size();b++)
		{
		//	if(Books.get(b).equals(schedule.get(b))) // grab days instead of whole event *gave me out of index problem
		//	{
			if(Books.get(Calendar.DAY_OF_MONTH).equals(schedule.get(Calendar.DAY_OF_MONTH)))
			{
				temp.get(b).schedule(null);
			}
			else
			{
				temp.add(Books.get(b));
			}
		}
		return temp;
	}
}
