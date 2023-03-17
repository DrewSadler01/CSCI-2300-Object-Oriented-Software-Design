package BlackJack.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class DeckTest {
    @Test public void testDealOneCardEmptyDeck() {
        Deck deck = new Deck();
        Player p = new Player();
        try
        {
           for (int i = 0; i < 53; i++)
           {
              deck.dealOneCard(p);
           }
        }
        catch (Exception e)
        {
           assert(false);
        }
    }
}
