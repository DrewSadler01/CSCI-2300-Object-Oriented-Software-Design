package view.gui;
import javax.swing.*;
import java.awt.*;

public class Window
{
	private JFrame mainFrame;
	private JPanel mapScreenPanel;
	private JPanel battleScreenPanel;
	
	public Window(JPanel mapPanel)
	{
		this.mapScreenPanel = mapPanel;
		this.mapScreenPanel.setVisible(true);
		mainFrame = new JFrame("Adventure Game");
		mainFrame.setSize(510, 650);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.add(this.mapScreenPanel);
	}

	public JFrame getFrame()
	{
		return mainFrame;
	}

	public void addPanel(JPanel panel, Boolean isMapScreen)
	{
		if(isMapScreen)
		{
			this.mapScreenPanel = panel;
		}
		else
		{
			this.battleScreenPanel = panel;
		}
		mainFrame.add(panel);
	}

	public void setVisible(String s)
	{
		if(s == "map")
		{
			this.mapScreenPanel.setVisible(true);
			this.battleScreenPanel.setVisible(false);
		} 
		else if (s == "battle")
		{
			this.battleScreenPanel.setVisible(true);
			this.mapScreenPanel.setVisible(false);
		}
		else
		{
			System.out.println("panel not found; \"map\" or \"battle\"");
		}
	}
/*
	public setInvisible(String s)
	{
		if(s == "map")
		{
			this.mapScreenPanel.setVisible(false);
		}
		else if (s == "battle")
		{
			this.battleScreenPanel.setVisible(false);
		}
		else
		{
			System.out.println("panel not found; \"map\" or \"battle\"");
		}
	}
*/
}
