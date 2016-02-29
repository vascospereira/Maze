package Maze;

public class Dragon 
{
	private char Dragon = 'D'; //Dragon character
	private int DragonX = 1;	//Dragon position X
	private int DragonY = 3;	//Dragon position Y
	
	public void DragonDeploy(Table table)
	{
		table.table[DragonY][DragonX] = Dragon;
	}
}
