package Maze.cli;

import java.util.Scanner;

import Maze.logic.Maze;
import Maze.logic.Maze.State;
import Maze.logic.Table;

public class Game {

	public static void main(String[] args) 
	{
		//CREATING OBJECT GAME, INITILIAZE() WILL SET GAME STATE TO PLAYING ALSO
		//WILL ALLOCK MEMORY FOR OBJECTS, DEPLOY THEM AND PRINTING	
		
		Maze maze = new Maze();
		maze.initialize();
		printTable(maze.getTable());
		
		//INITIALIZING SCANNER
		Scanner s = new Scanner(System.in);
		char c = s.next().charAt(0);
		String p = convert(c);
		
		while(p != "Close" && (maze.getState() == State.PLAYING || maze.getState() == State.SLAYED))
		{
			//UPDATING THE GAME ACCORDING TO SCANNER CHARACTER, AND PRINTING GAME
			maze.updateHero(p);
			if(maze.getState() == State.PLAYING)
			{
				maze.updateDragon();
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
			
			//CONSOLE PROMPT FOR NEXT MOVEMENT
			c = s.next().charAt(0);
			p = convert(c);
		}
		
		//CLOSING SCANNER AND RETURNING
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