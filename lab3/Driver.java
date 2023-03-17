import java.io.*;
public class Driver
{ 
   public static void main(String []args) throws Exception
   {
      int numArgs = args.length;
	  if (numArgs > 0)
	  {
		  String input=(args[0]);
		  File file = new File("C:\\Users\\rons\\Desktop\\"+input);
		  BufferedReader read = new BufferedReader(new FileReader(file));
		  String line;
		  while((line = read.readLine())!=null){
			  System.out.println(line);
		  }
      }
      else
      {
		  System.out.println("No command line arguments");	  
      }
   }
}
