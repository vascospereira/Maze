package Maze.logic;

public class Table 
{
	private static int tableDim;
	
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
	

	public static final char SPACE  = ' ';
	public static final char HERO   = 'H';
	public static final char DRAGON = 'D';
	public static final char EXIT   = 'E';
	public static final char SWORD  = 'S';
	public static final char SLEEPY = 'd';
	public static final char ARMOR  = 'A';
	public static final char DRASWO = 'F';
	
	Table() {}
	
	Table(char[][] newMaze)
	{
		table = newMaze;
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

	public int getHeight()
	{
		return table.length;
	}
	public int getWidth()
	{
		return table[0].length;
	}

	public static void setTableDim(int dimenson) {
		tableDim = dimenson;
	}
	public static int getTableDim()
	{
		return tableDim;
	}

	public void setTable(char[][] mazeTable) {

		table = mazeTable;
		
	}
	public char[][] getTable()
	{
		return table;
	}
}
