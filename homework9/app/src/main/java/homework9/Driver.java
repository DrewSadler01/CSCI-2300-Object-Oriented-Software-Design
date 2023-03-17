package homework9;
import java.util.ArrayList;
import java.io.IOException;
import java.awt.event.*;
import model.*;
import view.*;
import controller.*;

public class Driver
{
   public static void main(String []args)
   {
      Catalog catalog = new Catalog();
      boolean status = false;

      CatalogItemLoader loader = null;
      
      if (args.length > 0)
      {
         CatalogItemLoaderCSV loaderCSV = new CatalogItemLoaderCSV(args[0]);
         try
         {
            loaderCSV.loadItems();
         }
         catch (IOException e)
         {
            System.out.println("Could not load books from "+args[0]);
            return;
         }
         loader = loaderCSV;
      }
      else
      {
         CatalogItemLoaderInteractive loaderInteractive = new CatalogItemLoaderInteractive();
         try
         {
            loaderInteractive.loadItems();
         }
         catch (IOException e)
         {
            System.out.println("Could not load books iteractively");
         }
         loader = loaderInteractive;
      }

      ArrayList<CatalogItem> myBooks = loader.getItems();
      try
      {
          catalog = new Catalog(myBooks);
      }
      catch (IllegalArgumentException e)
      {
          System.out.println("could not load books: "+e.getMessage());
          catalog = new Catalog();
      }

      CatalogGUI ui = new CatalogGUI(500);

      // instantiate the controller
      CatalogController controller = new CatalogController(catalog, ui);

      // connect ui to the controller's methods
      // One way to do this is with anonymous action listener,
      // but feel free to use any of the approaches demonstrated in class

      ui.addSearchListener(new ActionListener(){
         public void actionPerformed(ActionEvent e)
         {
            controller.searchAndShow(ui.getSearchTerm());
         }
      });

      ui.addShowAllListener(new ActionListener(){
         public void actionPerformed(ActionEvent e)
         {
            controller.showAllBooks();
         }
      });
   }
}
