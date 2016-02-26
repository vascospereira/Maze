package Maze;

public class Table 
{

	static char table[][] = 
		{
				{'X','X','X','X','X','X','X','X','X','X'},
				{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
				{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
				{'X',' ',' ',' ',' ',' ',' ','X',' ',' '},
				{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
				{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
				{'X',' ','X','X',' ',' ',' ',' ',' ','X'}, 
				{'X','X','X','X','X','X','X','X','X','X'}
		};
	static final int LINE_LENGHT = table[0].length;
	static final int COLUMN_LENGTH = table.length;

	public static void PrintTable()
	{
		for(int i = 0; i < LINE_LENGHT; i++)
		{
			for(int j = 0; j < COLUMN_LENGTH; j++)
			{
				System.out.print(table[i][j]);
			}
			System.out.print('\n');
		}
	}

}
