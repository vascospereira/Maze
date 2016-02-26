package Maze;

public class Table 
{
	char table[][] = 
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

}
