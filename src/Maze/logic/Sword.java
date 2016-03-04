package Maze.logic;

public class Sword 
{
	private char Sword = 'S'; 	//Sword  character
	private int SwordX = 1;		//Sword position X
	private int SwordY = 8;		//Sword position Y
	
	public void SwordDeploy(Table table)
	{
		table.DeployPiece(SwordX, SwordY, Sword);
	}
}
