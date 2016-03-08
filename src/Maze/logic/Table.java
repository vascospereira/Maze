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
	

	public static final char SPACE  =  ' ';
	public static final char HERO   =	'H';
	public static final char DRAGON =  'D';
	public static final char EXIT   =  'E';
	public static final char SWORD  =  'S';
	public static final char SLEEPY =  'd';
	public static final char ARMOR  =  'A';
	public static final char DRASWO =  'F';
	
	Table() {}
	
	Table(char[][] newMaze)
	{
		table = newMaze;
	}
	
	/*public char SPACE()
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
	}*/
	

	public void printTable()
	{
		for(int i = 0; i < table.length; i++)
		{
			for(int j = 0; j < table[0].length; j++)
			{
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public boolean deployPiece(int posX, int posY, char c)
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

	public int column()
	{
		return table.length;
	}
	public int line()
	{
		return table[0].length;
	}
}
