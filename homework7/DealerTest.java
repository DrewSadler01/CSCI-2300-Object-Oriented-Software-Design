import org.junit.*;
import static org.junit.Assert.*;
public class DealerTest
{
	@Test
	public void playTestHit()
	{
		Dealer deal = new Dealer();
		Deck d = new Deck();
		int temp;
		deal.getHand().add(new Card(Card.Face.TEN, Card.Suite.CLUBS));
		deal.getHand().add(new Card(Card.Face.SIX, Card.Suite.SPADES));
		deal.play(d);
		temp=deal.getHand().getValue();
		assertTrue(temp>16);
	}    
	@Test
	public void playTestStand()
	{
		Dealer deal = new Dealer();
		Deck d = new Deck();
		deal.getHand().add(new Card(Card.Face.TEN, Card.Suite.CLUBS));
		deal.getHand().add(new Card(Card.Face.SEVEN, Card.Suite.SPADES));
		deal.play(d);
		assertEquals(17,deal.getHand().getValue());
	}
	@Test
	public void playTestBlackjack()
	{
		Dealer deal = new Dealer();
		Deck d = new Deck();
		deal.getHand().add(new Card(Card.Face.TEN, Card.Suite.CLUBS));
		deal.getHand().add(new Card(Card.Face.TEN, Card.Suite.SPADES));
		deal.getHand().add(new Card(Card.Face.ACE, Card.Suite.HEARTS));
		deal.play(d);
		assertEquals(21,deal.getHand().getValue());
	}
	@Test
	public void playTestDouble()
	{
		Dealer deal = new Dealer();
		Deck d = new Deck();
		int temp;
		deal.getHand().add(new Card(Card.Face.TWO, Card.Suite.CLUBS));
		deal.play(d);
		temp=deal.getHand().getValue();
		assertTrue(temp>2);
	}
}
