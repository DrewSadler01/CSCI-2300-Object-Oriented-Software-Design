import java.util.ArrayList;
import java.util.Iterator;

public class CatalogController
{
private Catalog catalog = new Catalog(); 
private CatalogUserInterface Interface;
private ArrayList<Book> book = new ArrayList<Book>();

public CatalogController(Catalog Cat,CatalogUserInterface CUI)
{
this.catalog=Cat;
this.Interface=CUI;
}
public void searchBook(String term)
{
	ArrayList<String> list = new ArrayList<String>();
	list=catalog.search(term);
	Book temp;
	for(String a: list)
	{
		temp=catalog.getBook(a);
		book.add(temp);
	}
	Interface.showBooks(book);

}
public void allBook()
{
	for(CatalogItem b: catalog)
	{
		book.add(b.getBook());
	}
	Interface.showBooks(book);
}

}
