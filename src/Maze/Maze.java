package Maze;

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

		//Printing Table
		table.PrintTable();
	}

}