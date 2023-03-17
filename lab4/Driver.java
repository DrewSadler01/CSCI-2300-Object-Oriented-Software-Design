import java.util.Scanner;
public class Driver
{
	public static void getInput(Converter converter) 
	{ 
		// fill in the implementation details here 
 		System.out.println("Enter amount "); 
  		Scanner scanner = new Scanner(System.in); 
  		converter.setFrom(Double.valueOf(scanner.nextLine())); 
	} 
	public static void convertAndPrintResults(Converter converter)
	{
  		converter.convert();
  		System.out.println("Conversion result is " + converter.getConversionResult());
	}
	public static void main(String []args) 
    { 
      	FahrenheitToCelsius tempConverter = new FahrenheitToCelsius(); 
      	getInput(tempConverter); 
     	tempConverter.convert(); 
      	System.out.println(tempConverter.getConversionResult()); 
    } 
}
