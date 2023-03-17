import java.util.ArrayList;
import java.io.*;
public class CatalogItemLoaderCSV extends CatalogItemLoader
{
	protected  String file;
	public CatalogItemLoaderCSV(String file)
	{
		this.file=file;
	}
	public void loadItems() throws Exception
	{
		BufferedReader read = new BufferedReader(new FileReader(file));
 		String line;
		String[] segment;
		while((line=read.readLine())!=null)
		{
			for(int a=0;a<line.length();a++)
			{
				segment=line.split(",");  
			}
		}
	}
}
