package model;
import java.util.ArrayList;
import java.util.Iterator;

public class Catalog implements Iterable<CatalogItem>
{
   private ArrayList<CatalogItem> catalogItems;
   private int lastId;

   /**
    * Instantiate an empty list of catalog itemss
    */
   public Catalog()
   {
      catalogItems = new ArrayList<CatalogItem>();
      lastId = 0;
   }

   /**
    * The items ArrayList must have unique IDs, otherwise, IllegalArgumentException is thrown
    */
   public Catalog(ArrayList<CatalogItem> items) throws IllegalArgumentException
   {
      boolean uniqueIds = checkUniqueIds(items);
      if (!uniqueIds)
      {
         throw new IllegalArgumentException("IDs must be unique");
      }
      this.catalogItems = items;
      lastId = findMaxId();
   }

   /**
    * Adds a book to the catalog
    */
   public void add(Book b)
   {
      lastId++;
      String bookId = String.valueOf(lastId);
      addBookWithId(b, bookId);
   }


   /**
    * If the book with the specified id is in the catalog's book collection and is available for checkout, 
    * the Catalog class marks this book as unavailable and returns True (meaning, checkout was successful). 
    * Otherwise, the method returns false.
    */
   public boolean checkout(String id)
   {
      CatalogItem matchedItem = findItem(id);
      boolean retValue = false;

      // if the book is available, make it not available
      // checkout is successful
      if (matchedItem != null && matchedItem.isAvailable())
      {
         matchedItem.setUnavailable();
         retValue = true;
      }

      return retValue;
   }

   /**
    * If the book with the specified id is in the catalog's book collection and is currently checked out, 
    * the Catalog marks this book as available and returns true (meaning, the return was successful). 
    * Otherwise, the method returns false. 
    */
   public boolean checkin(String id)
   {
      CatalogItem matchedItem = findItem(id);
      boolean retValue = false;

      // if the book is found and is currently unavailable, mark it as available
      if (matchedItem != null && !matchedItem.isAvailable())
      {
         matchedItem.setAvailable();;
         retValue = true;
      }

      return retValue;
   }

   /*
    * Searches the book catalog for books that match the searchTerm exactly (equals) in the 
    * Title, First Name, or Last name attributes of the Book class. Returns the ArrayList of 
    * String objects - ids of the items that matched the searchTerm
    **/
   public ArrayList<String> search(String searchTerm)
   {
      ArrayList<String> retValue = new ArrayList<String>();

      // go through every book int the catalog and check if it matches the searchTerm
      // look at title, author first name, and author last name 
      for (CatalogItem item: this.catalogItems)
      { 
         Book book = item.getBook();

         if (book.getTitle().equals(searchTerm) ||
             book.getAuthorFirstName().equals(searchTerm) ||
             book.getAuthorLastName().equals(searchTerm))
         {
             retValue.add(item.getId());
         }
      }

      return retValue;
   }

   public Book getBook(String id)
   {
      CatalogItem item = findItem(id);
      Book retValue = null;
      if (item != null)
      {
         retValue = item.getBook();
      }
      return retValue;
   }
   /*
    * If the book with the specified bookId is in the Catalog's book collection and is available for checkout, 
    * removes the book from the collection and returns true. Otherwise, returns false.
    **/
   public boolean remove(String id)
   {
      CatalogItem item = findItem(id);
      boolean retValue = false;

      if (item != null && item.isAvailable())
      {
         this.catalogItems.remove(item);
         retValue = true;
      }
      return retValue;
   }

   @Override
   public Iterator<CatalogItem> iterator()
   {
      return this.catalogItems.iterator();
   }

   private void addBookWithId(Book b, String id)
   {
      CatalogItem item = new CatalogItem(b, id, true);
      catalogItems.add(item);
   }


   private CatalogItem findItem(String id)
   {
      CatalogItem matchedItem   = null;

      // find the book with the specified id
      for (CatalogItem item: this.catalogItems)
      {
         if (item.getId().equals(id))
         {
            matchedItem = item;
            break;
         }
      }
      return matchedItem;
   }

   /**
    * Finds the largest id that can be converted to integer (if any)
    * in the the catalogItems array and returns that integre value.
    * If non of the IDs can be converted to integer, 0 is returned.
    */
   private int findMaxId()
   {
      int maxId = 0;
      for (CatalogItem item: this.catalogItems)
      {
         String id = item.getId();
         try
         {
            int idAsInt = Integer.parseInt(id);
            if (idAsInt > maxId)
            {
               maxId = idAsInt;
            }
         }
         catch (Exception error)
         {
         }
      }
      return maxId;
   }

   private boolean checkUniqueIds(ArrayList<CatalogItem> items)
   {
      boolean unique = true;
      for (int i = 0; i < items.size(); i++)
      {
         String itemId = items.get(i).getId();
         for (int j = i+1; j < items.size(); j++)
         {
            if ( itemId.equals(items.get(j).getId()) )
            {
               unique = false;
            }
         }

      }
      return unique;
   }
}
