package model;
import java.util.ArrayList;

public class Inventory
{
	private ArrayList<Item> item;
	private ArrayList<Item> magic;
	private ArrayList<Item> weapon;

	public Inventory()
	{
		this.item = new ArrayList<Item>();
		this.magic = new ArrayList<Item>();
		this.weapon = new ArrayList<Item>();
	}

	public void addWeapon(Item i)
	{
		this.weapon.add(i);
	}

	public void addMagic(Item i)
	{
		this.magic.add(i);
	}

	public void addItem(Item i)
	{
		this.item.add(i);
	}

	public Item getWeapon(String weaponName)
	{
		for (int x = 0; x < weapon.size(); x++)
		{
			if (weapon.get(x).getItemName().equals(weaponName))
			{
				return this.weapon.get(x);
			}
		}
		return null;
	}

	public Item getMagic(String magicName)
	{
		for (int x = 0; x < magic.size(); x++)
		{
			if (magic.get(x).getItemName().equals(magicName))
			{
				return this.magic.get(x);
			}
		}
		return null;
	}

	public Item getItem(String itemName)
	{
		for (int x = 0; x < item.size(); x++)
		{
			if (item.get(x).getItemName().equals(itemName))
			{
				return this.item.get(x);
			}
		}
		return null;
	}
	
	public Item getBestWeapon()
	{
		int max = 0;
		Item bestWeapon = new Item("", 0);
		for (int x = 0; x < weapon.size(); x++)
		{
			if (weapon.get(x).getStats() > max)
			{
				max = weapon.get(x).getStats();
				bestWeapon = weapon.get(x);
			}
		}
		return bestWeapon;
	}
	
	public Item getBestMagic()
	{
		int max = 0;
		Item bestMagic = new Item("", 0);
		for (int x = 0; x < magic.size(); x++)
		{
			if (magic.get(x).getStats() > max)
			{
				max = magic.get(x).getStats();
				bestMagic = magic.get(x);
			}
		}
		return bestMagic;
	}
	
	public Item getBestItem()
	{
		int min = 0;
		Item bestItem = new Item("", 0);
		for (int x = 0; x < item.size(); x++)
		{
			if (item.get(x).getStats() < min)
			{
				min = item.get(x).getStats();
				bestItem = item.get(x);
			}
		}
		return bestItem;
	}

	public ArrayList<Item> getAllWeapons()
	{
		return weapon;
	}

	public ArrayList<Item> getAllMagic()
	{
		return magic;
	}

	public ArrayList<Item> getAllItems()
	{
		return item;
	}
	
	public void removeItem(Item itemName)
	{
		item.remove(itemName);
	}
	
}
