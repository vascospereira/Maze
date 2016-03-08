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
	

	private final char SPACE  =  ' ';
	private final char HERO   =	 'H';
	private final char DRAGON =  'D';
	private final char EXIT   =  'E';
	private final char SWORD  =  'S';
	private final char SLEEPY =  'd';
	private final char ARMOR  =  'A';
	private final char DRASWO =  'F';
	
	Table() {}
	
	Table(char[][] newMaze)
	{
		table = newMaze;
	}
	
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
		for(int i = 0; i < table.length; i++)
		{
			for(int j = 0; j < table[0].length; j++)
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

	public int Column()
	{
		return table.length;
	}
	public int Line()
	{
		return table[0].length;
	}
}
