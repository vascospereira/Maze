package Maze;

public class Hero 
{
	private char HERO = 'H'; 	//Hero character
	private int HeroX = 1;		//Hero first position X
	private int HeroY = 1;		//Hero first position Y
	
	public int getX()
	{
		return HeroX;
	}
	
	public int getY()
	{
		return HeroY;
	}
	
	public void setCoord(int x, int y)
	{
		HeroX = x;
		HeroY = y;
	}
	
	public char heroArmed()
	{
		HERO = 'A';
		return HERO;
	}
	
	public char getHeroState()
	{
		return HERO;
	}
	
	public void HeroDeploy(Table table)
	{
		table.DeployPiece(HeroX, HeroY, HERO);
	}
}
