package model;
import controller.*;

public class Enemy
{
	protected int health;
	World world;
	private int damage;
	
	public Enemy()
	{
	}
	
	public Enemy(World world, int health)
	{
		this.health = health;
		this.world = world;
	}
	
	public void reduceHealth(int damage)
	{
		this.health -= damage;
	}

	public int getHealth()
	{
		return this.health;
	}

	public int getDamage(int enemy)
	{
		if(enemy == 1)
			{
				this.damage = 4;
			}
		else if(enemy == 2)
			{
				this.damage = 1;
			}
		else if(enemy == 3)
			{
				this.damage = 2;
			}
		else if(enemy == 4)
			{
				this.damage = 3;
			}
		return this.damage;
	}
	
	public boolean isAlive()
	{
		if (health <= 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
