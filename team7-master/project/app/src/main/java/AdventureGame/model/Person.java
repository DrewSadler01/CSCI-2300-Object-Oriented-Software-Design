package model;
import controller.*;

public class Person
{
	private String quest;
	private String speach;
	private World world;

	public Person(World world, String quest, String speach)
	{
		this.world = world;
		this.quest = quest;
		this.speach = speach;
	}
	public String getQuest()
	{
		return quest;
	}
	public String getDialogue()
	{
		return speach;
	}
}
