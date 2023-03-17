public class Driver
{
    public static void main(String []args)
    {
        Deck deck = new Deck();
        Player player = new Player();
        Dealer dealer = new Dealer();
        
        // UseCases is a static class containing only static
        // methods. We can use class name to call static methods.
        // We don't need an object of this class.
        UseCases.startNewGame(deck, player, dealer);

        // At this point, game is over
        System.out.println("GAME OVER");
        System.out.println("Your hand");
        player.getHand().reveal();
        System.out.println("Dealer's hand");
        dealer.getHand().reveal();

        // Determine the game result and announce the winner
        Result r = Rules.compareHands(player.getHand(), dealer.getHand());
        System.out.println("You "+r);
    }
}
