package BlackJack.view.gui;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;

import BlackJack.model.Card;

public class HandPanel extends JPanel
{
    private JPanel labelPanel;
    private JPanel cardPanel;
    private int width;

    public HandPanel(String title, int width)
    {
        this.setBackground(new Color(53, 101, 77));
        this.width = width;
        labelPanel = new JPanel();
        labelPanel.setOpaque(false);
        cardPanel = new JPanel();
        cardPanel.setOpaque(false);
        this.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(Color.WHITE);
        labelPanel.add(titleLabel);

        this.add(labelPanel, BorderLayout.NORTH);
        this.add(cardPanel, BorderLayout.CENTER);
        
    }
    public void clearCards()
    {
        cardPanel.removeAll();
        cardPanel.revalidate();
        cardPanel.repaint();
    }
    public void add(Card c, boolean show)
    {
        CardIcon cardIcon = new CardIcon(width/5, c);
        cardIcon.setShowFace(show);

        JLabel cardLabel = new JLabel(cardIcon);
        cardPanel.add(cardLabel);
        cardPanel.revalidate();
        cardPanel.repaint();
    }
}
