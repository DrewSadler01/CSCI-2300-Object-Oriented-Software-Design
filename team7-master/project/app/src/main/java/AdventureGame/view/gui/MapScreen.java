package view.gui;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import controller.*;

public class MapScreen implements ActionListener
{
    private JTextArea terminal;
    private JTextArea items;
    private String itemList = "";
    private ImageIcon currentMap;
    private JLabel mapLabel;
    private JTextField answerField;
    private World world;
	protected JPanel everything = new JPanel();

	public MapScreen()
	{
	}
	
    public MapScreen(World world)
    {
		this.world = world;
		
        //Inventory panel
        JPanel inventory = new JPanel();
        JLabel invText = new JLabel("Inventory: ");
        invText.setPreferredSize(new Dimension(80, 30));
        JTextArea items = new JTextArea("None");
        items.setPreferredSize(new Dimension(100, 30));
        items.setLineWrap(true);
        this.items = items;
        inventory.add(invText);
		inventory.add(items);

		//Bottom panel (Answer box, inventory, and submit button)
        JPanel bottomPanel = new JPanel();
        JButton submitButton = new JButton("Enter");
        submitButton.setPreferredSize(new Dimension(80, 30));
        submitButton.addActionListener(this);
        JTextField answerField = new JTextField();
        answerField.setPreferredSize(new Dimension(200, 30));
        answerField.addActionListener(this);
        this.answerField = answerField;
        bottomPanel.add(answerField, BorderLayout.WEST);
		bottomPanel.add(submitButton, BorderLayout.CENTER);
		bottomPanel.add(inventory, BorderLayout.EAST);
		
		//Main panel (Map segment)
		JPanel mainPanel = new JPanel();
		URL resource = this.getClass().getClassLoader().getResource("map_part_025.png");
		ImageIcon map = new ImageIcon(resource);
		this.currentMap = map;
		this.currentMap.setDescription("25");
		JLabel mapLabel = new JLabel(map);
		mapLabel.setBounds(1100, 100, 500, 500);
		this.mapLabel = mapLabel;
		mainPanel.add(mapLabel);
		
		//Terminal panel
		JPanel terminalPanel = new JPanel();
		JTextArea terminal = new JTextArea("Welcome to the game! Use the help command if you need assistance.");
        terminal.setPreferredSize(new Dimension(490, 30));
        terminalPanel.add(terminal);
        terminal.setLineWrap(true);
        this.terminal = terminal;
		
		
		//Everything is added to the main frame.
		everything.add(mainPanel, BorderLayout.NORTH);
		everything.add(terminalPanel, BorderLayout.CENTER);
		everything.add(bottomPanel, BorderLayout.SOUTH);
    }

    
    public JPanel getPanel()
    {
        return everything;
    }
    public void moveDown()
	{
		int mapNum = Integer.parseInt(this.currentMap.getDescription());
		if(mapNum>20)
		{
			display("You cannot move south of this point.");
		}
		else
		{
			mapNum += 5;
			String newMap = "map_part_0" + String.valueOf(mapNum) + ".png";
			URL resource = this.getClass().getClassLoader().getResource(newMap);
			ImageIcon map = new ImageIcon(resource);
			this.mapLabel.setIcon(map);
			this.currentMap = map;
			this.currentMap.setDescription(String.valueOf(mapNum));
		}
	}
	public void moveLeft()
	{
		int mapNum = Integer.parseInt(this.currentMap.getDescription());
		if(mapNum == 1 || mapNum == 6 || mapNum == 11 || mapNum == 16 || mapNum == 21)
		{
			display("You cannot move west of this point.");
		}
		else
		{
			mapNum -= 1;
			String newMap = "map_part_0" + String.valueOf(mapNum) + ".png";
			URL resource = this.getClass().getClassLoader().getResource(newMap);
			ImageIcon map = new ImageIcon(resource);
			this.mapLabel.setIcon(map);
			this.currentMap = map;
			this.currentMap.setDescription(String.valueOf(mapNum));
		}
	}
	public void moveUp()
	{
		int mapNum = Integer.parseInt(this.currentMap.getDescription());
		if(mapNum<6)
		{
			display("You cannot move north of this point.");
		}
		else
		{
			mapNum -= 5;
			String newMap = "map_part_0" + String.valueOf(mapNum) + ".png";
			URL resource = this.getClass().getClassLoader().getResource(newMap);
			ImageIcon map = new ImageIcon(resource);
			this.mapLabel.setIcon(map);
			this.currentMap = map;
			this.currentMap.setDescription(String.valueOf(mapNum));
		}
	}
	public void moveRight()
	{
		int mapNum = Integer.parseInt(this.currentMap.getDescription());
		if(mapNum == 5 || mapNum == 10 || mapNum == 15 || mapNum == 20 || mapNum == 25)
		{
			display("You cannot move east of this point.");
		}
		else
		{
			mapNum += 1;
			String newMap = "map_part_0" + String.valueOf(mapNum) + ".png";
			URL resource = this.getClass().getClassLoader().getResource(newMap);
			ImageIcon map = new ImageIcon(resource);
			this.mapLabel.setIcon(map);
			this.currentMap = map;
			this.currentMap.setDescription(String.valueOf(mapNum));
		}
	}
	public void displayItems(String words)
	{
		itemList += (words + ", ");
		this.items.setText(itemList);
	}
	
	public void removeItems(String words)
	{
		itemList = itemList.replace((words + ", "), "");
		this.items.setText(itemList);
	}
	
	public void display(String command)
	{
		this.terminal.setText(command);
	}
	
	public int getMap()
	{
		return Integer.parseInt(this.currentMap.getDescription());
	}
	
	public void setMap(int mapNum)
	{
			String newMap = "map_part_0" + String.valueOf(mapNum) + ".png";
			URL resource = this.getClass().getClassLoader().getResource(newMap);
			ImageIcon map = new ImageIcon(resource);
			this.mapLabel.setIcon(map);
			this.currentMap = map;
			this.currentMap.setDescription(String.valueOf(mapNum));
	}
	
	public void actionPerformed(ActionEvent e)
	{
		world.commands(this.answerField.getText());
	}
	
}
