import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CatalogGUI implements CatalogUserInterface
{
   JFrame frame;
   JPanel mainPanel;
   ResultPanel resultPanel;
   JPanel controlPanel;
   JButton searchButton;
   JButton showAllButton;
   JTextField searchTextField;
   public CatalogGUI(int frameSize)
   {

      frame = new JFrame("Book Catalog");
      frame.setPreferredSize(new Dimension(frameSize, frameSize));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
      mainPanel = new JPanel();
      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
      mainPanel.setPreferredSize(new Dimension(frameSize, frameSize));


      controlPanel = new JPanel();
      controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
      controlPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);

      // we'll put the text field and the search button into their own JPanel
      JPanel searchPanel = new JPanel();
      searchTextField = new JTextField();
      searchTextField.setPreferredSize(new Dimension(frameSize/2, 20));
      searchPanel.add(searchTextField, BorderLayout.WEST);
      searchButton = new JButton("Search");
      searchPanel.add(searchButton, BorderLayout.EAST);
      controlPanel.add(searchPanel);

      // create the "show all books" button and add it to control panel
      showAllButton = new JButton("Show all books");
      showAllButton.setPreferredSize(new Dimension(frameSize, 20));
      controlPanel.add(showAllButton);

      mainPanel.add(controlPanel);

      resultPanel = new ResultPanel();
      mainPanel.add(resultPanel);



      frame.add(mainPanel);
      frame.pack();
      frame.setVisible(true);
   }

   public void addSearchListener(ActionListener l)
   {
      searchButton.addActionListener(l);
   }

   public void addShowAllListener(ActionListener l)
   {
      showAllButton.addActionListener(l);
   }

   public String getSearchTerm()
   {
      return searchTextField.getText();
   }

   @Override
   public void showBooks(ArrayList<Book> books)
   {
      resultPanel.update(books);
   }
}
