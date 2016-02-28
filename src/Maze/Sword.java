package Maze;

public class Sword 
{
	char Sword = 'S'; //Dragon character
	int SwordX = 1;	//Dragon position X
	int SwordY = 8;	//Dragon position Y
	
	public void SwordDeploy(Table table)
	{
		table.table[SwordY][SwordX] = Sword;
	}
}
