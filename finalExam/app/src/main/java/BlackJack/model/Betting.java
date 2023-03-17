package BlackJack.model;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.*;

public class Betting
{
	double money;
   public Betting()
   {
	 this.money = 100;
   }
   public void placesBet(double bet)
   {
	   money = money - bet;
   }
   public void rules()
   {
	/*  
	   if(Result=WIN)
	   {
		  bet=(bet*1.5);
	   }
	   else if(Result=WIN)
	   {
		   money = money + bet;
	   }
	   */
   }
   public void save(double money)
   {
	   try{
	   String temp=String.valueOf(money);
	   File file = new File("remainingMoney.txt");
	   BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
	   writer.write(temp);
	   writer.close();
		} catch (IOException e){
			System.out.println("error");
			
		}
   }
}
