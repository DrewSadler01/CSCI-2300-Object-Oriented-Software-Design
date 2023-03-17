package BlackJack.controller;
import BlackJack.model.*;

public interface BlackJackUserInterface
{
   public void enableHit(boolean enable);
   public void enableStand(boolean enable);
   public void showHand(Hand hand, boolean isDealer);
   public void peekHand(Hand hand);
   public boolean playAgain(Result result);
   public void reset();
}
