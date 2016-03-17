package Maze.logic;

public class Sword 
{
	private char Sword = 'S'; 	//Sword  character
	private int SwordX = 1;		//Sword position X
	private int SwordY = 7;		//Sword position Y
	
	public void swordDeploy(Table table)
	{
		table.deployPiece(SwordX, SwordY, Sword);
	}
	
	public void setCoord(int x, int y)
	{
		SwordX = x;
		SwordY = y;
	}
	public int getX()
	{
		return SwordX;
	}
	public int getY()
	{
		return SwordY;
	}
}
