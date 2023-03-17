import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.util.ArrayList;

public class CatalogTest
{
@Test
public void testAdd() {  
	Book book = new Book("Ham","Dr.","Eggs"); 
	Catalog catalog = new Catalog();
	ArrayList<String> searchResult = new ArrayList<String>();
	catalog.add(book);  
	searchResult=catalog.search("Ham");
	assertTrue(searchResult.size()>0);
}
@Test
public void testAddID() {  
	Book book = new Book("Ham","Dr.","Eggs"); 
	Book book2 = new Book("Life","Dr.","Freeman"); 
	Catalog catalog = new Catalog();
	ArrayList<String> searchResult = new ArrayList<String>();
	ArrayList<CatalogItem> library = new ArrayList<CatalogItem>();
	catalog.add(book);
	catalog.add(book2);  
	String id = "1";
    library.add(new CatalogItem(book,id,true));
    library.add(new CatalogItem(book2,id,true));
    searchResult=catalog.search("Dr.");
    assertEquals(searchResult.get(0),searchResult.get(1));
}
@Test
public void testSearch() {
	ArrayList<java.lang.String> search = new ArrayList<java.lang.String>();
	Book book = new Book("Ham","Dr.","Eggs"); 
	Catalog catalog = new Catalog();
	ArrayList<String> searchResult = new ArrayList<String>();
	catalog.add(book); 
	searchResult=catalog.search("Ham");
	assertEquals(searchResult.size(),1);
	searchResult=catalog.search("Dr.");
	assertEquals(searchResult.size(),1);
	searchResult=catalog.search("Eggs");
	assertEquals(searchResult.size(),1);
}
@Test
public void testCheckin(){
	ArrayList<CatalogItem> library = new ArrayList<CatalogItem>();
	Book book = new Book("Ham","Dr.","Eggs");
	String id = "Green"; 
	library.add(new CatalogItem(book,id,true));
	Catalog catalog = new Catalog(library);
	boolean searchResult=catalog.checkin(id);
	assertEquals(searchResult, false);
}
@Test
public void testCheckout(){
	ArrayList<CatalogItem> library = new ArrayList<CatalogItem>();
	Book book = new Book("Ham","Dr.","Eggs");
	String id = "Green"; 
	library.add(new CatalogItem(book,id,false));
	Catalog catalog = new Catalog(library);
	boolean searchResult=catalog.checkout(id);
	assertEquals(searchResult, false);
}
@Test
public void testRemove(){
	ArrayList<CatalogItem> library = new ArrayList<CatalogItem>();
	Book book = new Book("Ham","Dr.","Eggs");
	String id = "Green"; 
	library.add(new CatalogItem(book,id,true));
	Catalog catalog = new Catalog(library);
	ArrayList<String> searchResult=catalog.search("Ham");
	boolean removeResult=catalog.remove(searchResult.get(0));
	assertEquals(removeResult, false);
}
@Test
public void testGetBook(){
	ArrayList<CatalogItem> library = new ArrayList<CatalogItem>();
	Book book = new Book("Ham","Dr.","Eggs");
	String id = "Green"; 
	library.add(new CatalogItem(book,id,true));
	Catalog catalog = new Catalog(library);
	ArrayList<String> searchResult=catalog.search("Ham");
	Book getResult=catalog.getBook(searchResult.get(0));
	assertEquals(getResult, book);
}
@Test
public void testGetBookNoLibrary(){
	Catalog catalog = new Catalog();
	Book getResult=catalog.getBook("132");
	assertEquals(getResult, null);
}
@Test
public void testGetBookNoID(){
	ArrayList<CatalogItem> library = new ArrayList<CatalogItem>();
	Book book = new Book("Ham","Dr.","Eggs");
	String id = ""; 
	library.add(new CatalogItem(book,id,true));
	Catalog catalog = new Catalog(library);
	ArrayList<String> searchResult=catalog.search("Ham");
	Book getResult=catalog.getBook(searchResult.get(0));
	assertEquals(null, getResult);
}
}
