package Maze;

public class Maze {

	public static void main(String[] args) 
	{
		//Creating Table
		Table table = new Table();
	
		//Creating a new Hero
		Hero hero = new Hero();
		hero.HeroPosition(table);
		
		//Printing Table
		table.PrintTable();
		
	}

}