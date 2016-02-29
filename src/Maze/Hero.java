package Maze;

public class Hero 
{
	private char Hero = 'H'; //Hero character
	private int HeroX = 1;	//Hero position X
	private int HeroY = 1;	//Hero position Y
	
	public void HeroDeploy(Table table)
	{
		table.table[HeroY][HeroX] = Hero;
	}
	
	public void HeroMoveUp(Table table)
	{
		int newposY =  HeroY -1;
		
		if(table.table[newposY][HeroX] == ' ')
		{
			table.table[HeroY][HeroX] = ' ';
			table.table[newposY][HeroX] = Hero;
			HeroY = newposY;
		}
	}
	
	public void HeroMoveDown(Table table)
	{
		int newposY =  HeroY +1;
		
		if(table.table[newposY][HeroX] == ' ')
		{
			table.table[HeroY][HeroX] = ' ';
			table.table[newposY][HeroX] = Hero;
			HeroY = newposY;
		}
	}
	
	public void HeroMoveLeft(Table table)
	{
		int newposX =  HeroX -1;
		
		if(table.table[HeroY][newposX] == ' ')
		{
			table.table[HeroY][HeroX] = ' ';
			table.table[HeroY][newposX] = Hero;
			HeroX = newposX;
		}
	}
	
	public void HeroMoveRight(Table table)
	{
		int newposX =  HeroX +1;
		
		if(table.table[HeroY][newposX] == ' ')
		{
			table.table[HeroY][HeroX] = ' ';
			table.table[HeroY][newposX] = Hero;
			HeroX = newposX;
		}
	}
}
