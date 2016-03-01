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
	
	public void HeroMoveUp(Table table)
	{
		int newposY =  HeroY -1;
		
		if(table.MovePiece(HeroX, HeroY, HeroX, newposY, Hero) == true)
		{
			HeroY = newposY;
		}
	}
	
	public void HeroMoveDown(Table table)
	{
		int newposY =  HeroY +1;
		
		if(table.MovePiece(HeroX, HeroY, HeroX, newposY, Hero) == true)
		{
			HeroY = newposY;
		}
	}
	
	public void HeroMoveLeft(Table table)
	{
		int newposX =  HeroX -1;
		
		if(table.MovePiece(HeroX, HeroY, newposX, HeroY, Hero) == true)
		{
			HeroX = newposX;
		}
	}
	
	public void HeroMoveRight(Table table)
	{
		int newposX =  HeroX +1;
		
		if(table.MovePiece(HeroX, HeroY, newposX, HeroY, Hero) == true)
		{
			HeroX = newposX;
		}
	}
}
