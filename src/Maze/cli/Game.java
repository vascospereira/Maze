package Maze.cli;

import java.util.Scanner;

import Maze.logic.Maze;
import Maze.logic.Maze.State;

public class Game {

	public static void main(String[] args) 
	{
		//CREATING OBJECT GAME, INITILIAZE() WILL SET GAME STATE TO PLAYING ALSO
		//WILL ALLOCK MEMORY FOR OBJECTS, DEPLOY THEM AND PRINTING	
		char[][] m1 = { { 'X', 'X', 'X', 'X', 'X' }, 
				{ 'X', ' ', ' ', 'H', 'E' }, 
				{ 'X', ' ', 'X', 'D', 'X' },
				{ 'X', 'S', ' ', ' ', 'X' }, 
				{ 'X', 'X', 'X', 'X', 'X' } };
		
		Maze Maze = new Maze(m1);						
		
		//INITIALIZING SCANNER
		Scanner s = new Scanner(System.in);
		char c = s.next().charAt(0);
		String p = Convert(c);
		
		while(p != "Close" && (Maze.getState() == State.PLAYING || Maze.getState() == State.SLAYED))
		{
			//UPDATING THE GAME ACCORDING TO SCANNER CHARACTER, AND PRINTING GAME
			Maze.UpdateHero(p);
			if(Maze.getState() == State.PLAYING)
			{
				Maze.UpdateDragon();
			}
			
			Maze.Print();		
			
			//CHECKING GAME STATE
			if(Maze.getState() == State.LOST)
			{
				System.out.println("You Lost!");
				break;
			}
			if(Maze.getState() == State.WON)
			{
				System.out.println("You Win!");
				break;
			}
			
			//CONSOLE PROMPT FOR NEXT MOVEMENT
			c = s.next().charAt(0);
			p = Convert(c);
		}
		
		//CLOSING SCANNER AND RETURNING
		s.close();
		return;
	}
	public static String Convert(char c)
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

}