package view.gui;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import java.awt.event.*;
import java.lang.Thread;
import model.*;
import controller.*;

public class BattleScreen extends MapScreen implements ActionListener
{
	private JTextArea terminal;
	private World world;
	private ImageIcon currentEnemy;
	private int enemyNum;
	private JLabel enemyLabel;
	
    public BattleScreen(World world, Enemy enemy)
    {
        this.world = world;
		Player plyr = this.world.getPlayer();
		Inventory inventory = plyr.getInventory();
		
		//Main panel (Battle Image)
		JPanel mainPanel = new JPanel();
		URL resource = this.getClass().getClassLoader().getResource("battleSample.png");
		ImageIcon currentEnemy = new ImageIcon(resource);
		this.currentEnemy = currentEnemy;
		JLabel enemyLabel = new JLabel(currentEnemy);
		enemyLabel.setBounds(1100, 100, 500, 500);
		this.enemyLabel = enemyLabel;
		mainPanel.add(enemyLabel);
		
		//Terminal panel
		JPanel terminalPanel = new JPanel();
		JTextArea terminal = new JTextArea("Your health: " + plyr.getHealth() + "\tEnemy Health: " + enemy.getHealth());
        terminal.setPreferredSize(new Dimension(490, 30));
        terminalPanel.add(terminal);
        terminal.setLineWrap(true);
        this.terminal = terminal;

	    //Action panel
        JPanel actionPanel = new JPanel();
        JLabel what = new JLabel("What will you do?");
        JButton attackButton = new JButton("Attack");
        attackButton.setPreferredSize(new Dimension(80, 30));
		attackButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			plyr.attack(inventory.getBestWeapon(),enemy);
			if(enemy.isAlive())
			{
				plyr.reduceHealth(enemy.getDamage(enemyNum));
				if(plyr.isAlive())
				{
					battleDisplay("Your health: " + plyr.getHealth() + "\tEnemy Health: " + enemy.getHealth());
				}
				else
				{
					System.out.println("You died...");
					battleDisplay("You died...");
					try
					{
						Thread.sleep(3000);
					}
					catch (Exception ex)
					{
						System.out.println("Exception thrown when sleeping for 3 seconds");
					}
					System.exit(0);
				}
			}
			else
			{
				plyr.win();
			}
		}});
        
	JButton magicButton = new JButton("Magic");
        magicButton.setPreferredSize(new Dimension(80, 30));
	magicButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			plyr.attack(inventory.getBestMagic(),enemy);
			if(enemy.isAlive())
			{
				plyr.reduceHealth(enemy.getDamage(enemyNum));
				if(plyr.isAlive())
				{
					battleDisplay("Your health: " + plyr.getHealth() + "\tEnemy Health: " + enemy.getHealth());
				}
				else
				{
					System.out.println("You died...");
					battleDisplay("You died...");
					try
					{
						Thread.sleep(3000);
					}
					catch (Exception ex)
					{
						System.out.println("Exception thrown when sleeping for 3 seconds");
					}
					System.exit(0);
				}
			}
			else
			{
				plyr.win();
			}
		}});

        JButton itemButton = new JButton("Item");
        itemButton.setPreferredSize(new Dimension(80, 30));
        itemButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			plyr.attack(inventory.getBestItem(),plyr);
			if(enemy.isAlive())
			{
				plyr.reduceHealth(enemy.getDamage(enemyNum));
				if(plyr.isAlive())
				{
					battleDisplay("Your health: " + plyr.getHealth() + "\tEnemy Health: " + enemy.getHealth());
				}
				else
				{
					System.out.println("You died...");
					battleDisplay("You died...");
					try
					{
						Thread.sleep(3000);
					}
					catch (Exception ex)
					{
						System.out.println("Exception thrown when sleeping for 3 seconds");
					}
					System.exit(0);
				}
			}
			else
			{
				plyr.win();
			}
		}});

	JButton fleeButton = new JButton("Flee");
        fleeButton.setPreferredSize(new Dimension(80, 30));
        fleeButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			plyr.flee();
		}});

        JPanel leftActionPanel = new JPanel();
        JPanel rightActionPanel = new JPanel();
        
        leftActionPanel.add(attackButton, BorderLayout.NORTH);
        leftActionPanel.add(itemButton, BorderLayout.SOUTH);
        rightActionPanel.add(magicButton, BorderLayout.NORTH);
        rightActionPanel.add(fleeButton, BorderLayout.SOUTH);
        
        actionPanel.add(what, BorderLayout.WEST);
        actionPanel.add(leftActionPanel, BorderLayout.CENTER);
        actionPanel.add(rightActionPanel, BorderLayout.EAST);
		
		//Everything is added to the main frame.
		everything.add(actionPanel, BorderLayout.SOUTH);
		everything.add(terminalPanel, BorderLayout.CENTER);
		everything.add(mainPanel, BorderLayout.NORTH);
        everything.setVisible(false);
			
		}
		
		public void setEnemy(String enemy)
		{
			if(enemy.equals("greenGuy"))
			{
				this.enemyNum = 1;
			}
			else if(enemy.equals("skeleton"))
			{
				this.enemyNum = 2;
			}
			else if(enemy.equals("slime"))
			{
				this.enemyNum = 3;
			}
			else if(enemy.equals("zombie"))
			{
				this.enemyNum = 4;
			}
			String newEnemy = "enemy0" + String.valueOf(this.enemyNum) + ".png";
			URL resource = this.getClass().getClassLoader().getResource(newEnemy);
			ImageIcon enemyScreen = new ImageIcon(resource);
			this.enemyLabel.setIcon(enemyScreen);
			this.currentEnemy = enemyScreen;
   }
   
   public void battleDisplay(String command)
	{
		this.terminal.setText(command);
	}
   
}
