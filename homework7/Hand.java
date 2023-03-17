import java.util.ArrayList;

public class Hand
{
   private ArrayList<Card> cards;
   public Hand()
   {
       cards = new ArrayList<Card>();
   }

   /**
    * Adds the given card to the hand
    * @param c the card to be added to the hand
    **/
   public void add(Card c)
   {
       cards.add(c);
   }

   /**
    * Prints the hand value to the terminal
    */
   public void show()
   {
       for (Card c: cards)
       {
           System.out.println(c);
       }
   }
  
   /**
    * Determines the value of the hand
    * @return the total numeric value of the hand
    */
   public int getValue()
   {
       int value = 0;
       for (Card c: cards)
       {
           if (c.getFace() == Card.Face.ACE)
           {
              if(value<=10)
              {
                  value+=11;
              }
              else if(value>=11)
              {
                  value+=1;
              }
           }
           else if (c.getFace().getValue() >= 10)
           {
              value+=10;
           }
           else
           {
              value+=c.getFace().getValue();
           }
       }
       return value;
   }

   /**
    * Determines if the hand is bust (over 21)
    * @return true if the hand is bust, false otherwise
    */
   public boolean isBust()
   {
       boolean bust = false;
       int value = this.getValue();
       if (value > 21)
       {
           bust = true;
       }
       return bust;
   }

   /**
    * Determines if the hand is a black jack
    * @return true if the hand is a blackjack, false otherwise
    */
   public boolean isBlackJack()
   {
       boolean result = false;
       if (cards.size() == 2)
       {
           boolean foundAce = false;
           boolean foundTen = false;
           for (Card c: cards)
           {
               if (c.getFace() == Card.Face.ACE)
               {
                   foundAce = true;
               }

               else if (c.getFace().getValue() >= 10)
               {
                   foundTen = true;
               }
           }
           if (foundAce && foundTen)
           {
               result = true;
           }

       }
       return result;
   }

   /**
    * Prints all cards to the terminal
    */
   public void reveal()
   {
       for (Card c: cards)
       {
          System.out.println(c);
       }
   }

   /**
    * Prints one card to the terminal
    */
   public void showOne()
   {
       System.out.println(cards.get(0));
   }
}
