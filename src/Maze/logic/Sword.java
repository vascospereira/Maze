package Maze.logic;
import java.util.Random;

public class Sword 
{
	private char Sword = 'S'; 	//Sword  character
	private int SwordX = 1;		//Sword position X
	private int SwordY = 7;		//Sword position Y
	
	public void swordDeploy(Table table)
	{
		Random r = new Random();
		while(true)
		{
			int x = r.nextInt(table.getHeight() - 2 ) +1;
			int y = r.nextInt(table.getHeight() - 2 ) +1;
			if(table.getElem(x, y) == Table.SPACE)
			{
				table.setElem(x, y, Sword);
				SwordX = x;
				SwordY = y;
				break;
			}
			
		}
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
