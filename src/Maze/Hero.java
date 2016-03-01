package Maze;

public class Hero 
{
	private char Hero = 'H'; //Hero character
	private int HeroX = 1;	//Hero position X
	private int HeroY = 1;	//Hero position Y
	
	public void HeroDeploy(Table table)
	{
		table.DeployPiece(HeroX, HeroY, Hero);
	}
	
	public boolean HeroMove(Table table, char c)
	{
		if(c == 'W' || c == 'w')
		{
			int newposY =  HeroY -1;
			
			if(table.MovePiece(HeroX, HeroY, HeroX, newposY, Hero) == true)
			{
				HeroY = newposY;
				System.out.println("Up");
				return true;
			}
			return false;
		}
		if(c == 'A' || c == 'a')
		{
			int newposX =  HeroX -1;
			
			if(table.MovePiece(HeroX, HeroY, newposX, HeroY, Hero) == true)
			{
				HeroX = newposX;
				System.out.println("Left");
				return true;
			}
			return false;
			
			
		}
		if(c == 'S' || c == 's')
		{
			int newposY =  HeroY +1;
			
			if(table.MovePiece(HeroX, HeroY, HeroX, newposY, Hero) == true)
			{
				HeroY = newposY;
				System.out.println("Down");
				return true;
			}
			return false;
			
		}
		if(c == 'D' || c == 'd')
		{
			int newposX =  HeroX +1;
			
			if(table.MovePiece(HeroX, HeroY, newposX, HeroY, Hero) == true)
			{
				HeroX = newposX;
				System.out.println("Right");
				return true;
			}
			return false;
			
		}
		return false;
	}
}
