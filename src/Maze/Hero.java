package Maze;

public class Hero 
{
	private static char HERO = 'H'; //Hero character
	private int HeroX = 1;	//Hero position X
	private int HeroY = 1;	//Hero position Y
	
	static public char heroArmed()
	{
		HERO = 'A';
		return HERO;
	}
	
	static public char getHeroState()
	{
		return HERO;
	}
	
	public void HeroDeploy(Table table)
	{
		table.DeployPiece(HeroX, HeroY, HERO);
	}
	
	public boolean HeroMove(Table table, char c)
	{
		if(c == 'W' || c == 'w')
		{
			int newPosY =  HeroY - 1;
			
			if(table.MovePiece(HeroX, HeroY, HeroX, newPosY, HERO) == true)
			{
				HeroY = newPosY;
				System.out.println("Up");
				return true;
			}
			return false;
		}
		if(c == 'A' || c == 'a')
		{
			int newPosX =  HeroX - 1;
			
			if(table.MovePiece(HeroX, HeroY, newPosX, HeroY, HERO) == true)
			{
				HeroX = newPosX;
				System.out.println("Left");
				return true;
			}
			return false;
			
			
		}
		if(c == 'S' || c == 's')
		{
			int newPosY =  HeroY + 1;
			
			if(table.MovePiece(HeroX, HeroY, HeroX, newPosY, HERO) == true)
			{
				HeroY = newPosY;
				System.out.println("Down");
				return true;
			}
			return false;
			
		}
		if(c == 'D' || c == 'd')
		{
			int newPosX =  HeroX + 1;
			
			if(table.MovePiece(HeroX, HeroY, newPosX, HeroY, HERO) == true)
			{
				HeroX = newPosX;
				System.out.println("Right");
				return true;
			}
			return false;
			
		}
		return false;
	}
}
