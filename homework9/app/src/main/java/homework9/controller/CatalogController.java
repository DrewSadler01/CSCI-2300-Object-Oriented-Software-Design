package controller;
import model.*;
import java.util.ArrayList;

public class CatalogController
{
   private Catalog catalog;
   private CatalogUserInterface ui;

   public CatalogController(Catalog catalog, CatalogUserInterface ui)
   {
      this.catalog = catalog;
      this.ui = ui;
   }

   public void searchAndShow(String keyword)
   {
      ArrayList<Book> books = new ArrayList<Book>();
      ArrayList<String> bookIds = catalog.search(keyword);
      for (String id: bookIds)
      {
         Book b = catalog.getBook(id);
         books.add(b);
      }
      ui.showBooks(books);
   }

   public void showAllBooks()
   {
      ArrayList<Book> allBooks = new ArrayList<Book>();
      for (CatalogItem b: catalog)
      { 
         allBooks.add(b.getBook());
      }
      ui.showBooks(allBooks);
   }
}
