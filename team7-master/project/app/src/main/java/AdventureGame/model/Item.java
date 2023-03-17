package model;

public class Item
{
	private int hitDamage;
	private String itemName;
	
	public Item(String itemName, int hitDamage)
	{
		this.itemName = itemName;
		this.hitDamage = hitDamage;
	}

	public void damage(Enemy e)
	{
		e.reduceHealth(getStats());
	}
	public int getStats()
	{
		return hitDamage;
	}
	public String getItemName()
	{
		return itemName;
	}
}
