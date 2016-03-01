package Maze;

import Maze.GameState.State;

public class Table 
{
	private char table[][] = 
		{
				{'X','X','X','X','X','X','X','X','X','X'},
				{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
				{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
				{'X',' ',' ',' ',' ',' ',' ','X',' ','S'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
				{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
				{'X',' ','X','X',' ',' ',' ',' ',' ','X'}, 
				{'X','X','X','X','X','X','X','X','X','X'}
		};
	final int LINE_LENGHT = table[0].length;
	final int COLUMN_LENGTH = table.length;

	public void PrintTable()
	{
		for(int i = 0; i < LINE_LENGHT; i++)
		{
			for(int j = 0; j < COLUMN_LENGTH; j++)
			{
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public boolean MovePiece(int posX, int posY, int nPosX, int nPosY, char c)
	{
		if(table[nPosY][nPosX] == 'E')
		{
			table[posY][posX] = ' ';
			table[nPosY][nPosX] = Hero.heroArmed();
			return true;
		}
		else if(table[nPosY][nPosX] == 'D' && Hero.getHeroState() == 'H')
		{
			table[posY][posX] = ' ';
			table[nPosY][nPosX] = Hero.deadHero();
			table[nPosY][nPosX] = Dragon.getDragonState();
			GameState.setState(State.LOST);
			
			return true;
		}
		else if((table[nPosY][nPosX] == 'D' && Hero.getHeroState() == 'A') ||
				(table[nPosY][nPosX] == 'd' && Hero.getHeroState() == 'H'))
		{
			if (table[nPosY][nPosX] == 'D' && Hero.getHeroState() == 'A') 
			{
				table[posY][posX] = ' ';
				table[nPosY][nPosX] = Dragon.deadDragon();
				table[nPosY][nPosX] = c;
				return true;
			}
			else
			{
				table[posY][posX] = ' ';
				table[nPosY][nPosX] = Dragon.getDragonState();
				table[nPosY][nPosX] = c;
				
				return true;
			}
		}
		else if(table[nPosY][nPosX] == 'S' && Dragon.getDragonState() == ' ')
		{
			table[posY][posX] = ' ';
			table[nPosY][nPosX] = c;
			GameState.setState(State.WON);
			return true;
		}
		else if(table[nPosY][nPosX] == ' ')
		{
			table[posY][posX] = ' ';
			table[nPosY][nPosX] = c;
			return true;
		}
		else
			return false;
	}
	
	public boolean DeployPiece(int posX, int posY, char c)
	{
		if(table[posY][posX] == ' ')
		{
			table[posY][posX] = c;
			return true;
		}
		else
			return false;
	}

}
