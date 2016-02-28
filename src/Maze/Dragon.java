package Maze;

public class Dragon 
{
	char Dragon = 'D'; //Dragon character
	int DragonX = 1;	//Dragon position X
	int DragonY = 3;	//Dragon position Y
	
	public void DragonDeploy(Table table)
	{
		table.table[DragonY][DragonX] = Dragon;
	}
}
