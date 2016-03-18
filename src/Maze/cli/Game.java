package Maze.cli;

import java.util.Scanner;




import Maze.logic.Maze;
import Maze.logic.MazeBuilder;
import Maze.logic.Maze.State;
import Maze.logic.Table;
public class Game {

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		
		int mazeSize = 1;
		int numOfDragons = 1;
		/*
		 * Choose type of Table 
		 */
		do {
			System.out.println("Maze size must be (ODD number >= 5)\n "
					+ "or 0 (zero) for default Maze." );
			if(s.hasNextInt())
			{
				mazeSize = s.nextInt();
			}
			else
				s.next();
			
		} while (mazeSize != 0 && !(mazeSize % 2 == 1 && mazeSize >= 5));
		
		/*
		 * Number of dragons
		 */
		do {
			System.out.println("Number of Dragons <max of 3>? " );
			if(s.hasNextInt())
			{
				numOfDragons = s.nextInt();
			}
			else
				s.next();	
		} while (numOfDragons > 3);
		
		/*
		 * Start Maze
		 */
		Maze maze;
		
		if(mazeSize == 0)
		{
			maze = new Maze();//number of dragons 3
			maze.initialize();
			printTable(maze.getTable());
		}
		else
		{
			maze = new Maze(MazeBuilder.generateMaze(mazeSize), numOfDragons);
			maze.initialize();
			printTable(maze.getTable());
		}
		
		char c = s.next().charAt(0);
		String p = convert(c);
		
		while(p != "Close" && (maze.getState() == State.PLAYING || maze.getState() == State.SLAYED))
		{
			//UPDATING THE GAME ACCORDING TO SCANNER CHARACTER, AND PRINTING GAME
			maze.updateHero(p);
			if(maze.getState() == State.PLAYING)
			{
				maze.updateDragons();
			}
			
			printTable(maze.getTable());
			
			//CHECKING GAME STATE
			if(maze.getState() == State.LOST)
			{
				System.out.println("You Lost!");
				break;
			}
			if(maze.getState() == State.WON)
			{
				System.out.println("You Win!");
				break;
			}
			
			c = s.next().charAt(0);
			p = convert(c);
		}
		
		s.close();
		return;
	}

	private static String convert(char c)
	{
		if(c == 'f' || c == 'F')
			return "Close";
		else if(c == 'W' || c == 'w')
			return "Up";
		else if(c == 'A' || c == 'a')
			return "Left";
		else if(c == 'S' || c == 's')
			return "Down";
		else if(c == 'D' || c == 'd')
			return "Right";
		else return "";
		
	}
	
	private static void printTable(Table table)
	{
		for(int y = 0; y < table.getHeight(); y++)
		{
			for(int x = 0; x < table.getWidth(); x++)
			{
				System.out.print(table.getElem(x, y) + " ");
			}
			System.out.println();
		}
	}

}