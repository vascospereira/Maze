package Maze.logic;

public class Dragon 
{
	private char DRAGON = 'D'; 	//Dragon character
	private int DragonX = 1;	//Dragon position X
	private int DragonY = 3;	//Dragon +position Y
	
	public void DragonDeploy(Table table)
	{
		table.DeployPiece(DragonX, DragonY, DRAGON);
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
		return DragonX;
	}
	
	public int getY()
	{
		return DragonY;
	}
	
	public void setCoord(int x, int y)
	{
		DragonX = x;
		DragonY = y;
	}
}
