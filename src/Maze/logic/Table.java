package Maze.logic;

public class Table
{
	public static final char SPACE  = ' ';
	public static final char HERO   = 'H';
	public static final char DRAGON = 'D';
	public static final char EXIT   = 'E';
	public static final char SWORD  = 'S';
	public static final char SLEEPY = 'd';
	public static final char ARMOR  = 'A';
	public static final char DRASWO = 'F';
	public static final char WALL   = 'X';
	
	private char table[][] = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
							{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
							{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
							{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' }, 
							{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
							{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'E' }, 
							{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
							{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' }, 
							{ 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X' },
							{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
	
	public Table() {}
	
	public Table(char[][] newMaze)
	{
		table = newMaze;
	}
	
	public Table(Table table) {
		this.table = table.getTable();
	}

	public char[][] getTable() {
		return table;
	}

	public boolean deployElemTable(int posX, int posY, char c)
	{
		if(table[posY][posX] == ' ')
		{
			table[posY][posX] = c;
			return true;
		}
		else
			return false;
	}
	
	public char getElemTable(int x, int y)
	{
		return table[y][x];
	}

	public void setElemTable(int x, int y, char c)
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

	public void setTable(char[][] mazeTable) {
		table = mazeTable;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < table.length; y++) {
			for (int x = 0; x < table.length; x++) {
				sb.append(table[y][x] + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public Table clone(){
		return new Table(this);
	}
}
