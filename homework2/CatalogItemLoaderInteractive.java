import java.util.*;
import java.util.ArrayList;
public class CatalogItemLoaderInteractive extends CatalogItemLoader
{
	protected Book temp;
	public void LoadItems()
	{
		while(true)
		{   
			System.out.println("use A for Add Book or D for Done");
			Scanner myObj = new Scanner(System.in);
			String userName = myObj.nextLine();
			if(userName.equals("A"))
			{
				System.out.println("Enter Book Title: ");
				String Booktitle = myObj.nextLine();
				System.out.println("Enter Author's first name: ");
				String Authorfirst= myObj.nextLine();
				System.out.println("Enter Author's last name: ");
				String Authorlast= myObj.nextLine();
				System.out.println("Enter Catalog id: ");
				String CatalogId= myObj.nextLine();
				System.out.println("Available(Y/N): ");
				String available= myObj.nextLine();
				boolean y = false;
				if(available.equals("Y"))
				{
					y = true;
				}
				else if(available.equals("N"))
				{
					y = false;
				}
				System.out.println("Book title: "+Booktitle);
				System.out.println("First name: "+Authorfirst);
				System.out.println("Last name: "+Authorlast);
				System.out.println("Catalog id: "+CatalogId);
				System.out.println("Availability: "+y);	   
				Book book = new Book(Booktitle,Authorfirst,Authorlast);
				temp =(book);
				CatalogItem x = new CatalogItem(book,CatalogId,y);
				catalogItems.add(x);
			}
			else if(userName.equals("D"))
			{
				System.out.println("Books by Kate");
				for(int c=0;c<catalogItems.size()-1;c++)
				{
					System.out.println(temp);
				}
				break;
			}
		}
	}
}
