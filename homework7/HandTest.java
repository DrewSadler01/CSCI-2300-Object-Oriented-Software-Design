import org.junit.*;
import static org.junit.Assert.*;
public class HandTest
{
	@Test
	public void getValueAceEleven()
	{
		Player p = new Player();
		p.getHand().add(new Card(Card.Face.TEN, Card.Suite.CLUBS));
		p.getHand().add(new Card(Card.Face.ACE, Card.Suite.SPADES));
		assertEquals(21 ,p.getHand().getValue());
	}
	@Test
	public void getValueAceOne()
	{
		Player p = new Player();
		p.getHand().add(new Card(Card.Face.TEN, Card.Suite.CLUBS));
		p.getHand().add(new Card(Card.Face.EIGHT, Card.Suite.SPADES));
		p.getHand().add(new Card(Card.Face.ACE, Card.Suite.SPADES));
		assertEquals(19 ,p.getHand().getValue());
	}
	@Test
	public void getValueBlackJack()
	{
		Player p = new Player();
		p.getHand().add(new Card(Card.Face.TEN, Card.Suite.CLUBS));
		p.getHand().add(new Card(Card.Face.TEN, Card.Suite.SPADES));
		p.getHand().add(new Card(Card.Face.ACE, Card.Suite.HEARTS));
		assertEquals(21, p.getHand().getValue());
	}
	@Test
	public void getValueTwoAce()
	{
		Player p = new Player();
		p.getHand().add(new Card(Card.Face.ACE, Card.Suite.CLUBS));
		p.getHand().add(new Card(Card.Face.ACE, Card.Suite.SPADES));
		assertEquals(12, p.getHand().getValue());
	}
}
