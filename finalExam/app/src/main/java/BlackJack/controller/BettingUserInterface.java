package BlackJack.controller;

public interface BettingUserInterface
{
   /**
    * Retrieves the initial amount of user's money
    * @return the initial amount of user's money
    */
   public double getStartingMoney();

   /**
    * Shows the remaining user money
    * @param remainingMoney - the remaining amount of money to show
    */
   public void showRemainingMoney(double remainingMoney);

   /**
    * Shows the specified bet amount
    * @param bet - the bet amount to display
    */
   public void showBet(double bet);

   /**
    * Enables or disables betting
    * @param enable - true to enable betting, false to disable
    */
   public void enableBetting(boolean enable);
}
