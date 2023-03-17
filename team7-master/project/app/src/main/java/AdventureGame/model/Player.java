package model;
import java.util.ArrayList;
import java.util.Random;
import controller.*;
import view.gui.*;

public class Player extends Enemy
{
	Inventory inv;
	int[] progress;
	MapScreen mps;
	
	public Player(World world, int health, int[] progress, Inventory inv)
	{
		this.world = world;
		this.health = health;
		this.progress = progress;
		this.inv = inv;
		this.mps = world.getMapScreen();
	}

	public void attack(Item i, Enemy e)
	{
 		i.damage(e);
	}

	public void flee()
	{
		Random rand = new Random();
		int chanceToFlee = rand.nextInt(100);
 		if(chanceToFlee< 74){
			this.world.changeScreen(false);
		}
	}

	//this method should be in battle screen but creating the action
	//performed methods within the object declaration caused problems;
	//fix at later date
	public void win()
	{
		addProgress(0);
		this.world.changeScreen(false);
	}


	public void talk(Person npc)
	{
		npc.getDialogue();
	}

	public void ask(Person npc)
	{
		npc.getQuest();
 	}
 	
 	public int[] getProgress()
 	{
		return this.progress;
	}

	public Inventory getInventory()
	{
		return this.inv;
	}
	
	public void addProgress(int type)
	{
		if (type == 0)
		{
			this.progress[0] += 1;
			if(this.progress[0] == 6)
			{
				this.mps.display("You have won the battle victory condition!");
			}
		}
		
		else if (type == 1)
		{
			this.progress[1] += 1;
			if(this.progress[1] == 3)
			{
				this.mps.display("You have won the questing victory condition!");
			}
		}
		
		else if (this.progress[0] == 6 && this.progress[1] == 3)
		{
			this.mps.display("You have won with both victory conditions!");
		}
		
		
	}
	
}
