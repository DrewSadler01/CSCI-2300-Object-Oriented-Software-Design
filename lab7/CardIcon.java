import javax.swing.*;
import java.awt.*;

public class CardIcon implements Icon
{

   protected int width;
   protected int height;
   protected boolean showFace;
   protected String suitString ="";
   protected String faceString = "";

   protected Color color;

   public CardIcon(int width, Card c)
   {
      this.showFace = true;
      this.width = width;
      this.height = (int)(width * 1.5);
      this.suitString ="";
      this.faceString = "";
      Card.Suit suit = c.getSuit();
      switch (suit)
      {
          case SPADES:
              this.suitString = "\u2660";
              this.color = Color.BLACK;
              break;
          case CLUBS:
              this.suitString = "\u2663";
              this.color = Color.BLACK;
              break;
          case DIAMONDS:
              this.suitString = "\u25C6";
              this.color = Color.RED;
              break;
          case HEARTS:
              this.suitString = "\u2665";
              this.color = Color.RED;
              break;
      }
      Card.Face face = c.getFace();
      switch (face)
      {
          case ACE:
              faceString = "A";
              break;
          case KING:
              faceString = "K";
              break;
          case QUEEN:
              faceString = "Q";
              break;
          case JACK:
              faceString = "J";
              break;
          default:
              faceString = Integer.toString(face.getValue());
      }

   }

   public void setShowFace(boolean showFace)
   {
       this.showFace = showFace;
   }
   @Override 
   public int getIconWidth()
   {
       return this.width;
   }

   @Override
   public int getIconHeight()
   {
       return this.height;
   }
   @Override
   public void paintIcon(Component c, Graphics g, int x, int y)
   {
      // white rectangle represents the card background
      g.setColor(Color.WHITE);
      g.fillRect(x, y, this.width, this.height);
      g.setColor(Color.BLACK);
      Rectangle r = new Rectangle(this.width, this.height);
      g.drawRect(0,0,this.width, this.height);


      if (this.showFace)
      {
          // Suit
          g.setFont(new Font("Symbola",Font.PLAIN,this.height/4));
          g.setColor(this.color);
          g.drawString(suitString, x+0, y+this.height/4);

          // Card face
          g.setFont(new Font("Symbola",Font.BOLD,this.height/3));
          g.drawString(faceString, this.width/3, this.height*2/3);
      }
      else
      {
          g.setColor(Color.RED);
          g.fillRect(this.width/8, this.height/8, this.width*6/8, this.height*6/8);
          // TODO: draw a smaller filled red rectangle on top of the card, 
          // to represent the card face down

      }     
   }
}
