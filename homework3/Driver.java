import java.util.ArrayList;
import java.util.GregorianCalendar;
public class Driver 
{

/* This program checks the syntax of your constructors and methods.
 * Your classes MUST compile with this program, with no errors.
 * I will use this program to test your solutions.
 */
public static void main(String[] args) 
{
	
   // instantiate an EventBook
   EventBook book = new EventBook();
		
   // create a contact
   Contact kate = new Contact("Kate", 9777004);
   // check if required methods of Contact class exist
   String name = kate.getName();
   int phoneNum = kate.getPhone();
	
   // create meetings
   Meeting csci2300 = new Meeting(kate, "meet with the CSCI2300 students");

   // create appointments
   Appointment oilChange = new Appointment (kate, "oil change");
   Appointment officeHours = new Appointment(kate, "office hours");
   Appointment soccer = new Appointment(kate, "soccer");
   Appointment lunch = new Appointment(kate, "lunch"); 
	
   // print all events
   System.out.println("****************************");
   System.out.println("* Events before scheduling *");
   System.out.println("****************************");
   System.out.println(csci2300);
   System.out.println(oilChange);	
   System.out.println(officeHours);
   System.out.println(soccer);
   System.out.println(lunch);

   // Schedule events
   boolean added = book.addEvent(soccer, new GregorianCalendar(2020, 9, 21, 10, 0));
   if (!added)
   {
      System.out.println("error: soccer should have been scheduled");
   }

   GregorianCalendar today = new GregorianCalendar(2020, 9, 20, 12, 0); 
   csci2300.setEndBuffer(10);
   added = book.addEvent(csci2300, today);
   if (!added)
   {
      System.out.println("error: csci2300 should have been scheduled");
   }

   added = book.addEvent(officeHours, new GregorianCalendar(2020, 9, 20, 13, 0));
   if (added)
   {
      System.out.println("Error: office hours should not have been scheduled");
   }
  
   lunch.setStartBuffer(5);
   added = book.addEvent(lunch, new GregorianCalendar(2020, 9, 20, 13, 15));
   if (!added)
   {
      System.out.println("Error: lunch should have been scheduled");
   }

   GregorianCalendar laterToday = new GregorianCalendar(2020, 9, 20, 14, 30);
   oilChange.setStartBuffer(20); //it will take me 20 minutes to drive there
   added = book.addEvent(oilChange, laterToday);
   if (added)
   {
      System.out.println("Error: oil change should not have been scheduled");
   }

   // Check getEventsForDate method
   ArrayList<Event> todaysEvents = book.getEventsForDate(today);
   if (todaysEvents.size() != 2)
   {
      System.out.println("Error, 2 events should be scheduled for today");
   }

   // print all events again

   System.out.println("***************************");
   System.out.println("* Events after scheduling *");
   System.out.println("***************************");
   System.out.println(csci2300);
   System.out.println(oilChange);	
   System.out.println(officeHours);
   System.out.println(soccer);
   System.out.println(lunch);


}

}

