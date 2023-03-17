import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;

public class TextWithButton implements ActionListener
{
    JFrame mainFrame;
    JPanel mainPanel;
    JLabel label;
    JTextField answerField;
    JButton submitButton;

	public TextWithButton()
	{
		this.mainFrame = new JFrame("Button Demo");
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainPanel = new JPanel();
		this.mainPanel.setPreferredSize(new Dimension(600, 150));
		this.answerField = new JTextField();
		this.label = new JLabel("");
		this.mainPanel.add(this.label);
		this.answerField.setPreferredSize(new Dimension(600, 50));
		this.mainPanel.add(this.answerField);
		this.submitButton = new JButton("Submit");
		this.submitButton.addActionListener(this);
		this.mainPanel.add(this.submitButton);
		this.mainFrame.add(this.mainPanel); 
		this.mainFrame.pack();
		this.mainFrame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		this.label.setText("You Typed: "+answerField.getText());
		this.answerField.setEnabled(false);
		this.submitButton.setEnabled(false);
		this.mainPanel.repaint();
	}
}
