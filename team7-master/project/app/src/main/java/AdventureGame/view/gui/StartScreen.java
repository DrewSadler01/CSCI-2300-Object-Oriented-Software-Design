package view.gui;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import controller.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.net.URL;

public class StartScreen
{
    private JFrame mainFrame;
    World world = new World();

    public StartScreen()
    {
	//The main frame everyting is put on
        mainFrame = new JFrame("Adventure Game");
        mainFrame.setSize(510, 650);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        
	//Main panel
	JPanel mainPanel = new JPanel();
	URL resource = this.getClass().getClassLoader().getResource("title33small.jpg");
	ImageIcon img = new ImageIcon(resource);
	JLabel imgLabel = new JLabel(img);
	imgLabel.setBounds(500, 100, 500, 500);
	JButton NewGameButton = new JButton("New Game");
	NewGameButton.setPreferredSize(new Dimension(300, 50));
	NewGameButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			world.newGame();
		}});
	JButton LoadButton = new JButton("Load Game");
	LoadButton.setPreferredSize(new Dimension(300, 50));
	LoadButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				world.loadGame();
			}
			catch(IOException error)
			{
				System.out.println(error);
			}
		}});
		
	mainPanel.add(imgLabel, BorderLayout.NORTH);
	mainPanel.add(NewGameButton, BorderLayout.CENTER);
	mainPanel.add(LoadButton, BorderLayout.SOUTH);
		
		
	mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    
    public JFrame getFrame()
    {
        return mainFrame;
    }
}
