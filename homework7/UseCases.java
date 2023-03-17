public class UseCases
{
   public static void startNewGame(Deck deck, Player player, Dealer dealer)
   {
      deck.shuffle();
      for (int i = 0; i < 2; i++)
      {
        deck.dealOneCard(player);
        deck.dealOneCard(dealer);
      }

      System.out.println("Your hand");
      player.getHand().reveal();

      System.out.println("Dealer shows");
      dealer.getHand().showOne();

      // only as the player to hit or stand if the player's
      // hand is less than 21
      if (player.getHand().getValue() < 21)
      {
         boolean hit = TerminalInput.hitOrStand();
         if (hit)
         {
            onHit(deck, player, dealer);
         }
         else
         {
            onStand(deck, player, dealer);
         }
      }
      else
      {
         onStand(deck, player, dealer);
      }
   }
 
   public static void onHit(Deck deck, Player player, Dealer dealer)
   {
      boolean hit = false;
      do
      {
         deck.dealOneCard(player);
         player.getHand().reveal();

         if (player.getHand().isBust())
         {
           return;
         }
         hit = TerminalInput.hitOrStand();

     }while(hit);

     // if we are here, it means the user chose to "stand"
     onStand(deck, player, dealer);
   }

   public static void onStand(Deck deck, Player player, Dealer dealer)
   {
      if (!player.getHand().isBust())
      {
         dealer.play(deck);
      }
   }
}
