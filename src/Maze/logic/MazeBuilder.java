package Maze.logic;
import java.util.ArrayList;

public abstract class MazeBuilder {


	public static char[][] generateMaze(int dimenson) 
	{
		return generator(dimenson, 0.75, 0.75); 
	}


	public static char[][] generator(int size, double complexity, double density) 
	{
		java.util.Random rand = new java.util.Random();
		/*Adjust complexity and density relative to maze size*/
		complexity = (int) (complexity * (5 * (size + size)));
		density = (int) (density * (size / 2 * size / 2));
		boolean maze[][] = new boolean[size][size];

		/*Fill borders*/
		for (int i = 0; i < size; i++) 
		{
			maze[0][i] = maze[size - 1][i] = true;
			maze[i][0] = maze[i][size - 1] = true;
		}
		/*Make aisles*/
		for (int i = 0; i < density; i++) 
		{

			int x = rand.nextInt(size / 2 + 1) * 2;
			int y = rand.nextInt(size / 2 + 1) * 2;
			maze[y][x] = true;

			for (int j = 0; j < complexity; j++) {
				ArrayList<int[]> neighbours = new ArrayList<int[]>();
				if (x > 1) {
					int aux[] = {0, 0};
					aux[0] = y;
					aux[1] = x - 2;
					neighbours.add(aux);
				}
				if (x < size - 2) {
					int aux[] = {0, 0};
					aux[0] = y;
					aux[1] = x + 2;
					neighbours.add(aux);
				}
				if (y > 1) {
					int aux[] = {0, 0}; 
					aux[0] = y - 2;
					aux[1] = x;
					neighbours.add(aux);
				}
				if (y < size - 2) {
					int aux[] = {0, 0};
					aux[0] = y + 2;
					aux[1] = x;
					neighbours.add(aux);
				}

				if (neighbours.size() > 0) {
					int randNeighbour = rand.nextInt(neighbours.size());
					int y_ = neighbours.get(randNeighbour)[0];
					int x_ = neighbours.get(randNeighbour)[1];
					if (maze[y_][x_] == false) {
						maze[y_][x_] = true;
						maze[y_ + (y - y_) / 2][x_ + (x - x_) / 2] = true;
						x = x_;
						y = y_;
					}
				}

			}

		}

		char[][] mazeOfChars = new char[size][size];
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				if (maze[y][x]) {
					mazeOfChars[y][x] = Table.WALL;
				} else {
					mazeOfChars[y][x] = Table.SPACE;
				}
			}
		}
		
		deployExit(size,mazeOfChars);

		return mazeOfChars;
	}


	/*
	 * 
	 * Deploy an exit in the table
	 */
	private static void deployExit(int size, char[][] maze) {

		java.util.Random r = new java.util.Random();
		int side = r.nextInt(4);

		while (true) 
		{
			//System.out.println(side);
			switch (side) {
			case 0: 
				if(testExit(0, r.nextInt(size - 2) + 1, side,maze))
					return;
				break;
			case 1: 
				if(testExit(r.nextInt(size - 2) + 1, 0, side,maze))
					return;
				break;
			case 2: 
				if(testExit(size - 1, r.nextInt(size - 2) + 1, side,maze))
					return;
				break;
			case 3: 
				if(testExit(r.nextInt(size - 2) + 1, size - 1 ,side,maze))
					return;
				break;

			default:
				break;
			}

		}

	}

	/*
	 * Test if exit has a possible position and if true deploys in the table
	 */
	private static boolean testExit(int x, int y, int side, char[][] maze) {
		switch (side) {
		case 0:
			if (maze[y][x + 1] == Table.SPACE) {
				maze[y][x] = Table.EXIT;
				return true;
			} else
				return false;
		case 1:
			if (maze[y + 1][x] == Table.SPACE) {
				maze[y][x] = Table.EXIT;
				return true;
			} else
				return false;
		case 2:
			if (maze[y][x - 1] == Table.SPACE) {
				maze[y][x] = Table.EXIT;
				return true;
			} else
				return false;
		case 3:
			if (maze[y - 1][x] == Table.SPACE) {
				maze[y][x] = Table.EXIT;
				return true;
			} else
				return false;
		default:
			break;
		}
		return false;
	}
}

