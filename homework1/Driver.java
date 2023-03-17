import java.util.ArrayList;
public class Driver

{
 public static int testAdd()
 {
	Catalog catalog = new Catalog();
	int numErrors = 0;
	boolean status = false;
	Book book = new Book("Introduction to Java Programming", "Kate", "Holdener");
	catalog.add(book);
	ArrayList< String > foundBooks = catalog.search("Kate");
	if (foundBooks.size() != 1)
		{
		System.out.println("Error: search method should have found one book");
		numErrors++;
		}
	return numErrors;
 }
 
 public static int testCheckout()
 {	
	Catalog catalog = new Catalog();
	int numErrors = 0;
	boolean status = false;
	Book book = new Book("Introduction to Java Programming", "Kate", "Holdener");
	catalog.add(book);
	ArrayList< String > foundBooks = catalog.search("Kate");
	catalog.checkout(foundBooks.get(0));
	if(foundBooks.get(0).equals(catalog.library.get(0).isAvailable()==true))
		{
		numErrors++;
		System.out.println("Book not checked out correctly");
		}
	return numErrors;
 }
 
 public static int testCheckin()
 { 
	Catalog catalog = new Catalog();
	int numErrors = 0;
	boolean status = false;
	Book book = new Book("Introduction to Java Programming", "Kate", "Holdener");
	catalog.add(book);
	ArrayList< String > foundBooks = catalog.search("Kate");
	catalog.checkout(foundBooks.get(0));
	catalog.checkin(foundBooks.get(0));
	if(foundBooks.get(0).equals(catalog.library.get(0).isAvailable()==false))
		{
		numErrors++;
		System.out.println("Book not checked in correctly");
		}
	return numErrors;
 }
 
 public static int testSearch()
 {
	Catalog catalog = new Catalog();
	int numErrors = 0;
	boolean status = false;
	Book book = new Book("Introduction to Java Programming", "Kate", "Holdener");
	Book book2 = new Book("Learning to Read", "Bob", "Ross");
	Book book3 = new Book("Learning to Write", "Rossy", "Bob");
	catalog.add(book);
	catalog.add(book2);
	catalog.add(book3);
	ArrayList< String > foundBooks = catalog.search("Kate");
	catalog.search(foundBooks.get(0));
	if(foundBooks.get(0)!=catalog.library.get(0).getId())
		{
		numErrors++;
		System.out.println("Books not searched correctly");	 
		}
	return numErrors;
 }
 
 public static int testGetBook()
 {
	Catalog catalog = new Catalog();
	int numErrors = 0;
	boolean status = false;
	Book book = new Book("Introduction to Java Programming", "Kate", "Holdener");
	catalog.add(book);
	ArrayList< String > foundBooks = catalog.search("Kate");	
	catalog.getBook(foundBooks.get(0));
	if(foundBooks.get(0)!=catalog.library.get(0).getId())
		{
		numErrors++;
		System.out.println("Books not gotten correctly");	 
		}
	return numErrors;
 }
 
 public static int testRemove()
 {
	Catalog catalog = new Catalog();
	int numErrors = 0;
	boolean status = false;
	Book book = new Book("Introduction to Java Programming", "Kate", "Holdener");
	catalog.add(book);
	ArrayList< String > foundBooks = catalog.search("Kate");
	catalog.remove(foundBooks.get(0));
	if(catalog.library.get(0).getId()==null)
		{
		numErrors++;
		System.out.println("Books not remove correctly");	 
		}
	return numErrors;
 }
 // TODO: MORE STATIC TEST METHODS HERE

 public static void main(String []args)
 {
 int numErrors = 0;
 numErrors += testAdd();
 numErrors += testCheckout();
 numErrors += testCheckin();
 numErrors += testGetBook();
 numErrors += testRemove();
 numErrors += testSearch();

 // TODO: Call more test methods here

 if (numErrors > 0)
 {
 System.out.println("Fix your errors");
 }
 else
 {
 System.out.println("No errors were found");
 }

 }

}
