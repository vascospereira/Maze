package Maze;

import java.util.Scanner;

import Maze.GameState.State;

public class Maze {

	public static void main(String[] args) 
	{
		//Creating Table
		Table table = new Table();

		//Creating a new Hero
		Hero hero = new Hero();
		hero.HeroDeploy(table);

		//Creating a new Dragon
		Dragon dragon = new Dragon();
		dragon.DragonDeploy(table);

		//Creating a new Sword
		Sword sword = new Sword();
		sword.SwordDeploy(table);
		
		//Printing Table
		table.PrintTable();
		
		
		//INITIALIZING SCANNER
		Scanner s = new Scanner(System.in);
		char c = s.next().charAt(0);
		
		GameState.setState(State.PLAYING);
		
		while(c != 'F' && c != 'f' && GameState.getState() == State.PLAYING)
		{
			//HERO MOVING ACORDING TO CHAR GIVEN AND PRINTING TABLE
			hero.HeroMove(table, c);
			table.PrintTable();
			
			if(GameState.getState() == State.LOST)
			{
				System.out.println("You Lost!");
				break;
			}
			if(GameState.getState() == State.WON)
			{
				System.out.println("You Win!");
				break;
			}
			
			
			c = s.next().charAt(0);
		}
		
		//Closing Scanner and Returning
		s.close();
		return;
	}

}