package Maze;

public class Table 
{
	private char table[][] = 
		{
				{'X','X','X','X','X','X','X','X','X','X'},
				{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
				{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
				{'X',' ',' ',' ',' ',' ',' ','X',' ','E'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
				{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
				{'X',' ','X','X',' ',' ',' ',' ',' ','X'}, 
				{'X','X','X','X','X','X','X','X','X','X'}
		};
	final int  LINE_LENGHT = table[0].length;
	final int  COLUMN_LENGTH = table.length;
	
	final char SPACE  =  ' ';
	final char HERO   =	 'H';
	final char DRAGON =  'D';
	final char EXIT   =  'E';
	final char SWORD  =  'S';
	final char SLEEPY =  'd';
	final char ARMOR  =  'A';
	final char DRASWO =  'F';

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
	
	public char getElem(int x, int y)
	{
		return table[y][x];
	}
	
	public void setElem(int x, int y, char c)
	{
		table[y][x] = c;
	}

}
