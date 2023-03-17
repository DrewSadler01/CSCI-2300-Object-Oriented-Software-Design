package controller;

import java.util.ArrayList;
import java.util.Scanner;
import view.gui.*;
import model.*;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

public class World
{
	private Window window;
	private MapScreen mps;
	private BattleScreen bts;
	private Boolean isBattle = false;
	private String[] commands;
	private Player player;
	private Inventory inventory;
	private int[] progress = new int[]{0,0};
	private Enemy[] enemies = new Enemy[6];
	private Person[] villagers = new Person[3];
	private boolean[] quests = new boolean[]{false,false,false};
	
	public World()
	{
	}

	public void newGame()
	{
		MapScreen mps = new MapScreen(this);
		window = new Window(mps.getPanel());
		this.mps = mps;
	
		this.inventory = new Inventory();
		this.inventory.addWeapon(new Item("sword",3));
		mps.displayItems("sword");
		this.inventory.addMagic(new Item("fire",5));
		mps.displayItems("fire");
		this.inventory.addItem(new Item("weak potion",-10));
		mps.displayItems("weak potion");

		addPlayer(20, progress, inventory);
		addEnemy(0, 5);
		addEnemy(1, 10);
		addEnemy(2, 10);
		addEnemy(3, 20);
		addEnemy(4, 20);
		addEnemy(5, 40);
		addNPC(0, "Help! I lost my favorite frog. Please retrieve him from the pond to the west!","Hello Wanderer! Rest up as much as you like in our town, we always appreciate the occasional adventurer!");
		addNPC(1, "Thank you for stopping by at our town, Could you help me find my daughter's lost doll? It should be south of here.", "Come here and rest a while, you look beaten and bruised.");
		addNPC(2, "Please help me find some apples! There should be some along the river to the north-west.", "Good evening adventurer! I hope we may have a peaceful day among all the chaos of monsters in the country.");
	}

	public void loadGame() throws IOException
	{
		MapScreen mps = new MapScreen(this);
		window = new Window(mps.getPanel());
		this.mps = mps;

		int location = 0; 
		int health = 0;
		this.inventory = new Inventory();
		boolean[] quests,enemies;

		File loadFile = new File("save.txt");
		Scanner reader = new Scanner(loadFile);
		while(reader.hasNextLine())
		{
			String data = reader.nextLine();
			System.out.println(data);
			String []parts = data.split(";");
			if(parts[0].equals("Location"))
			{
				location = Integer.valueOf(parts[1]);
				mps.setMap(location);
			}
			else if(parts[0].equals("Health"))
			{
				health = Integer.valueOf(parts[1]);
			}
			else if(parts[0].equals("Weapons"))
			{
				for(int j=1;j<parts.length;j++)
				{
					String []subparts = parts[j].split(",");
					this.inventory.addWeapon(new Item(subparts[0],Integer.parseInt(subparts[1])));
					mps.displayItems(subparts[0]);
				}
			}
			else if(parts[0].equals("Magic"))
			{
				for(int j=1;j<parts.length;j++)
				{
					String []subparts = parts[j].split(",");
					this.inventory.addMagic(new Item(subparts[0],Integer.parseInt(subparts[1])));
					mps.displayItems(subparts[0]);
				}
			}
			else if(parts[0].equals("Items"))
			{
				for(int j=1;j<parts.length;j++)
				{
					String []subparts = parts[j].split(",");
					this.inventory.addItem(new Item(subparts[0],Integer.parseInt(subparts[1])));
					mps.displayItems(subparts[0]);
				}
			}
			else if(parts[0].equals("Quests"))
			{
				String []subparts = parts[1].split(",");
				for(int j=0;j<subparts.length;j++)
				{
					if(Boolean.valueOf(subparts[j]))
					{
						this.progress[1]++;
						this.quests[j] = true;
					}
				}
			}
			else if(parts[0].equals("Enemies"))
			{
				String []subparts = parts[1].split(",");
				for(int j=0;j<subparts.length;j++)
				{
					if(!Boolean.valueOf(subparts[j]))
					{
						if(j==0)
						{
							addEnemy(j, 5);
						}
						else if(j==1 || j==2)
						{
							addEnemy(j,10);
						}
						else if(j==3 || j==4)
						{
							addEnemy(j,20);
						}
						else if(j==5)
						{
							addEnemy(j,40);
						}
					}
					else
					{
						addEnemy(j, -1);
						this.progress[0]++;
					}
				}
			}
		}
		addPlayer(health,progress,inventory);
		System.out.println(this.progress[0]);
		System.out.println(this.progress[1]);
				
		addNPC(0, "Help! I lost my favorite frog. Please retrieve him from the pond to the west!","Hello Wanderer! Rest up as much as you like in our town, we always appreciate the occasional adventurer!");
		addNPC(1, "Thank you for stopping by at our town, Could you help me find my daughter's lost doll? It should be south of here.", "Come here and rest a while, you look beaten and bruised.");
		addNPC(2, "Please help me find some apples! There should be some along the river to the north-west.", "Good evening adventurer! I hope we may have a peaceful day among all the chaos of monsters in the country.");
	}

	public void commands(String command)
	{
 		if (command.equals("go north"))
 		{
			mps.moveUp();
		}
		else if (command.equals("go east"))
		{
			mps.moveRight();
		}
		else if (command.equals("go south"))
		{
			mps.moveDown();
		}
		else if (command.equals("go west"))
		{
			mps.moveLeft();
		}
		else if (command.equals("help"))
        {
           help();
        }
        else if (command.equals("attack"))
        {
			if(mps.getMap() == 22 && enemies[1].isAlive())
			{
				this.bts = new BattleScreen(this,enemies[1]);
				window.addPanel(this.bts.getPanel(),false);
				this.isBattle = true;
				bts.setEnemy("slime");
				changeScreen(isBattle);
			}
			else if(mps.getMap() == 21 && enemies[2].isAlive())
			{
				this.bts = new BattleScreen(this,enemies[2]);
				window.addPanel(this.bts.getPanel(),false);
				this.isBattle = true;
				bts.setEnemy("slime");
				changeScreen(isBattle);
			}
			else if(mps.getMap() == 11 && enemies[3].isAlive())
			{
				this.bts = new BattleScreen(this,enemies[3]);
				window.addPanel(this.bts.getPanel(),false);
				this.isBattle = true;
				bts.setEnemy("zombie");
				changeScreen(isBattle);
			}
			else if(mps.getMap() == 3 && enemies[4].isAlive())
			{
				this.bts = new BattleScreen(this,enemies[4]);
				window.addPanel(this.bts.getPanel(),false);
				this.isBattle = true;
				bts.setEnemy("zombie");
				changeScreen(isBattle);
			}
			else if(mps.getMap() == 13 && enemies[5].isAlive())
			{
				this.bts = new BattleScreen(this,enemies[5]);
				window.addPanel(this.bts.getPanel(),false);
				this.isBattle = true;
				bts.setEnemy("greenGuy");
				changeScreen(isBattle);
			}
			else if(mps.getMap() == 23 && enemies[0].isAlive())
			{
				this.bts = new BattleScreen(this,enemies[0]);
				window.addPanel(this.bts.getPanel(),false);
				this.isBattle = true;
				bts.setEnemy("skeleton");
				changeScreen(isBattle);
			}
			else
			{
				mps.display("There are no enemies here...");
			}
        }
        else if (command.equals("check progress"))
        {
           checkProgress(player.getProgress());
        }
        else if (command.equals("talk"))
        {
           if(mps.getMap() == 5)
           {
			   mps.display(villagers[0].getDialogue());
		   }
		   else if(mps.getMap() == 15)
           {
			   mps.display(villagers[1].getDialogue());
		   }
		   else if(mps.getMap() == 24)
           {
			   mps.display(villagers[2].getDialogue());
		   }
		   else
           {
			   mps.display("There is nobody here...");
		   }
        }
        else if (command.equals("ask quest"))
        {
           if(mps.getMap() == 5)
           {
			   if (this.inventory.getItem("frog") != null && quests[0] == false)
			   {
				   mps.display("Thank you so much for finding him! Please take this as a reward.");
				   player.addProgress(1);
				   quests[0] = true;
				   this.inventory.removeItem(this.inventory.getItem("frog"));
				   mps.removeItems("frog");
				   this.inventory.addWeapon(new Item("great sword",7));
				   mps.displayItems("great sword");
			   }
			   else
			   {
				   mps.display(villagers[0].getQuest());
			   }
		   }
		   else if(mps.getMap() == 15)
           {
			   if (this.inventory.getItem("doll") != null && quests[1] == false)
			   {
				   mps.display("You are a life saver. My daughter will be so happy. Please take this as a reward.");
				   player.addProgress(1);
				   quests[1] = true;
				   this.inventory.removeItem(this.inventory.getItem("doll"));
				   mps.removeItems("doll");
				   this.inventory.addMagic(new Item("ice",10));
				   mps.displayItems("ice");
			   }
			   else
			   {
				   mps.display(villagers[1].getQuest());
			   }
		   }
		   else if(mps.getMap() == 24)
           {
			   if (this.inventory.getItem("apples") != null && quests[2] == false)
			   {
				   mps.display("These apples will be perfect. Thank you so much! Please accept this reward.");
				   player.addProgress(1);
				   quests[2] = true;
				   this.inventory.removeItem(this.inventory.getItem("apples"));
				   mps.removeItems("apples");
				   this.inventory.addWeapon(new Item("strong potion",-20));
				   mps.displayItems("strong potion");
			   }
			   else
			   {
				   mps.display(villagers[2].getQuest());
			   }
		   }
		   else
           {
			   mps.display("There is nobody here...");
		   }
        }
        else if (command.equals("interact"))
		{
			if(mps.getMap() == 7 && this.inventory.getItem("apples") == null && quests[2] == false) //quest for village 24
            {
			   this.inventory.addItem(new Item("apples",1));
			   mps.display("You found some apples");
			   mps.displayItems("apples");
		    }
			else if(mps.getMap() == 20 && this.inventory.getItem("doll") == null && quests[1] == false) //quest for village 15
            {
			   this.inventory.addItem(new Item("doll",0));
			   mps.display("You found a doll");
			   mps.displayItems("doll");
		    }
		    else if(mps.getMap() == 4 && this.inventory.getItem("frog") == null && quests[0] == false) //quest for village 5
            {
			   this.inventory.addItem(new Item("frog",2));
			   mps.display("You found a large frog");
			   mps.displayItems("frog");
		    }
		    else
		    {
				mps.display("There does not seem to be anything here...");
			}
        }

	else if(command.equals("save"))
	{
		try
		{
			save();
			mps.display("saving");
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
        else
        {
		   mps.display("That does not seem like a command. Use 'help' if you need.");
	    }
		
	}

	public void help()
	{
		mps.display("go north, go south, go west, go east, interact, ask quest, talk, check progress, attack");
	}
	
	public void checkProgress(int[] prog)
	{
 		mps.display("Combat Progress: " + prog[0] + "\tQuesting Progress: " + prog[1]);
	}

	public void addPlayer(int health, int[] prog, Inventory inv)
	{
		Player player = new Player(this, health, prog, inv);
		this.player = player;
	}
	public void addEnemy(int x, int health)
	{
		Enemy enemy = new Enemy(this, health);
		this.enemies[x] = enemy;
	}
	public void addNPC(int x, String quest, String speach)
	{
		Person person = new Person(this, quest, speach);
		this.villagers[x] = person;
	}
	public void changeScreen(Boolean isBattleScreen)
	{
		if(isBattleScreen)
		{
			window.setVisible("battle");
		}
		else
		{
			window.setVisible("map");
		}
	}
	public MapScreen getMapScreen()
	{
		return mps;
	}
	public Player getPlayer()
	{
		return player;
	}

	public void save() throws IOException
	{
		File saveFile = new File("save.txt");
		saveFile.createNewFile();
		FileWriter myWriter = new FileWriter(saveFile);
		
		myWriter.write("Location;"+String.valueOf(mps.getMap())+"\n");

		myWriter.write("Health;"+String.valueOf(player.getHealth())+"\n");
		
		myWriter.write("Weapons;");
		ArrayList<Item> allWeapons = inventory.getAllWeapons();
		writeArray(allWeapons,myWriter);

		myWriter.write("Magic;");
		ArrayList<Item> allMagic = inventory.getAllMagic();
		writeArray(allMagic,myWriter);

		myWriter.write("Items;");
		ArrayList<Item> allItems = inventory.getAllItems();
		writeArray(allItems,myWriter);

		myWriter.write("Quests;");
		for(int i=0;i<quests.length;i++)
		{
			myWriter.write(String.valueOf(quests[i]));

			if(i<quests.length-1)
			{
				myWriter.write(",");
			}
			else
			{
				myWriter.write("\n");
			}
		}

		myWriter.write("Enemies;");
		for(int i=0;i<enemies.length;i++)
		{
			if(enemies[i].isAlive())
			{
				myWriter.write("false");
			}
			else
			{
				myWriter.write("true");
			}

			if(i<enemies.length-1)
			{
				myWriter.write(",");
			}
			else
			{
				myWriter.write("\n");
			}
		}
		myWriter.close();
	}

	public void writeArray(ArrayList<Item> al, FileWriter mywrtr) throws IOException
	{
		for(int j=0;j<al.size();j++)
		{
			mywrtr.write(al.get(j).getItemName());
			mywrtr.write(",");
			mywrtr.write(String.valueOf(al.get(j).getStats()));

			if(j<al.size()-1)
			{
				mywrtr.write(";");
			}
			else
			{
				mywrtr.write("\n");
			}
		}
	}
}
