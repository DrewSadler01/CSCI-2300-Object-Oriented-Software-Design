package BlackJack.model;

import org.junit.*;
import static org.junit.Assert.*;

public class DealerTest
{
   @Test
   public void testHitOn16()
   {
       Dealer d = new Dealer();
       d.addToHand(new Card(Card.Face.SIX, Card.Suite.CLUBS));
       d.addToHand(new Card(Card.Face.TEN, Card.Suite.CLUBS));
       d.play(new Deck());
       assertTrue("Dealer's initial hand was SIX and TEN", d.getHand().getValue() > 16);
   }

   @Test
   public void testHitOn15()
   {
       Dealer d = new Dealer();
       d.addToHand(new Card(Card.Face.FIVE, Card.Suite.CLUBS));
       d.addToHand(new Card(Card.Face.TEN, Card.Suite.CLUBS));
       d.play(new Deck());
       assertTrue("Dealer's initial hand was FIVE and TEN", d.getHand().getValue() > 16);
   }

   @Test
   public void testStandOn17()
   {
       Dealer d = new Dealer();
       d.addToHand(new Card(Card.Face.SEVEN, Card.Suite.CLUBS));
       d.addToHand(new Card(Card.Face.TEN, Card.Suite.CLUBS));
       d.play(new Deck());
       assertEquals("Dealer's initial hand was SEVEN and TEN", 17, d.getHand().getValue());
   }

   @Test
   public void testStandOn18()
   {
       Dealer d = new Dealer();
       d.addToHand(new Card(Card.Face.EIGHT, Card.Suite.CLUBS));
       d.addToHand(new Card(Card.Face.TEN, Card.Suite.CLUBS));
       d.play(new Deck());
       assertEquals("Dealer's initial hand was EIGHT and TEN", 18, d.getHand().getValue());
   }
}
