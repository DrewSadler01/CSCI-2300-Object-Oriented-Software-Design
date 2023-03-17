import java.util.ArrayList;
public class Catalog
{
	private int bookId;
	private boolean avail=true;
	public ArrayList<CatalogItem> library;
	public Catalog()
	{
		library = new ArrayList<CatalogItem>();
		bookId=0;
	}
	public void add(Book book)
    {
		String tempId = Integer.toString(bookId);
		CatalogItem addBook = new CatalogItem(book,tempId,avail);
		library.add(addBook);
		tempId+=1;
	}
    public boolean checkout(String id)
    {
		for(int a=0;a<library.size();a++)
		{
		if(library.get(a).getId().equals(id))
			{
			if(library.get(a).isAvailable()==true)
				{
				library.get(Integer.valueOf(id)).setUnavailable();
				return true;
				}
			}
		}
		return false;
	}
    public boolean checkin(String id)
    {
		for(int b=0;b<library.size();b++)
		{
		if(library.get(b).getId().equals(id))	
			{
			if(library.get(Integer.valueOf(id)).isAvailable()==false)
				{
				library.get(Integer.valueOf(id)).setAvailable();
				return true;
				}
			}
		}
		return false;
	}
    public ArrayList < String > search(String searchTerm)
    {
		ArrayList<String> temp = new ArrayList<String>();
 		for(int i=0;i<library.size();i++)
		{
			if(searchTerm.equals(library.get(i).getBook().getTitle()) || searchTerm.equals( library.get(i).getBook().getAuthorFirstName()) ||  searchTerm.equals( library.get(i).getBook().getAuthorLastName()))
			{
				//System.out.println(library.get(i).getId());
				temp.add(library.get(i).getId());
				//System.out.println(temp+"y");

			} 
			return temp;
		}
		System.out.println(temp+"x");
		return temp;
 	}
    public Book getBook(String id)
    {
		if(library.get(Integer.valueOf(id))!=null)
			{
			return library.get(Integer.valueOf(id)).getBook();
			}
			return null;
	}
    public boolean remove(String id)
    {
		for( int c=0;c<library.size();c++)
		{
			if(library.get(c).getId().equals(id)) // checking for specific id
			{
				if(library.get(Integer.valueOf(bookId)).isAvailable()==true) // checking if available
				{
					library.remove(Integer.valueOf(id));
				return true;
				}
			}
		}
	 return false;
	}
}
