package Maze.logic;

public class Dragon 
{
	private char DRAGON = 'D'; 	//Dragon character
	private int dragonX = 1;	//Dragon position X
	private int dragonY = 3;	//Dragon +position Y
	
	public void dragonDeploy(Table table)
	{
		table.deployPiece(dragonX, dragonY, DRAGON);
	}
	
	public void sleepDragon() 
	{
		DRAGON = 'd';
		//return DRAGON;
	}
	public void awakeDragon() 
	{
		DRAGON = 'D';
		//return DRAGON;
	}
	public void swordDragon()
	{
		DRAGON = 'F';
		//return DRAGON;
	}
	public void noSwordDragon()
	{
		DRAGON = 'D';
		//return DRAGON;
	}
	
	public char getDragonState()
	{
		return DRAGON;
	}
	
	public int getX()
	{
		return dragonX;
	}
	
	public int getY()
	{
		return dragonY;
	}
	
	public void setCoord(int x, int y)
	{
		dragonX = x;
		dragonY = y;
	}
}
