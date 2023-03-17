package BlackJack.controller;
import BlackJack.model.*;

public class BlackJackController
{
   protected Dealer dealer;
   protected Player player;
   protected Deck   deck;
   protected BlackJackUserInterface userInterface;
   protected BettingUserInterface bettingInterface;
   protected int wins;
   protected int losses;

   public BlackJackController(Dealer dealer, Player player, Deck deck, BlackJackUserInterface ui)
   {
      this.wins = 0;
      this.losses = 0;
      this.dealer = dealer;
      this.player = player;
      this.deck = deck;
      this.userInterface = ui;
   }

   public void setWins(int wins)
   {
      this.wins = wins;
   }
   public void setLosses(int losses)
   {
      this.losses = losses;
   }
   public int getWins()
   {
      return this.wins;
   }
   public int getLosses()
   {
      return this.losses;
   }

   /**
    * This method connects the controller with the BettingUserInterface
    */
   public void addBettingUserInterface(BettingUserInterface bettingUI)
   {
      this.bettingInterface = bettingUI;
   }

   /**
    * "Place the bet" use case
    */
   public void placeBet(int bet)
   {
      this.bettingInterface.enableBetting(false);
      this.bettingInterface.showBet(bet);
      startNewGame();
   }

   /**
    * Start new game use case
    */
   public void startNewGame()
   {
      userInterface.reset();
      player.getHand().clear();
      dealer.getHand().clear();

      deck.shuffle();
      for (int i = 0; i < 2; i++)
      {
        deck.dealOneCard(player);
        deck.dealOneCard(dealer);
      }

      userInterface.showHand(player.getHand(), false);
      userInterface.peekHand(dealer.getHand());

      // only ask the player to hit or stand if the player's
      // hand is less than 21
      if (player.getHand().getValue() < 21)
      {
         userInterface.enableHit(true);
         userInterface.enableStand(true);
      }
      else
      {
         onStand();
      }
   }
 
   /**
    * "On hit" use case
    */
   public void onHit()
   {
      boolean hit = false;
      deck.dealOneCard(player);
      userInterface.showHand(player.getHand(), false);

      if (player.getHand().getValue() >= 21)
      {
         userInterface.enableHit(false);
         onStand();
      }
      else
      {
         userInterface.enableHit(true);
      }
   }

   /**
    * "On stand" use case
    */
   public void onStand()
   {
      userInterface.enableHit(false);

      if (!player.getHand().isBust())
      {
         dealer.play(deck);
      }
      userInterface.showHand(player.getHand(), false);
      userInterface.showHand(dealer.getHand(), true);
      onFinish();
   }

   /**
    * "On finish" use case
    */
   public void onFinish()
   {
      // Determine the game result and announce the winner
      Result r = Rules.compareHands(player.getHand(), dealer.getHand());
      if (r == Result.WIN) 
      {
         this.wins++;
      }
      else if (r == Result.LOSE)
      {
         this.losses++;
      }

      if (this.bettingInterface != null)
      {
         // call on this.bettingInterface.showRemainingMoney, passing in the remaining money
         this.bettingInterface.showBet(0);
         this.bettingInterface.enableBetting(true);
      }
      
      boolean playAgain = this.userInterface.playAgain(r);
 
      if (playAgain)
      {
         this.userInterface.reset();
      }
      else
      {
         this.userInterface.enableHit(false);
         this.userInterface.enableStand(false);
         if (this.bettingInterface != null)
         {
            this.bettingInterface.enableBetting(false);
         }
      }
   }

}
