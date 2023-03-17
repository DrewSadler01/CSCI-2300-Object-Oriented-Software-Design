public class Dealer extends Player
{
   // TODO: Implement this
   public void play(Deck deck)
   {
	    while(this.getHand().getValue()<17)
       {
          deck.dealOneCard(this);
       }
	 
   }
}
