import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;

public class Prototype
{
    private int frameSize = 400;
    private JFrame mainFrame;

    public Prototype(int size)
    {
        this.frameSize = size;

        // top level container for the game
        mainFrame = new JFrame("Black Jack");
        mainFrame.setPreferredSize(new Dimension(frameSize, frameSize*3/2));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // the container representing our card table
        JPanel cardTable = new JPanel();
        cardTable.setLayout(new BoxLayout(cardTable, BoxLayout.Y_AXIS));

        // container to show dealer's hand
        HandPanel dealerHand = new HandPanel("DEALER", frameSize);
        dealerHand.add(new Card(Card.Face.TWO, Card.Suit.CLUBS), true);
        dealerHand.add(new Card(Card.Face.JACK, Card.Suit.HEARTS), false);

        // container to show user's hand
        HandPanel userHand = new HandPanel("YOU", frameSize);
        userHand.add(new Card(Card.Face.ACE, Card.Suit.DIAMONDS), true);
        userHand.add(new Card(Card.Face.QUEEN, Card.Suit.SPADES), true);

        // place dealer's and user's hands on the card table
        cardTable.add(dealerHand);
        cardTable.add(userHand);

        // container for buttons
        JPanel controlPanel = new JPanel();
        JButton hit = new JButton("Hit");
        JButton stand = new JButton("Stand");
        controlPanel.add(hit);
        controlPanel.add(stand);
        cardTable.add(controlPanel);

        // place card table into the top level container
        mainFrame.add(cardTable);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    /**
     * Do not remove this meethod
     */
    public JFrame getFrame()
    {
        return mainFrame;
    }
}
