package Maze.logic;
import java.util.ArrayList;

public abstract class MazeBuilder {

  
    public static void generateMaze(int dimenson, Table maze) 
    {
        char[][] mazeTable = generator(dimenson, 0.75, 0.75);
        maze.setTable(mazeTable);    
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
                    mazeOfChars[y][x] = 'X';
                } else {
                    mazeOfChars[y][x] = ' ';
                }
            }
        }
        
        for (int y = 0; y < size; y++) 
        {
			for (int x = 0; x < size; x++) 
			{
				if(!(x == 0 || x == (size - 1)) && (y == 0 || y == (size - 1)))
				{
					//if((x != 0 || x != (size - 1)) && (y != 0 || y != (size - 1)))
					//{
						
						mazeOfChars[y][x] = 'E';
					//}
				}
			}
		}
        return mazeOfChars;
    }
}