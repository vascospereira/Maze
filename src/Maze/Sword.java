package Maze;

public class Sword 
{
	private char Sword = 'E'; //Dragon character
	private int SwordX = 1;	//Dragon position X
	private int SwordY = 8;	//Dragon position Y
	
	public void SwordDeploy(Table table)
	{
		table.DeployPiece(SwordX, SwordY, Sword);
	}
}
