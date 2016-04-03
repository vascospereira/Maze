package Maze.logic;
/**
 * Table Class
 * 
 */
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
	
	/**
	 * Default table constructor
	 */
	public Table() {}
	/**
	 * Table constructor using an existing matrix
	 * @param newMaze
	 */
	public Table(char[][] newMaze)
	{
		table = newMaze;
	}
	/**
	 * Table constructor copying another Table
	 * @param table
	 */
	public Table(Table table) {
		this.table = table.getTable();
	}

	/**
	 * Gets a table created
	 * 
	 * @return a table
	 */
	public char[][] getTable() {
		return table;
	}

	/**
	 * Verifies if is possible to deploy Elements in the table
	 * 
	 * @param posX X position to test
	 * @param posY Y position to test 
	 * @param c Element to be deployed
	 * @return true or false
	 */
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
	
	/**
	 * Gets an Element in the table
	 * 
	 * @param x X position of the Element
	 * @param y Y position of the Element
	 * @return The Element
	 */
	public char getElemTable(int x, int y)
	{
		return table[y][x];
	}

	/**
	 * Sets Element in the table
	 * 
	 * @param x X position
	 * @param y Y position
	 * @param c Element to set
	 */
	public void setElemTable(int x, int y, char c)
	{
		table[y][x] = c;
	}

	/**
	 * Gets height of the table
	 * 
	 * @return Table height
	 */
	public int getHeight()
	{
		return table.length;
	}
	/**
	 * Gets width of the table
	 * 
	 * @return Table width
	 */
	public int getWidth()
	{
		return table[0].length;
	}

	/**
	 * Sets a new table
	 * @param mazeTable Table to set
	 */
	public void setTable(char[][] mazeTable) {
		table = mazeTable;
	}
	/**
	 * @Override toString()
	 */
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
	/**
	 * @Override clone()
	 */
	public Table clone(){
		return new Table(this);
	}
}
