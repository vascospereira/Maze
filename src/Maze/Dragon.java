package Maze;

public class Dragon 
{
	private static char DRAGON = 'd'; //Dragon character
	private int DragonX = 1;	//Dragon position X
	private int DragonY = 3;	//Dragon position Y
	
	public void DragonDeploy(Table table)
	{
		table.DeployPiece(DragonX, DragonY, DRAGON);
	}
	
	public static char deadDragon()
	{
		DRAGON = ' ';
		return DRAGON;
	}
	
	public static char sleepDragon() 
	{
		DRAGON = 'd';
		return DRAGON;
	}
	
	public static char getDragonState()
	{
		return DRAGON;
	}
}
