package BlackJack;

import java.awt.event.*;

import BlackJack.model.*;
import BlackJack.controller.*;
import BlackJack.view.gui.*;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

public class Driver
{
    public static void main(String []args)
    {
        int wins = 0;
        int losses = 0;


        Deck deck = new Deck();
        deck.shuffle();

        Player player = new Player();
        Dealer dealer = new Dealer();

        BlackJackTable gameTable = new BlackJackTable();
        BlackJackController gameController = new BlackJackController(dealer, player, deck, gameTable);

        // Add the betting functionality to the game table
        // A user starts with $100 dollars 
        gameTable.addBettingZone(gameController, 100);

        // window adapter for asving wins and losses on close
        WindowAdapter adapter = new WindowAdapter(){
          public void windowClosing(WindowEvent e)
          {
             System.out.println("Window closed");
             try
             {
                if (args.length > 0)
                {
                   File outFile = new File(args[0]); 
                   outFile.createNewFile();
                   System.out.println("created new file");
                   FileWriter myWriter = new FileWriter(outFile);
                   myWriter.write("wins:"+gameController.getWins());
                   myWriter.write("\n");
                   myWriter.write("losses:"+gameController.getLosses());
                   myWriter.close();
               }
             }
             catch(IOException exception)
             {
                System.out.println("An error occurred.");
                exception.printStackTrace();
             }
          }
        };

        if (args.length > 0)
        {
           // read wins and losses from file
           try 
           {
               File myObj = new File(args[0]);
               Scanner myReader = new Scanner(myObj);
               while (myReader.hasNextLine()) 
               {
                  String data = myReader.nextLine();
                  String []parts = data.split(":");
                  if (parts[0].equals("wins"))
                  {
                     wins = Integer.parseInt(parts[1]);
                  }
                  else if (parts[0].equals("losses"))
                  {
                     losses = Integer.parseInt(parts[1]);
                  }
                  System.out.println(data);
               }
               myReader.close();

           } 
           catch (IOException e) 
           {
              System.out.println("An error occurred.");
              e.printStackTrace();
           }

           System.out.println("Added window adapter");
           gameTable.addWindowListener(adapter);
        }


        gameController.setWins(wins);
        gameController.setLosses(losses);

        gameTable.setOnHit(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
              gameController.onHit();
           }
        });
        
        gameTable.setOnStand(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
              gameController.onStand();
           }
        });

        //gameController.startNewGame();

    }
}
