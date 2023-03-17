import java.util.ArrayList;

public class CatalogItemLoader
{
   protected ArrayList<CatalogItem> items;

   public CatalogItemLoader()
   {
      this.items = new ArrayList<CatalogItem>();
   }

   public ArrayList<CatalogItem> getItems()
   {
      return this.items;
   }
}
