package Maze.logic;

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
	private int  LINE_LENGHT = table[0].length;
	private int  COLUMN_LENGTH = table.length;

	private final char SPACE  =  ' ';
	private final char HERO   =	 'H';
	private final char DRAGON =  'D';
	private final char EXIT   =  'E';
	private final char SWORD  =  'S';
	private final char SLEEPY =  'd';
	private final char ARMOR  =  'A';
	private final char DRASWO =  'F';
	
	public char SPACE()
	{
		return SPACE;
	}
	public char HERO()
	{
		return HERO;
	}
	public char DRAGON()
	{
		return DRAGON;
	}
	public char EXIT()
	{
		return EXIT;
	}
	public char SWORD()
	{
		return SWORD;
	}
	public char ARMOR()
	{
		return ARMOR;
	}
	public char SLEEPY()
	{
		return SLEEPY;
	}
	public char DRASWO()
	{
		return DRASWO;
	}
	

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
	public void assertNewTable(char[][] newMaze)
	{
		table = newMaze;
		LINE_LENGHT = table[0].length;
		COLUMN_LENGTH = table.length;
	}
	public int Column()
	{
		return COLUMN_LENGTH;
	}
	public int Line()
	{
		return LINE_LENGHT;
	}
}
