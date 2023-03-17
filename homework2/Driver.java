import java.io.*;
import java.util.ArrayList;
public class Driver
{ 
	public static void main(String []args) throws Exception
	{
	  CatalogItemLoader Loader = null;
      int numArgs = args.length;
	  if (numArgs > 0)
	  {
		  CatalogItemLoaderCSV books = new CatalogItemLoaderCSV(args[0]);
		  books.loadItems();
		  Loader=books;
	  }
	  else if(numArgs==0)
	  {
		CatalogItemLoaderInteractive Insertbooks = new CatalogItemLoaderInteractive();  
		Insertbooks.LoadItems();
		Loader=Insertbooks;
	  }
	  ArrayList<CatalogItem> arraybook = Loader.getItems();
	  Catalog catalog = new Catalog();
	  ArrayList<String> catalogbook = catalog.search("Kate");
	  catalogbook.add(String.valueOf(arraybook));
	  for(int b=0;b<catalogbook.size();b++)
	  {
		  System.out.println(catalogbook);
	  }
   }
}
