package Maze;

public class Dragon 
{
	private char DRAGON = 'D'; 	//Dragon character
	private int DragonX = 1;	//Dragon position X
	private int DragonY = 3;	//Dragon position Y
	
	public void DragonDeploy(Table table)
	{
		table.DeployPiece(DragonX, DragonY, DRAGON);
	}
	
	public char sleepDragon() 
	{
		DRAGON = 'd';
		return DRAGON;
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
