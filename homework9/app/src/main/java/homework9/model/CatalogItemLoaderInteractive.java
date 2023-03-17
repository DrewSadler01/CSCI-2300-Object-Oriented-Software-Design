package model;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CatalogItemLoaderInteractive extends CatalogItemLoader
{
   private BufferedReader br;

   public CatalogItemLoaderInteractive()
   {
      this.br = new BufferedReader(new InputStreamReader(System.in));
   }

   public void loadItems() throws IOException
   {
      String userChoice = getMenuSelection();
      while (!userChoice.startsWith("D"))
      {
         CatalogItem item = readCatalogItem();
         this.items.add(item);
         userChoice = getMenuSelection();
      }
   }

   private String getMenuSelection() throws IOException
   {
      System.out.println("A - add item");
      System.out.println("D - done");
      return this.br.readLine();
   }

   private CatalogItem readCatalogItem() throws IOException
   {
      System.out.println("Enter title: ");
      String title = this.br.readLine();
      System.out.println("Enter author's first name");
      String fName = this.br.readLine();
      System.out.println("Enter author's last name");
      String lName = this.br.readLine();
      System.out.println("Enter library catalog id");
      String id = this.br.readLine();

      String answer = "Y";
      do{
         System.out.println("Is the book available? Y/N");
         answer = this.br.readLine();
      }while (!answer.equals("Y") && !answer.equals("N"));

      boolean availability = false;
      if (answer.equals("Y"))
      {
         availability = true;
      }

      Book book = new Book(title, fName, lName);
      CatalogItem item = new CatalogItem(book, id, availability);
      return item;
   }
}
