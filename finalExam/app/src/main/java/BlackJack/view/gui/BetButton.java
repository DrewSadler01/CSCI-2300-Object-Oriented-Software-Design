package BlackJack.view.gui;

import javax.swing.*;
import java.awt.event.*;
import BlackJack.controller.BlackJackController;

public class BetButton extends JButton implements ActionListener
{
   protected int betAmount;
   protected BlackJackController betController;

   public BetButton(int amount, BlackJackController controller)
   {
      super("Bet $" + Integer.toString(amount));
      this.betAmount = amount;
      this.betController = controller;
      this.addActionListener(this);
   }

   public void actionPerformed(ActionEvent e)
   {
      this.betController.placeBet(this.betAmount);      
   }
}
