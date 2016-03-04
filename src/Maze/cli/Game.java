package Maze.cli;

import java.util.Scanner;

import Maze.logic.Maze;
import Maze.logic.Maze.State;

public class Game {

	public static void main(String[] args) 
	{
		//CREATING OBJECT GAME, INITILIAZE() WILL SET GAME STATE TO PLAYING ALSO
		//WILL ALLOCK MEMORY FOR OBJECTS, DEPLOY THEM AND PRINTING						
		Maze Maze = new Maze();						
		Maze.Initialize(); 							
		
		//INITIALIZING SCANNER
		Scanner s = new Scanner(System.in);
		char c = s.next().charAt(0);
		
		while(c != 'F' && c != 'f' && (Maze.getState() == State.PLAYING || Maze.getState() == State.SLAYED))
		{
			//UPDATING THE GAME ACCORDING TO SCANNER CHARACTER, AND PRINTING GAME
			Maze.UpdateHero(c);
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
		}
		
		//CLOSING SCANNER AND RETURNING
		s.close();
		return;
	}

}