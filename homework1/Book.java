public class Book
{
private String title;
private String firstName;
private String lastName;
	public Book(String title, String firstName, String lastName)
	{
		this.title=title;
		this.firstName=firstName;
		this.lastName=lastName;
 	}
    public String getTitle()
    {
 //   Returns the title of the book
		return title;
	}
    public String getAuthorFirstName()
    {
   // Returns the first name of the author
		return firstName;
	}	
    public String getAuthorLastName()
    {
  //  Returns the last name of the author
		return lastName;
	}
    public String toString() 
    {
  //  Returns a human readable representation of the book in the following format:
		String val= "Title: "+title+" Last Name: "+lastName+" First Name: "+firstName;
		return val;
	}

}
