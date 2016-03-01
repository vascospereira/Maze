package Maze;

import java.util.Scanner;

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
		
		while(c != 'F' && c != 'f')
		{
			//HERO MOVING ACORDING TO CHAR GIVEN AND PRINTING TABLE
			hero.HeroMove(table, c);
			table.PrintTable();
			
			c = s.next().charAt(0);
		}
		
		//Closing Scanner and Returning
		s.close();
		return;
	}

}