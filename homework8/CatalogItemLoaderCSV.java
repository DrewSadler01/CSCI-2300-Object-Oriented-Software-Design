import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CatalogItemLoaderCSV extends CatalogItemLoader
{
   private String fileName;

   public CatalogItemLoaderCSV(String fileName)
   {
      this.fileName = fileName;
   }

   public void loadItems() throws IOException 
   {
      // Read book definitions from file
      BufferedReader br = new BufferedReader(new FileReader(this.fileName));
      String line;
      while ( (line = br.readLine()) != null)
      {
         String[] parts = line.split(",");
         if (parts.length >= 5)
         {
            Book book = new Book(parts[0], parts[1], parts[2]);
            CatalogItem item = new CatalogItem(book, parts[3], Boolean.parseBoolean(parts[4]));
            this.items.add(item);
         }
      }
   }

}
