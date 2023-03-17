package BlackJack.view.gui;

import javax.swing.*;
import java.text.DecimalFormat;

import BlackJack.controller.BettingUserInterface;
import BlackJack.controller.BlackJackController;

public class BettingZone extends JPanel implements BettingUserInterface
{

   protected JLabel currentMoney;
   protected JLabel currentBet;
   protected double startingMoney;
   protected JButton oneDollar;
   protected JButton twoDollars;
   protected JButton threeDollars;

   private static DecimalFormat moneyFormatter = new DecimalFormat("#.##");

   public BettingZone(BlackJackController controller, double startingMoney)
   {
      this.startingMoney = startingMoney;
      this.currentMoney = new JLabel();
      showRemainingMoney(startingMoney);
      this.currentBet = new JLabel();
      showBet(0);

      controller.addBettingUserInterface(this);

      oneDollar = new BetButton(1, controller);
      twoDollars = new BetButton(2, controller);
      threeDollars = new BetButton(3, controller);

      this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

      JPanel buttonPanel = new JPanel();
      buttonPanel.add(this.oneDollar);
      buttonPanel.add(this.twoDollars);
      buttonPanel.add(this.threeDollars);
      this.add(buttonPanel);

      JPanel moneyPanel = new JPanel();
      moneyPanel.add(this.currentMoney);
      moneyPanel.add(this.currentBet);
      this.add(moneyPanel);
      this.revalidate();
      this.repaint();
   }

   @Override
   public void enableBetting(boolean enable)
   {
      oneDollar.setEnabled(enable);
      twoDollars.setEnabled(enable);
      threeDollars.setEnabled(enable);
   }

   @Override
   public double getStartingMoney()
   {
      return this.startingMoney;
   }

   @Override
   public void showRemainingMoney(double money)
   {
      System.out.println("Showing " + money);
      this.currentMoney.setText("You have $" + moneyFormatter.format(money));
      this.revalidate();
      this.repaint();
   }

   @Override
   public void showBet(double bet)
   {
      if (bet > 0)
      {
         this.currentBet.setText("You bet $" + moneyFormatter.format(bet));
      }
      else
      {
         this.currentBet.setText("");
      }
      this.revalidate();
      this.repaint();
   }
}
