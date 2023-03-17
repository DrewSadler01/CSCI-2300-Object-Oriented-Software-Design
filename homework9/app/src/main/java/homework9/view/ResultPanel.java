package view;
import model.*;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.util.ArrayList;

public class ResultPanel extends JPanel
{
   public ResultPanel()
   {
      this.setLayout(new GridBagLayout());
   }
   public void update(ArrayList<Book> books)
   {
      this.removeAll();
      GridBagConstraints c = new GridBagConstraints();
      c.gridwidth = 1;
      c.anchor = GridBagConstraints.LINE_START;
      c.weightx = 0.5;
      for (Book b: books)
      {
         JLabel label = new JLabel(b.toString());
         c.gridx = 1;
         c.gridy = GridBagConstraints.RELATIVE;
         this.add(new JLabel(b.toString()), c);
      }
      this.revalidate();
      this.repaint();
   }
}
