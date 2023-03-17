public class Card
{
   enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES}
   enum Face  {
       TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), 
       NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);
  
       private final int value;
       Face(int v)
       {
           this.value = v;
       }
       public int getValue()
       {
           return this.value;
       }
   }


   Face value;
   Suit suit;

   public Card(Face value, Suit suit)
   {
       this.value = value;
       this.suit = suit;
   }

   /**
    * Retrieve the face value of this card
    * @return the face value of the card
    */
   public Face getFace()
   {
       return value;
   }

   /**
    * Retrieve the suit of this card
    * @return the suit of this card
    */
   public Suit getSuit()
   {
       return suit;
   }

   @Override
   public String toString()
   {
       String result = value.toString() +" of " +suit.toString();
       return result;
   }
}
